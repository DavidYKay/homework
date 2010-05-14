import javax.swing.JOptionPane;

public class MultiplicationTable {
  /** Main method */
  public static void main(String[] args) {
    // Display the table heading
    String output = "                Multiplication Table\n";
    output += "-------------------------------------------------\n";

    // Display the number title
    output += "   | ";
    for (int j = 1; j <= 9; j++)
      output += "    " + j;

    output += "\n";

    // Print table body
    for (int i = 1; i <= 9; i++) {
      output += i + " | ";
      for (int j = 1; j <= 9; j++) {
        // Display the product and align properly
        if (i * j < 10)
          output += "    " + i * j;
        else
          output += "  " + i * j;
      }
      output += "\n";
    }

    // Display result
    JOptionPane.showMessageDialog(null, output);
  }
}
