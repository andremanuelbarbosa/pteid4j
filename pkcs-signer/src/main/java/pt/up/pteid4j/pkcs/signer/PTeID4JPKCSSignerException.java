package pt.up.pteid4j.pkcs.signer;

import pt.up.pteid4j.pkcs.PTeID4JPKCSException;

/**
 * PTeID4J PKCS Signer Exception Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public class PTeID4JPKCSSignerException extends PTeID4JPKCSException {

  private static final long serialVersionUID = -5829912195322796022L;

  /**
   * Class Constructor
   * 
   * @param message
   *          the PTeID4J PKCS Signer Exception error message
   */
  public PTeID4JPKCSSignerException(String message) {

    super(message);
  }

  /**
   * Class Constructor
   * 
   * @param exception
   *          the Exception that triggered the PTeID4J PKCS Signer Exception
   */
  public PTeID4JPKCSSignerException(Exception exception) {

    super(exception);
  }
}
