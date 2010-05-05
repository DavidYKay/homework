public class TestSimpleCircle1 {
  /** Main method */
  public static void main(String[] args) {
    // Create circle1
    SimpleCircle1 circle1 = new SimpleCircle1();

    // Display circle1 BEFORE circle2 is created
    System.out.println("Before creating circle2");
    System.out.print("circle1 is : ");
    printCircle(circle1);

    // Create circle2
    SimpleCircle1 circle2 = new SimpleCircle1(5);

    // Change the radius in circle1
    circle1.radius = 9;

    // Display circle1 and circle2 AFTER circle2 was created
    System.out.println("\nAfter creating circle2 and modifying " +
      "circle1's radius to 9");
    System.out.print("circle1 is : ");
    printCircle(circle1);
    System.out.print("circle2 is : ");
    printCircle(circle2);
  }

  /** Print circle information */
  public static void printCircle(SimpleCircle1 c) {
    System.out.println("radius (" + c.radius +
      ") and number of Circle objects (" +
      c.numberOfObjects + ")");
  }
}
