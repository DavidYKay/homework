import java.util.*;

public class FormatString {
  public static void main(String[] args) throws Exception {
    StringBuilder stringBuilder = new StringBuilder();

    // Create a Formatter for a string builder
    Formatter output = new Formatter(stringBuilder);

    // Append formatted data to the string builder
    output.format("%s %c %s %d \n", "John", 'T', "Smith", 90);
    output.format("%s %c %s %d", "Eric", 'K', "Jones", 85);

    // Close the formatter
    output.close();

    System.out.println(stringBuilder.toString());
  }
}
