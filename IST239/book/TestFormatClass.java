// TestFormatClass.java: Demonstrate using the Format class
import com.prenhall.mypackage.Format;

public class TestFormatClass {
  /** Main method */
  public static void main(String[] args) {
    System.out.println(Format.format(10.3422345, 2));
    System.out.println(Format.format(-0.343434, 3));
  }
}
