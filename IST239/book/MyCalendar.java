// MyCalendar.java: A subclass of GregorianCalendar
import java.util.*;

public class MyCalendar extends GregorianCalendar {
  /** Find the number of days in a month */
  public int daysInMonth() {
    switch (get(MONTH)) {
      case 0: case 2: case 4: case 6: case 7: case 9: case 11:
        return 31;
      case 1: if (isLeapYear(get(YEAR))) return 29;
                else return 28;
      case 3: case 5: case 8: case 10: return 30;
      default: return 0;
    }
  }
}
