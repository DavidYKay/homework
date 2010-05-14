public class TestTrafficLight {
  public static void main(String[] args) {
    TrafficLight light = TrafficLight.red;
    System.out.println(light.getDescription());
    System.out.println(light instanceof Object);
    System.out.println(light instanceof Comparable);
  }
}
