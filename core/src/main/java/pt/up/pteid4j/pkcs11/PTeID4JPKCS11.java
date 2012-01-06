package pt.up.pteid4j.pkcs11;

import java.io.IOException;

import org.apache.log4j.Logger;

import sun.security.pkcs11.wrapper.CK_ATTRIBUTE;
import sun.security.pkcs11.wrapper.CK_MECHANISM;
import sun.security.pkcs11.wrapper.CK_SLOT_INFO;
import sun.security.pkcs11.wrapper.CK_TOKEN_INFO;
import sun.security.pkcs11.wrapper.PKCS11;
import sun.security.pkcs11.wrapper.PKCS11Constants;
import sun.security.pkcs11.wrapper.PKCS11Exception;

/**
 * PTeID4J PKCS#11 Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public final class PTeID4JPKCS11 {

  private static Logger logger = Logger.getLogger(PTeID4JPKCS11.class);

  private static PTeID4JPKCS11 instance;

  private long slotId;

  private PKCS11 pkcs11;

  /**
   * Class Constructor
   * 
   */
  private PTeID4JPKCS11() {

    try {
      this.init();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (PKCS11Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Initializes the PTeID4J PKCS#11
   * 
   * @throws IOException
   * @throws PKCS11Exception
   */
  private void init() throws IOException, PKCS11Exception {

    this.pkcs11 = PKCS11.getInstance("pteidpkcs11.dll", "C_GetFunctionList", null, false);

    long[] slotIds = this.pkcs11.C_GetSlotList(false);

    for (long slotId : slotIds) {

      CK_SLOT_INFO slotInfo = this.pkcs11.C_GetSlotInfo(slotId);

      if ( (slotInfo.flags & PKCS11Constants.CKF_TOKEN_PRESENT) != 0 ) {

        CK_TOKEN_INFO tokenInfo;

        try {

          tokenInfo = this.pkcs11.C_GetTokenInfo(slotId);

        } catch (PKCS11Exception e) {

          continue;
        }

        if ( new String(tokenInfo.label).startsWith("CARTAO DE CIDADAO") ) {

          this.slotId = slotId;

          logger.debug("Portuguese Citizen Card Reader found in Slot " + this.slotId + ".");

          break;
        }
      }
    }
  }

  @SuppressWarnings("unused")
  private long getAuthenticationHandle(long session) throws PKCS11Exception {

    try {

      this.pkcs11.C_FindObjectsInit(session, getCKAttributes(PKCS11Constants.CKO_PRIVATE_KEY, "CITIZEN AUTHENTICATION KEY"));

      long[] handles = this.pkcs11.C_FindObjects(session, 2);

      if ( handles == null || handles.length == 0 ) {

        throw new RuntimeException("No Authentication Handle was found.");
      }
      else if ( handles.length > 1 ) {

        throw new RuntimeException("More than one Authentication Handle were found.");
      }

      return handles[0];

    } finally {

      this.pkcs11.C_FindObjectsFinal(session);
    }
  }

  /**
   * Returns the PTeID4J PKCS#11 Instance
   * 
   * @return the PTeID4J PKCS#11 Instance
   */
  public static PTeID4JPKCS11 getInstance() {

    if ( instance == null ) {

      instance = new PTeID4JPKCS11();
    }

    return instance;
  }

  /**
   * 
   * 
   * @param ckaClass
   * @param ckaLabel
   * @return
   */
  private static CK_ATTRIBUTE[] getCKAttributes(long ckaClass, String ckaLabel) {

    CK_ATTRIBUTE[] attributes = new CK_ATTRIBUTE[2];

    attributes[0] = new CK_ATTRIBUTE();
    attributes[0].type = PKCS11Constants.CKA_CLASS;
    attributes[0].pValue = ckaClass;

    attributes[1] = new CK_ATTRIBUTE();
    attributes[1].type = PKCS11Constants.CKA_LABEL;
    attributes[1].pValue = ckaLabel;

    return attributes;
  }
  
  /*private static CK_MECHANISM getCKMechanism(long mechanism) {
    
    CK_MECHANISM ckMechanism = new CK_MECHANISM();
    
    mechanismCK.mechanism = mechanism;
    mechanismCK.pParameter = null;
    
    return mechanismCK;
  }*/

  private long getSignatureHandle(long session) throws PKCS11Exception {

    try {

      this.pkcs11.C_FindObjectsInit(session, getCKAttributes(PKCS11Constants.CKO_PRIVATE_KEY, "CITIZEN SIGNATURE KEY"));

      long[] handles = this.pkcs11.C_FindObjects(session, 2);

      if ( handles == null || handles.length == 0 ) {

        throw new RuntimeException("No Signature Handle was found.");
      }
      else if ( handles.length > 1 ) {

        throw new RuntimeException("More than one Signature Handle were found.");
      }

      return handles[0];

    } finally {

      this.pkcs11.C_FindObjectsFinal(session);
    }
  }

  public byte[] sign(byte[] digest) throws PKCS11Exception {

    long session = this.pkcs11.C_OpenSession(this.slotId, PKCS11Constants.CKF_SERIAL_SESSION, null, null);

    try {

      CK_MECHANISM mechanism = new CK_MECHANISM();
      mechanism.mechanism = PKCS11Constants.CKM_SHA1_RSA_PKCS;
      mechanism.pParameter = null;
      this.pkcs11.C_SignInit(session, mechanism, this.getSignatureHandle(session));

      return this.pkcs11.C_Sign(session, digest);

    } finally {

      this.pkcs11.C_CloseSession(session);
    }
  }

  public void validate(byte[] digest, byte[] signature) throws PKCS11Exception {

    long session = this.pkcs11.C_OpenSession(this.slotId, PKCS11Constants.CKF_SERIAL_SESSION, null, null);

    try {

      this.pkcs11.C_FindObjectsInit(session, getCKAttributes(PKCS11Constants.CKO_PUBLIC_KEY, "CITIZEN SIGNATURE CERTIFICATE"));

      long handle = this.pkcs11.C_FindObjects(session, 1)[0];

      this.pkcs11.C_FindObjectsFinal(session);

      CK_MECHANISM mechanism = new CK_MECHANISM();
      mechanism.mechanism = PKCS11Constants.CKM_SHA1_RSA_PKCS;
      mechanism.pParameter = null;
      this.pkcs11.C_VerifyInit(session, mechanism, handle);

      this.pkcs11.C_Verify(session, digest, signature);

    } finally {

      this.pkcs11.C_CloseSession(session);
    }
  }
}
