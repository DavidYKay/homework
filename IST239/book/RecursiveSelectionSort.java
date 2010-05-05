public class RecursiveSelectionSort {
  public static void sort(double[] list) {
    sort(list, list.length - 1);
  }

  public static void sort(double[] list, int high) {
    if (high > 1) {
      // Find the largest number and its index
      int indexOfMax = 0;
      double max = list[0];
      for (int i = 1; i <= high; i++) {
        if (list[i] > max) {
          max = list[i];
          indexOfMax = i;
        }
      }

      // Swap the largest with the last number in the list
      list[indexOfMax] = list[high];
      list[high] = max;

      // Sort the remaining list
      sort(list, high - 1);
    }
  }
}
