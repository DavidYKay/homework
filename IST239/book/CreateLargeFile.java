import java.io.*;

public class CreateLargeFile {
  public static void main(String[] args) throws Exception {
    DataOutputStream output = new DataOutputStream(
      new BufferedOutputStream(new FileOutputStream("largedata.dat")));

    for (int i = 0; i < 2000000; i++)
      output.writeInt((int)(Math.random() * 1000000));

    output.close();
  }
}
