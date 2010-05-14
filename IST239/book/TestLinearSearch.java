// TestLinearSearch.java: Search for a number in a list
public class TestLinearSearch {
  /** Main method */
  public static void main(String[] args) {
    int[] list = {1, 4, 4, 2, 5, -3, 6, 2};
    int i = LinearSearch.linearSearch(list, 4);  // returns 1
    int j = LinearSearch.linearSearch(list, -4); // returns -1
    int k = LinearSearch.linearSearch(list, -3); // returns 5

    System.out.println(i);
    System.out.println(j);
    System.out.println(k);
  }
}
