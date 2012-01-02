package pt.up.pteid4j;

import org.apache.log4j.Logger;

import pteidlib.PTEID_ADDR;
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

  protected static PTEID_ADDR getAddress() throws PteidException {

    return pteid.GetAddr();
  }

  protected static PTEID_ID getId() throws PteidException {

    return pteid.GetID();
  }
}
