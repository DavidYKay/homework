import javax.swing.JOptionPane;

public class SentinelValue {
  /** Main method */
  public static void main(String[] args) {
    // Read an initial data
    String dataString = JOptionPane.showInputDialog(
      "Enter an int value:\n(the program exits if the input is 0)");
    int data = Integer.parseInt(dataString);

    // Keep reading data until the input is 0
    int sum = 0;
    while (data != 0) {
      sum += data;

      // Read the next data
      dataString = JOptionPane.showInputDialog(
        "Enter an int value:\n(the program exits if the input is 0)");
      data = Integer.parseInt(dataString);
    }

    JOptionPane.showMessageDialog(null, "The sum is " + sum);
  }
}
