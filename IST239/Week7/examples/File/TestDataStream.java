import java.io.*;

public class TestDataStream {
    public static void main(String[] sa) throws IOException {
        File file = new File("FileStreamTest.dat");
        DataOutputStream out = null;
        DataInputStream in   = null;
        try {
            //Write everything out
            out = new DataOutputStream(
                new FileOutputStream(file)
            );
            String[] students = {
                "James",
                "John",
                "Mary",
                "Edward",
                "Mike"
            };
            int[] scores = {
                98,
                100,
                95,
                72,
                83
            };
            for (int i = 0; i < students.length; i++) {
                out.writeUTF(students[i]);
                out.writeInt(scores[i]);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        //Read everything back in
        try {
            in = new DataInputStream(
                new FileInputStream(file)
            );
            while (true) {
                System.out.println(in.readUTF() + " -> " + in.readInt());
            }
        } catch (EOFException ioe) {
            System.out.println("End of file reached");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
