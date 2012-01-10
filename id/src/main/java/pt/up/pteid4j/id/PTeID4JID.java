package pt.up.pteid4j.id;

import pteidlib.PteidException;
import pteidlib.pteid;

/**
 * PTeID4J ID Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public final class PTeID4JID {

  static {

    System.loadLibrary("pteidlibj");
  }

  /**
   * Initializes the PTeID4J ID
   * 
   * @throws PteidException
   *           if there is an error initializing the PTeID4J ID
   */
  public static void init() throws PteidException {

    pteid.Init("");
    pteid.SetSODChecking(false);
  }

  /**
   * Terminates the PTeID4J ID
   * 
   * @throws PteidException
   *           if there is an error terminating the PTeID4J ID
   */
  public static void terminate() throws PteidException {

    pteid.Exit(0);
  }

  /**
   * Returns the Citizen Surname
   * 
   * @return the Citizen Surname
   * @throws PteidException
   *           if there is an error accessing the Citizen ID
   */
  public static String getSurname() throws PteidException {

    return pteid.GetID().name;
  }

  /**
   * Returns the Citizen Forename
   * 
   * @return the Citizen Forename
   * @throws PteidException
   *           if there is an error accessing the Citizen ID
   */
  public static String getForename() throws PteidException {

    return pteid.GetID().firstname;
  }
}
