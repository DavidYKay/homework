import javax.swing.JOptionPane;

public class TestSum {
  public static void main(String[] args) {
    // Initialize sum
    float sum = 0;

    // Add 0.01, 0.02, ..., 0.99, 1 to sum
    for (float i = 0.01f; i <= 1.0f; i = i + 0.01f)
      sum += i;

    // Display result
    JOptionPane.showMessageDialog(null, "The sum is " + sum);
  }
}
