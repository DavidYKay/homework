import java.util.*;

public class Holidays {
  private ArrayList<Date> dates = new ArrayList<Date>();

  public void add(Date date) {
    dates.add(date);
  }

  public HolidaysIterator iterator() {
    return new HolidaysIterator(dates);
  }
}
