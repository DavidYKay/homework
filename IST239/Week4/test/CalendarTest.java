import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CalendarTest {
    private GregorianCalendar calendar;

    public static void main(String[] sa) {
        new CalendarTest().doit();
    }

    public void doit() {
        this.calendar = new GregorianCalendar(
            2010, 
            1, 
            1
        );
        for (int i = 0; i < 12; i++) {
            //int firstDay = calendar.getFirstDayOfWeek();
            int firstDay = calendar.get(Calendar.DAY_OF_WEEK);
            System.out.println(
                    "Month: " + i
                    + "First day: " + firstDay
            );
            calendar.add(
                Calendar.MONTH,
                1
            );
        }
    }
}
