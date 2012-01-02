package pt.up.pteid4j;

/**
 * PTeID4J Utilities Abstract Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public abstract class PTeID4JUtils {

  private static char[] HEXES = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

  /**
   * Returns the Name of the Operating System
   * 
   * @return the Name of the Operating System
   */
  protected static String getOSName() {

    return System.getProperty("os.name");
  }

  /**
   * Converts an array of bytes to an Hexadecimal String
   * 
   * @param bytes
   *          the array of bytes
   * @return the Hexadecimal String
   */
  public static String toHexString(byte[] bytes) {

    StringBuffer stringBuffer = new StringBuffer(3 * bytes.length + 2);

    for (int i = 0; i < bytes.length; i++) {

      int c = bytes[i];

      if ( c < 0 ) {

        c += 256;
      }

      stringBuffer.append(HEXES[c / 16]);
      stringBuffer.append(HEXES[c % 16]);
    }

    return stringBuffer.toString();
  }
}
