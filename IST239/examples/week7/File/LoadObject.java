import java.io.*;
import java.util.*;

public class LoadObject {

    public static void main(String[] sa) throws Exception {
        ObjectInputStream in = new ObjectInputStream(
            new BufferedInputStream(
                new FileInputStream("object.dat")));

        int i = in.readInt();
        String name = in.readUTF();
        Date date = (Date) in.readObject();
        System.out.println(i + " " + name + " " +
                date.toString());

        in.close();
    }
}

