package pt.up.pteid4j;

import org.apache.log4j.Logger;

import pt.up.pteid4j.pkcs11.PTeID4JPKCS11;
import pteidlib.PTEID_ADDR;
import pteidlib.PTEID_Certif;
import pteidlib.PTEID_ID;
import pteidlib.PteidException;
import pteidlib.pteid;

/**
 * PTeID4J Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public final class PTeID4J {

  private static Logger logger = Logger.getLogger(PTeID4J.class);

  static {

    logger.debug("PTeID4J");

    try {

      System.loadLibrary("pteidlibj");

      // System.loadLibrary("pteidpkcs11");

      // System.load("/usr/local/lib/libpteidlib.dylib");

      pteid.Init("");
      pteid.SetSODChecking(false);

    } catch (PteidException e) {

      e.printStackTrace();
    }
  }

  /**
   * Class Constructor
   * 
   */
  private PTeID4J() {

  }

  public static PTEID_ADDR getAddress() throws PteidException {

    return pteid.GetAddr();
  }

  public static PTEID_Certif getAuthenticationCertificate() throws PteidException {

    return getCertificate("CITIZEN AUTHENTICATION CERTIFICATE");
  }

  public static PTEID_Certif getAuthenticationCertificateCA() throws PteidException {

    return getCertificate("AUTHENTICATION SUB CA");
  }

  private static PTEID_Certif getCertificate(String label) throws PteidException {

    PTEID_Certif[] certificates = pteid.GetCertificates();

    for (int i = 0; i < certificates.length; i++) {

      if ( certificates[i].certifLabel.equals(label) ) {

        return certificates[i];
      }
    }

    return null;
  }

  public static PTEID_ID getId() throws PteidException {

    return pteid.GetID();
  }

  public static PTEID_Certif getSignatureCertificate() throws PteidException {

    return getCertificate("CITIZEN SIGNATURE CERTIFICATE");
  }

  public static PTEID_Certif getSignatureCertificateCA() throws PteidException {

    return getCertificate("SIGNATURE SUB CA");
  }

  public static byte[] sign(byte[] digest) throws Exception {

    return PTeID4JPKCS11.getInstance().sign(digest);
  }
}
