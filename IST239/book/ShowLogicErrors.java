// ShowLogicErrors.java: The program contains a logic error
import javax.swing.JOptionPane;

public class ShowLogicErrors {
  // Determine if a number is between 1 and 100 inclusively
  public static void main(String[] args) {
    // Prompt the user to enter a number
    String input = JOptionPane.showInputDialog(null,
      "Please enter an integer:",
      "ShowLogicErrors", JOptionPane.QUESTION_MESSAGE);
    int number = Integer.parseInt(input);

    // Display the result
    JOptionPane.showMessageDialog(null,
      "The number is between 1 and 100, inclusively?\n" +
      ((1 < number) && (number < 100)),
      "ShowLogicErrors", JOptionPane.INFORMATION_MESSAGE);
  }
}
