public class FindPrimeUsingVector {
  public static void main(String[] args) {
    // Print 10 numbers per line
    final int NUMBER_PER_LINE = 10;

    // Count the number of primes found
    int count = 0;

    // Create a vector to store prime numbers
    java.util.Vector vector = new java.util.Vector();

    System.out.println("The prime numbers before 250 are \n");

    for (int n = 2; n < 250; n++) {
      // Test if n is prime
      boolean isPrime = true;
      for (int i = 0; i < vector.size(); i++) {
        int primeNumber =
          ((Integer)(vector.elementAt(i))).intValue();

        if (primeNumber > Math.sqrt(n)) break;

        if (n % primeNumber == 0) {
          // Set isPrime to false, if the number is not prime
          isPrime = false;
          break; // Exit the for loop
        }
      }

      // Print the prime number and increase the count
      if (isPrime) {
        count++; // Increase prime number count

        // Add the prime number to the vector
        vector.addElement(new Integer(n));

        if (count % NUMBER_PER_LINE == 0) {
          // Print the number and advance to the new line
          System.out.println(n);
        }
        else
          System.out.print(n + " ");
      }
    }
  }
}
