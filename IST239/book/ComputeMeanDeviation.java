// ComputeMeanDeviation.java: Demonstrate using the math methods
public class ComputeMeanDeviation {
  /** Main method */
  public static void main(String[] args) {
    final int COUNT = 10; // Total numbers
    int number = 0; // Store a random number
    double sum = 0; // Store the sum of the numbers
    double squareSum = 0; // Store the sum of the squares

    // Create numbers, find its sum, and its square sum
    for (int i = 0; i < COUNT; i++) {
      // Generate a new random number
      number = (int)Math.round(Math.random() * 1000);
      System.out.println(number);

      // Add the number to sum
      sum += number;

      // Add the square of the number to squareSum
      squareSum += Math.pow(number, 2); // Same as number*number;
    }

    // Find mean
    double mean = sum / COUNT;

    // Find standard deviation
    double deviation =
      Math.sqrt((squareSum - sum * sum / COUNT) / (COUNT - 1));

    // Display result
    System.out.println("The mean is " + mean);
    System.out.println("The standard deviation is " + deviation);
  }
}