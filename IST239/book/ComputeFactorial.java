import javax.swing.JOptionPane;

public class ComputeFactorial {
  /** Main method */
  public static void main(String[] args) {
    // Prompt the user to enter an integer
    String intString = JOptionPane.showInputDialog(
      "Please enter a non-negative integer:");

    // Convert string into integer
    int n = Integer.parseInt(intString);

    // Display factorial
    JOptionPane.showMessageDialog(null,
      "Factorial of " + n + " is " + factorial(n));
  }

  /** Return the factorial for a specified index */
  static long factorial(int n) {
    if (n == 0) // Stopping condition
      return 1;
    else
      return n * factorial(n - 1); // Call factorial recursively
  }
}
