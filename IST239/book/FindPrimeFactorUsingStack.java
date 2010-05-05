import javax.swing.JOptionPane;

public class FindPrimeFactorUsingStack {
  public static void main(String[] args) {
    // Prompt the user to enter a positive integer
    String intString = JOptionPane.showInputDialog(null,
      "Enter a positive integer:",
      "Example 18.7 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to int
    int n = Integer.parseInt(intString);

    // Create a stack to store prime factors
    java.util.Stack stack = new java.util.Stack();

    // Find all prime factors of the integer
    int factor = 2;
    while (factor <= n) {
      if (n % factor == 0) {
        n = n / factor;
        if (stack.isEmpty() ||
          ((Integer)stack.peek()).intValue() != factor)
          stack.push(new Integer(factor));
      }
      else {
        factor++;
      }
    }

    // Prepare the output
    String outString = "";
    while (!stack.isEmpty()) {
      outString += stack.pop() + "  ";
    }

    // Display the output
    JOptionPane.showMessageDialog(null, outString,
      "Example 18.7 Output", JOptionPane.INFORMATION_MESSAGE);
  }
}
