import java.io.*;

public class TestPrintWriter {

    public static void main(String[] sa) throws IOException {
        PrintWriter writer = new PrintWriter("myFile.txt");
        for (int i = 0; i < 20; i++) {
            writer.print(i + " ");
        }
        writer.println();
        writer.println("Now we are writing out to a file!");
        writer.println("There are overloaded print, println, and printf"
                + "methods in the PrintWriter!");
        writer.printf(
            "%2.4f %c, %d", 3.14159, '@', 130
        );
        writer.println();
        
        writer.flush();
        writer.close();
    }
}

