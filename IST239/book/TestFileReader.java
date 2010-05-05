import java.io.*;

public class TestFileReader {
  public static void main(String[] args) {
    FileReader input = null;
    try {
      // Create an input stream
      input = new FileReader("temp.txt");

      int code;
      // Repeatedly read a character and display it on the console
      while ((code = input.read()) != -1)
        System.out.print((char)code);
    }
    catch (FileNotFoundException ex) {
      System.out.println("File temp.txt does not exist");
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    finally {
      try {
        input.close(); // Close the stream
      }
      catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
}
