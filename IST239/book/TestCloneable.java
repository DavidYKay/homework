// TestCloneable.java: Cloning objects
public class TestCloneable {
  /** Main method */
  public static void main(String[] args) {
    // Declare and create an instance of CloneableCircle
    CloneableCircle c1 = new CloneableCircle(5);
    CloneableCircle c2 = (CloneableCircle)c1.clone();

    System.out.println("After cloning c1 to c2");

    // Check if two variables point to the same object
    System.out.println("Do c1 and c2 reference the same object? "
      + (c1 == c2));

    // Check if the date field of two objects are the same
    System.out.println("Do c1.date and c2.date reference " +
      "the same object? " + (c1.date == c2.date));

    System.out.println("Is a CloneableCircle object cloneable? "
      + (c1 instanceof Cloneable));

    // Check if a Circle object is cloneable
    Circle c = new Circle();
    System.out.println("Is a Circle object cloneable? "
      + (c instanceof Cloneable));
  }
}

// CloneableCircle is a subclass of Circle, which implements the
// Cloneable interface
class CloneableCircle extends Circle implements Cloneable {
  // Store the date when the object is created
  java.util.Date date = new java.util.Date();

  /** Construct a CloneableCircle with a specified radius */
  public CloneableCircle(double radius) {
    super(radius);
  }

  /** Override the protected clone method defined in the Object
     class, and strengthen its accessibility */
  public Object clone() {
    try {
      return super.clone();
    }
    catch (CloneNotSupportedException ex) {
      return null;
    }
  }
}
