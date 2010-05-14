public class TestBinarySearch {
  /** Main method */
  public static void main(String[] args) {
    int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    int i = BinarySearch.binarySearch(list, 2);
    int j = BinarySearch.binarySearch(list, 11);
    int k = BinarySearch.binarySearch(list, 12);

    System.out.println(i);
    System.out.println(j);
    System.out.println(k);
  }
}
