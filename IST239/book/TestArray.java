import javax.swing.JOptionPane;

public class TestArray {
  /** Main method */
  public static void main(String[] args) {
    final int TOTAL_NUMBERS = 6;
    int[] numbers = new int[TOTAL_NUMBERS];

    // Read all numbers
    for (int i = 0; i < numbers.length; i++) {
      String numString = JOptionPane.showInputDialog(
        "Enter a number:");

      // Convert string into integer
      numbers[i] = Integer.parseInt(numString);
    }

    // Find the largest
    int max = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (max < numbers[i])
        max = numbers[i];
    }

    // Find the occurrence of the largest number
    int count = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == max) count++;
    }

    // Prepare the result
    String output = "The array is ";
    for (int i = 0; i < numbers.length; i++) {
      output += numbers[i] + " ";
    }

    output += "\nThe largest number is " + max;
    output += "\nThe occurrence count of the largest number "
      + "is " + count;

    // Display the result
    JOptionPane.showMessageDialog(null, output);
  }
}
