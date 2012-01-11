package pt.up.pteid4j.pkcs.signer;

import pt.up.pteid4j.pkcs.PTeID4JPKCS;
import pt.up.pteid4j.pkcs.PTeID4JPKCSException;

/**
 * PTeID4J PKCS Signer Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public final class PTeID4JPKCSSigner {

  private static PTeID4JPKCS pteid4jPKCS;

  static {

    pteid4jPKCS = PTeID4JPKCS.getInstance();
  }

  private PTeID4JPKCSSigner() {

  }

  public static byte[] sign(byte[] digest) throws PTeID4JPKCSSignerException {

    try {

      return pteid4jPKCS.sign(digest);

    } catch (PTeID4JPKCSException e) {

      throw new PTeID4JPKCSSignerException(e);
    }
  }

  public static byte[] sign(String digest) throws PTeID4JPKCSSignerException {

    try {

      return pteid4jPKCS.sign(digest.getBytes());

    } catch (PTeID4JPKCSException e) {

      throw new PTeID4JPKCSSignerException(e);
    }
  }
}
