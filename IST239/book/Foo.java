public class Foo {
  int i = 5;
  static int k = 2;

  public static void main(String[] args) {
 //   int j = i; // Wrong because i is an instance variable
   // m1(); // Wrong because m1() is an instance method
  }

  public void m1() {
    // Correct since instance and static variables and methods 
    // can be used in an instance method
    i = i + k + m2(i, k); 
  }

  public static int m2(int i, int j) {
    return (int)(Math.pow(i, j)); 
  }
}