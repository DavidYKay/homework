// TestMyInput.java: Demo for using MyInput
public class TestMyInput {
  public static void main(String args[]) {
    // Prompt the user to enter an integer
    System.out.print("Enter an integer: ");
    int intValue = MyInput.readInt();
    System.out.println("You entered the integer " + intValue);

    // Prompt the user to enter a double value
    System.out.print("Enter a double value: ");
    double doubleValue = MyInput.readDouble();
    System.out.println("You entered the double value "
      + doubleValue);

    // Prompt the user to enter a string
    System.out.print("Enter a string: ");
    String string = MyInput.readString();
    System.out.println("You entered the string " + string);

    // Prompt the user to enter a character
    System.out.print("Enter a character: ");
    char charValue = MyInput.readChar();
    System.out.println("You entered the character " + charValue);

    // Prompt the user to enter a boolean
    System.out.print("Enter a boolean: ");
    boolean booleanValue = MyInput.readBoolean();
    System.out.println("You entered the boolean " + booleanValue);
  }
}
