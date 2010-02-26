import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CalendarPanel extends JPanel {
    private GregorianCalendar calendar;

    private JLabel monthLabel;
    private JComponent weekDays;
    private JComponent mainCalendar;

    public CalendarPanel() {
        this.calendar = new GregorianCalendar();

        this.monthLabel = new JLabel(
            getMonthString(),
            JLabel.CENTER
        );
        this.weekDays     = createWeekdaysComponent();
        //this.mainCalendar = new JLabel("Main Calendar");
        this.mainCalendar = createCalendarComponent();

        //Vertical BoxLayout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(monthLabel);
        add(weekDays);
        add(mainCalendar);
                //GridLayout
                //DayLabels
    }

    private String getMonthString() {
        return String.format(
            "%d / %d",
            calendar.get(Calendar.MONTH) + 1, //Offset by one since it's 0-based
            calendar.get(Calendar.YEAR)
        );
    }

    private JComponent createWeekdaysComponent() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0));
        
        for (DaysOfWeek day : DaysOfWeek.values()) {
            panel.add(
                new JLabel(
                    day.getName(),
                    JLabel.CENTER
                )
            );
        }

        return panel;
    }

    private JComponent createCalendarComponent() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 7));
        //panel.setLayout(new GridLayout(6, 8));
        
        //Insert some blank days before the first of the month
        int numBlanks = 6;
        for (int i = 1; i <= numBlanks; i++) {
            JComponent blank = new JLabel();
            panel.add(blank);
        }

        int monthMax = 31;
        for (int i = 1; i <= monthMax; i++) {
            JLabel label = new JLabel(
                String.valueOf(i),
                JLabel.RIGHT
            );
            label.setBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2) 
            );
            panel.add(label);
        }

        return panel;
    }


    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
}
