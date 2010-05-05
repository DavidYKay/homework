/** There are two implementations for MyInput. One is to use the BufferedReader 
 *  class in Chapter 16. The other is given in Chapter 7 using the JDK 1.5 
 *  Scanner class, which can only run in JDK 1.5. For this reason, 
 *  the source code here uses the BufferedReader class. 
 */
import java.io.*;

public class MyInput {
  static BufferedReader br
    = new BufferedReader(new InputStreamReader(System.in));

  /** Read a string from the keyboard */
  public static String readString() {
    // Declare and initialize the string
    String string = null;

    // Get the string from the keyboard
    try {
      string = br.readLine();
    }
    catch (IOException ex) {
      System.out.println(ex);
    }

    // Return the string obtained from the keyboard
    return string;
  }

  /** Read an int value from the keyboard */
  public static int readInt() {
    return Integer.parseInt(readString());
  }

  /** Read a double value from the keyboard */
  public static double readDouble() {
    return Double.parseDouble(readString());
  }

  /** Read a byte value from the keyboard */
  public static byte readByte() {
    return Byte.parseByte(readString());
  }

  /** Read a short value from the keyboard */
  public static short readShort() {
    return Short.parseShort(readString());
  }

  /** Read a long value from the keyboard */
  public static long readLong() {
    return Long.parseLong(readString());
  }

  /** Read a float value from the keyboard */
  public static float readFloat() {
    return Float.parseFloat(readString());
  }

  /** Read a character from the keyboard */
  public static char readChar() {
    return readString().charAt(0);
  }

  /** Read a boolean value from the keyboard */
  public static boolean readBoolean() {
    return new Boolean(readString()).booleanValue();
  }
}
