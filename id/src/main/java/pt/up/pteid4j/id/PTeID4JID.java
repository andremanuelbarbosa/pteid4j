package pt.up.pteid4j.id;

import org.apache.log4j.Logger;

import pteidlib.PteidException;
import pteidlib.pteid;

/**
 * PTeID4J ID Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public final class PTeID4JID {

  private static Logger logger = Logger.getLogger(PTeID4JID.class);

  static {

    logger.debug("PTeID4J");

    try {

      System.loadLibrary("pteidlibj");

      pteid.Init("");
      pteid.SetSODChecking(false);

    } catch (PteidException e) {

      e.printStackTrace();
    }
  }

  public static String getSurname() throws PteidException {

    return pteid.GetID().name;
  }

  public static String getFirstname() throws PteidException {

    return pteid.GetID().firstname;
  }
}
