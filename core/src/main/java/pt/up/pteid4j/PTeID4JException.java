package pt.up.pteid4j;

/**
 * PTeID4J Exception Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public class PTeID4JException extends Exception {

  private static final long serialVersionUID = 808456759075119242L;

  /**
   * Class Constructor
   * 
   * @param message
   *          the PTeID4J Exception error message
   */
  public PTeID4JException(String message) {

    super(message);
  }

  /**
   * Class Constructor
   * 
   * @param exception
   *          the Exception that triggered the PTeID4J Exception
   */
  public PTeID4JException(Throwable exception) {

    super(exception);
  }
}
