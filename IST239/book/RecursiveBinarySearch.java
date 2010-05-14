import javax.swing.JOptionPane;

public class RecursiveBinarySearch {
  /** Main method */
  public static void main(String[] args) {
    int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    // Declare and initialize output string
    String output = "The list is ";
    for (int i = 0; i < list.length; i++)
      output += list[i] + " ";

    // Prompt the user to enter a key
    String keyString = JOptionPane.showInputDialog(
      output + "\nEnter a key:");

    // Convert string into integer
    int key = Integer.parseInt(keyString);

    // Display the result
    JOptionPane.showMessageDialog(null,
      "Index is " + recursiveBinarySearch(list, key));
  }

  /** Use binary search to find the key in the list */
  public static int recursiveBinarySearch(int[] list, int key) {
    int low = 0;
    int high = list.length - 1;
    return recursiveBinarySearch(list, key, low, high);
  }

  /** Use binary search to find the key in the list between
      list[low] and list[high] */
  public static int recursiveBinarySearch(int[] list, int key,
    int low, int high) {
    if (low > high)  // The list has been exhausted without a match
      return -low - 1;

    int mid = (low + high) / 2;
    if (key < list[mid])
      return recursiveBinarySearch(list, key, low, mid - 1);
    else if (key == list[mid])
      return mid;
    else
      return recursiveBinarySearch(list, key, mid + 1, high);
  }
}
