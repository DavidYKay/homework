public class HeapSort {
  public static void heapSort(int list[]) {
    // Create a heap from the list
    for (int i = 1; i < list.length; i++) {
      makeHeap(list, i);
    }

    // Produce a sorted array from the heap
    for (int last = list.length - 1; last > 0; ) {
      // Swap list[0] with list[last]
      int temp = list[last];
      list[last] = list[0];
      list[0] = temp;
      rebuildHeap(list, --last);
    }
  }

  /** Assume list[0..k-1] is a heap, add list[k] to the heap */
  private static void makeHeap(int[] list, int k) {
    int currentIndex = k;

    while (currentIndex > 0 &&
        list[currentIndex] > list[(currentIndex - 1) / 2]) {
      // Swap list[currentIndex] with list[(currentIndex - 1) / 2]
      int temp = list[currentIndex];
      list[currentIndex] = list[(currentIndex - 1) / 2];
      list[(currentIndex - 1) / 2] = temp;

      currentIndex = (currentIndex - 1) / 2;
    }
  }

  private static void rebuildHeap(int[] list, int last) {
    int currentIndex = 0;
    boolean isHeap = false;

    while (!isHeap) {
      int leftChildIndex = 2 * currentIndex + 1;
      int rightChildIndex = 2 * currentIndex + 2;
      int maxIndex = currentIndex;

      if (leftChildIndex <= last &&
        list[maxIndex] < list[leftChildIndex]) {
        maxIndex = leftChildIndex;
      }

      if (rightChildIndex <= last &&
        list[maxIndex] < list[rightChildIndex]) {
        maxIndex = rightChildIndex;
      }

      if (maxIndex != currentIndex) {
        // Swap list[currentIndex] with list[maxIndex]
        int temp = list[currentIndex];
        list[currentIndex] = list[maxIndex];
        list[maxIndex] = temp;
        currentIndex = maxIndex;
      } else {
        isHeap = true;
      }
    }
  }

  public static void main(String[] args) {
//    int[] list = {322, 39, 5, 4, 8, 1, 6, 7, 4, 2, 3};
    int[] list = {2, 3, 1, 4, 42, 4, 59, 32, 39, 44, 13, 22, 29, 14, 33, 17, 30, 9, 68};
    heapSort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }
  }
}
