import javax.swing.JOptionPane;

public class ComputeTaxWithSelectionStatement {
  public static void main(String[] args) {
    // Prompt the user to enter filing status
    String statusString = JOptionPane.showInputDialog(
      "Enter the filing status:\n" +
      "(0-single filer, 1-married jointly,\n" +
      "2-married separately, 3-head of household)");
    int status = Integer.parseInt(statusString);

    // Prompt the user to enter taxable income
    String incomeString = JOptionPane.showInputDialog(
      "Enter the taxable income:");
    double income = Double.parseDouble(incomeString);

    // Compute tax
    double tax = 0;

    if (status == 0) { // Compute tax for single filers
      if (income <= 6000)
        tax = income * 0.10;
      else if (income <= 27950)
        tax = 6000 * 0.10 + (income - 6000) * 0.15;
      else if (income <= 67700)
        tax = 6000 * 0.10 + (27950 - 6000) * 0.15 +
          (income - 27950) * 0.27;
      else if (income <= 141250)
        tax = 6000 * 0.10 + (27950 - 6000) * 0.15 +
          (67700 - 27950) * 0.27 + (income - 67700) * 0.30;
      else if (income <= 307050)
        tax = 6000 * 0.10 + (27950 - 6000) * 0.15 +
          (67700 - 27950) * 0.27 + (141250 - 67700) * 0.30 +
          (income - 141250) * 0.35;
      else
        tax = 6000 * 0.10 + (27950 - 6000) * 0.15 +
          (67700 - 27950) * 0.27 + (141250 - 67700) * 0.30 +
          (307050 - 141250) * 0.35 + (income - 307050) * 0.386;
    }
    else if (status == 1) { // Compute tax for married file jointly
      // Left as exercise
    }
    else if (status == 2) { // Compute tax for married separately
      // Left as exercise
    }
    else if (status == 3) { // Compute tax for head of household
      // Left as exercise
    }
    else {
      System.out.println("Error: invalid status");
      System.exit(0);
    }

    // Display the result
    JOptionPane.showMessageDialog(null, "Tax is " +
      (int)(tax * 100) / 100.0);
  }
}
