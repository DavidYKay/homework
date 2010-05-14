import javax.swing.JOptionPane;

public class TestDoWhile {
  /** Main method */
  public static void main(String[] args) {
    int data;
    int sum = 0;

    // Keep reading data until the input is 0
    do {
      // Read the next data
      String dataString = JOptionPane.showInputDialog(null,
        "Enter an int value, \nthe program exits if the input is 0",
        "TestDo", JOptionPane.QUESTION_MESSAGE);

      data = Integer.parseInt(dataString);

      sum += data;
    } while (data != 0);

    JOptionPane.showMessageDialog(null, "The sum is " + sum,
      "TestDo", JOptionPane.INFORMATION_MESSAGE);
  }
}
