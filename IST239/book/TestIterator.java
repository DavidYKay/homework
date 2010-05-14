import java.util.*;

public class TestIterator {
  public static void main(String[] args) {
    Set<String> c1 = new HashSet<String>
      (Arrays.asList(new String[]{"London", "New York", "Chicago"}));
    Iterator iterator1 = c1.iterator();
    while (iterator1.hasNext())
      System.out.print(iterator1.next() + " ");

    System.out.println();
    List<String> c2 = new LinkedList<String>
      (Arrays.asList(new String[]{"London", "New York", "Chicago"}));
    Iterator iterator2 = c2.iterator();
    while (iterator2.hasNext())
      System.out.print(iterator2.next() + " ");
  }
}
