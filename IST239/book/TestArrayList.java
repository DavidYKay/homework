public class TestArrayList {
  public static void main(String[] args) {
    // Create a list to store cities
    java.util.ArrayList cityList = new java.util.ArrayList();

    // Add some cities in the list
    cityList.add("London");
    // cityList now contains [London]
    cityList.add("New York");
    // cityList now contains [London, New York]
    cityList.add("Paris");
    // cityList now contains [London, New York, Paris]
    cityList.add("Toronto");
    // cityList now contains [London, New York, Paris, Toronto]
    cityList.add("Hong Kong");
    // contains [London, New York, Paris, Toronto, Hong Kong]
    cityList.add("Singapore");
    // contains [London, New York, Paris, Toronto,
    //             Hong Kong, Singapore]

    System.out.println("List size? " + cityList.size());
    System.out.println("Is Toronto in the list? " +
      cityList.contains("Toronto"));
    System.out.println("The location of New York in the list? "
      + cityList.indexOf("New York"));
    System.out.println("Is the list empty? " +
      cityList.isEmpty()); // Print false

    // Insert a new city at index 2
    cityList.add(2, "Beijing");
    // contains [London, New York, Beijing, Paris, Toronto,
    //             Hong Kong, Singapore]

    // Remove a city from the list
    cityList.remove("Toronto");
    // contains [London, New York, Beijing, Paris,
    //             Hong Kong, Singapore]

    // Remove a city at index 1
    cityList.remove(1);
    // contains [London, Beijing, Paris, Hong Kong, Singapore]

    // Display London Beijing Paris Hong Kong Singapore
    for (int i = 0; i < cityList.size(); i++)
      System.out.print(cityList.get(i) + " ");
    System.out.println();

    // Create a list to store two circles
    java.util.ArrayList list = new java.util.ArrayList();

    // Add two circles
    list.add(new Circle(2));
    list.add(new Circle(3));

    // Display the area of the first circle in the list
    System.out.println("The area of the circle? " +
      ((Circle)list.get(0)).getArea());
  }
}
