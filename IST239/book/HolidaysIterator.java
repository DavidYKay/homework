import java.util.*;

public class HolidaysIterator implements Iterator<Date> {
  private ArrayList<Date> dates = new ArrayList<Date>();
  private int position = 0;

  public HolidaysIterator(ArrayList<Date> dates) {
    this.dates = dates;
  }

  public boolean hasNext() {
    return (position < dates.size());
  }

  public Date next() {
    return hasNext()? dates.get(position++) : null;
  }

  public void remove() {
    if (hasNext()) dates.remove(position);
  }
}
