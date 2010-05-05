// TestCopyArray.java: Demonstrate copying arrays
public class TestCopyArray {
  /** Main method */
  public static void main(String[] args) {
    // Create an array and assign values
    int[] list1 = {0, 1, 2, 3, 4 ,5};

    // Create an array with default values
    int[] list2 = new int[list1.length];

    // Assign array list1 to array list2
    list2 = list1;

    // Display list1
    System.out.println("Before modifying list1");
    System.out.print("list1 is ");
    for (int i = 0; i < list1.length; i++)
      System.out.print(list1[i] + " ");

    // Display list2
    System.out.print("\nlist2 is ");
    for (int i = 0; i < list2.length; i++)
      System.out.print(list2[i] + " ");

    // Modify list1
    for (int i = 0; i < list1.length; i++)
      list1[i] = 0;

    // Display list1 and list2 after modifying list1
    System.out.println("\n\nAfter modifying list1");
    System.out.print("list1 is ");
    for (int i = 0; i < list1.length; i++)
      System.out.print(list1[i] + " ");

    // Display list2
    System.out.print("\nlist2 is ");
    for (int i = 0; i < list2.length; i++)
      System.out.print(list2[i] + " ");
  }
}