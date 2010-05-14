public class TestSimpleCircle {
  /** Main method */
  public static void main(String[] args) {
    // Create a circle with radius 5.0
    SimpleCircle myCircle = new SimpleCircle(5.0);
    System.out.println("The area of the circle of radius "
      + myCircle.radius + " is " + myCircle.findArea());

    // Create a circle with radius 1
    SimpleCircle yourCircle = new SimpleCircle();
    System.out.println("The area of the circle of radius "
      + yourCircle.radius + " is " + yourCircle.findArea());

    // Modify circle radius
    yourCircle.radius = 100;
    System.out.println("The area of the circle of radius "
      + yourCircle.radius + " is " + yourCircle.findArea());
  }
}

// Define the circle class with two constructors
class SimpleCircle {
  double radius;

  /** Construct a circle with radius 1 */
  SimpleCircle() {
    radius = 1.0;
  }

  /** Construct a circle with a specified radius */
  SimpleCircle(double newRadius) {
    radius = newRadius;
  }

  /** Return the area of this circle */
  double findArea() {
    return radius * radius * 3.14159;
  }
}


