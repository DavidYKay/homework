import java.io.*;
import java.util.*;

public class TestPrintWriter {
  public static void main(String[] args) throws IOException {
    // Check if file temp.txt already exists
    File file = new File("temp.txt");
    if (file.exists()) {
      System.out.println("File temp.txt already exists");
      System.exit(0);
    }

    // Create an output stream
    PrintWriter output = new PrintWriter(new FileWriter(file));

    // Generate ten integers and write them to a file
    for (int i = 0; i < 10; i++) {
      output.print((int)(Math.random() * 100) + " ");
    }

    // Close the output stream
    output.close();

    // Open an input stream
    BufferedReader input =
      new BufferedReader(new FileReader("temp.txt"));

    int total = 0;  // Store total
    String line;
    while ((line = input.readLine()) != null) {
      // Extract numbers using string tokenizer
      StringTokenizer tokens = new StringTokenizer(line);
      while (tokens.hasMoreTokens())
        total += Integer.parseInt(tokens.nextToken());
    }

    System.out.println("Total is " + total);

    // Close input stream
    input.close();
  }
}
