import javax.swing.JOptionPane;

public class ComputeChange {
  /** Main method */
  public static void main(String[] args) {
    // Receive the amount
    String amountString = JOptionPane.showInputDialog(
      "Enter an amount in double, for example 11.56");

    // Convert string to double
    double amount = Double.parseDouble(amountString);

    int remainingAmount = (int)(amount * 100);

    // Find the number of one dollars
    int numberOfOneDollars = remainingAmount / 100;
    remainingAmount = remainingAmount % 100;

    // Find the number of quarters in the remaining amount
    int numberOfQuarters = remainingAmount / 25;
    remainingAmount = remainingAmount % 25;

    // Find the number of dimes in the remaining amount
    int numberOfDimes = remainingAmount / 10;
    remainingAmount = remainingAmount % 10;

    // Find the number of nickels in the remaining amount
    int numberOfNickels = remainingAmount / 5;
    remainingAmount = remainingAmount % 5;

    // Find the number of pennies in the remaining amount
    int numberOfPennies = remainingAmount;

    // Display results
    String output = "Your amount " + amount + " consists of \n" +
      numberOfOneDollars + " dollars\n" +
      numberOfQuarters + " quarters\n" +
      numberOfDimes + " dimes\n" +
      numberOfNickels + " nickels\n" +
      numberOfPennies + " pennies";
    JOptionPane.showMessageDialog(null, output);
  }
}

