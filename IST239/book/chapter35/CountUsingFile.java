package chapter35;

import java.io.*;
public class CountUsingFile {
  private int count = 0;
  private RandomAccessFile inout = null;

  public CountUsingFile() {
    try {
      inout = new RandomAccessFile("count.dat", "rw");
      if (inout.length() == 0)
        count = 0;
      else
        count = inout.readInt();
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  /** Return count property */
  public int getCount() {
    return count;
  }

  /** Increase count */
  public void increaseCount() {
    count++;
  }

  /** Save count */
  public void saveCount() {
    try {
      inout.seek(0);
      inout.writeInt(count);
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    finally {
      try {
        inout.close();
      }
      catch (Exception ex) {
      }
    }
  }
}

