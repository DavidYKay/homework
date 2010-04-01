import java.io.*;
import java.util.*;

public class SaveObject {

    public static void main(String[] sa) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(
            new BufferedOutputStream(
                new FileOutputStream("object.dat")));

        int i = 199;
        String name = "James";
        Date date = new Date();

        out.writeInt(i);
        out.writeUTF(name);
        out.writeObject(date);

        out.close();
    }
}

