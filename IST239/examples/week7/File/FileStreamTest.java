import java.io.*;

public class FileStreamTest {

    public static void main(String[] sa) throws IOException {
        File file = new File("FileStreamTest.dat");
        FileOutputStream fOut = new FileOutputStream(file);

        for (int i = 0; i < 300; i++) {
        //for (int i = 0; i < 200; i++) {
            fOut.write(i);
        }

        fOut.close();

        FileInputStream fin = new FileInputStream(file);
        int nextUnsignedByte = 0;
        while ((nextUnsignedByte = fin.read()) != -1) {
            System.out.println("Read " + nextUnsignedByte);
        }
        fin.close();
    }
}

