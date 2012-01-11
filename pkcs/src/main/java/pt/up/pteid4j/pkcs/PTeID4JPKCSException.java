package pt.up.pteid4j.pkcs;

import pt.up.pteid4j.PTeID4JException;

/**
 * PTeID4J PKCS Exception Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public class PTeID4JPKCSException extends PTeID4JException {

  private static final long serialVersionUID = -1278519801897110421L;

  /**
   * Class Constructor
   * 
   * @param message
   *          the PTeID4J PKCS Exception error message
   */
  public PTeID4JPKCSException(String message) {

    super(message);
  }
}
