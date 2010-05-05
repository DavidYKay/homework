import java.io.*;
import java.util.*;

public class IOTest {

    public static void main(String[] sa) throws IOException {
        PrintWriter writer = new PrintWriter("myFile.txt");
        File binaryFile = new File("BinaryFile.dat");
        FileOutputStream fOut = new FileOutputStream(binaryFile);

        int i = 199;

        writer.print(i);
        fOut.write(i);

        writer.close();
        fOut.close();
    }
}

