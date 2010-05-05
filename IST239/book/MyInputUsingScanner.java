import java.util.*;

public class MyInputUsingScanner {
   static Scanner scanner = new Scanner(System.in);

  /** Read a string from the keyboard */
  public static String readString() {
    return scanner.next();
  }

  /** Read an int value from the keyboard */
  public static int readInt() {
    return scanner.nextInt();
  }

  /** Read a double value from the keyboard */
  public static double readDouble() {
    return scanner.nextDouble();
  }

  /** Read a byte value from the keyboard */
  public static byte readByte() {
    return scanner.nextByte();
  }

  /** Read a short value from the keyboard */
  public static short readShort() {
    return scanner.nextShort();
  }

  /** Read a long value from the keyboard */
  public static long readLong() {
    return scanner.nextLong();
  }

  /** Read a float value from the keyboard */
  public static float readFloat() {
    return scanner.nextFloat();
  }

  /** Read a character from the keyboard */
  public static char readChar() {
    return (scanner.next()).charAt(0);
  }
  
  /** Read a boolean value from the keyboard */
  public static boolean readBoolean() {
    return scanner.nextBoolean();
  }
}