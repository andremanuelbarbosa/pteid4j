package pt.up.pteid4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
   * Converts an Input Stream to an array of bytes
   * 
   * @param inputStream
   *          the Input Stream
   * @return the array of bytes from the Input Stream
   * @throws IOException
   *           if there is an error accessing the input stream
   */
  public static byte[] toByteArray(InputStream inputStream) throws IOException {

    int read = -1;
    byte[] buff = new byte[512];

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    while ((read = inputStream.read(buff)) >= 0) {

      byteArrayOutputStream.write(buff, 0, read);
    }

    byteArrayOutputStream.close();

    return byteArrayOutputStream.toByteArray();
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

  /**
   * Converts an array of bytes into an Input Stream
   * 
   * @param bytes
   *          the array of bytes
   * @return the Input Stream
   */
  public static InputStream toInputStream(byte[] bytes) {

    return new ByteArrayInputStream(bytes);
  }
}
