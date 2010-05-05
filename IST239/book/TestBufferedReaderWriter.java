import java.io.*;

public class TestBufferedReaderWriter {
  public static void main(String[] args) throws IOException {
    // Create an input stream
    BufferedReader input =
      new BufferedReader(new FileReader("Welcome.java"));

    // Create an output stream
    BufferedWriter output =
      new BufferedWriter(new FileWriter("Welcome.java~"));

    // Repeatedly read a line and display it on the console
    String line;
    while ((line = input.readLine()) != null) {
      System.out.println(line);
      output.write(line);
      output.newLine(); // Write a line separator
    }

    // Close the stream
    input.close();
    output.close();
  }
}
