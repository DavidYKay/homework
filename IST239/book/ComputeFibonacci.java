import javax.swing.JOptionPane;

public class ComputeFibonacci {
  /** Main method */
  public static void main(String args[]) {
    // Read the index
    String intString = JOptionPane.showInputDialog(
      "Enter an index for the Fibonacci number:");

    // Convert string into integer
    int index = Integer.parseInt(intString);

    // Find and display the Fibonacci number
    JOptionPane.showMessageDialog(null,
      "Fibonacci number at index " + index + " is " + fib(index));
  }

  /** The method for finding the Fibonacci number */
  public static long fib(long index) {
    if (index == 0) // Stopping condition
      return 0;
    else if (index == 1) // Stopping condition
      return 1;
    else  // Reduction and recursive calls
      return fib(index - 1) + fib(index - 2);
  }
}
