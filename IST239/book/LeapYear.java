import javax.swing.JOptionPane;

public class LeapYear {
  public static void main(String args[]) {
    // Prompt the user to enter a year
    String yearString = JOptionPane.showInputDialog("Enter a year");

    // Convert the string into an int value
    int year = Integer.parseInt(yearString);

    // Check if the year is a leap year
    boolean isLeapYear =
      ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);

    // Display the result in a message dialog box
    JOptionPane.showMessageDialog(null,
      year + " is a leap year? " + isLeapYear);
  }
}
