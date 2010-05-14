import java.util.*;

public class TestHolidays {
  public static void main(String[] args) {
    Holidays holidays = new Holidays();
    holidays.add(new java.util.Date());
    holidays.add(new GregorianCalendar(2005, 9, 1).getTime());
    holidays.add(new java.util.Date(12345678900000L));

    Iterator iterator = holidays.iterator();
    while (iterator.hasNext())
      System.out.println(iterator.next());
  }
}
