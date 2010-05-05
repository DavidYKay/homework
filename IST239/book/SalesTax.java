public class SalesTax {
  public static void main(String[] args) {
    double purchaseAmount = 197.55;
    double tax = purchaseAmount * 0.06;
    System.out.println((int)(tax * 100) / 100.0);
  }
}
