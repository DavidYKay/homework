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
        this.mainCalendar = createCalendarComponent();

        //Vertical BoxLayout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(monthLabel);
        add(weekDays);
        add(mainCalendar);
    }

    private String getMonthString() {
        return String.format(
            "%d / %d",
            //Offset by one since it's 0-based
            calendar.get(Calendar.MONTH) + 1, 
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

        panel.setBorder(
            BorderFactory.createLineBorder(Color.BLACK, 1) 
        );
        return panel;
    }

    private JComponent createCalendarComponent() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 7));
        
        //Insert some blank days before the first of the month
        int numBlanks = 3;
        for (int i = 1; i <= numBlanks; i++) {
            JComponent blank = new JLabel();
            panel.add(blank);
        }

        int monthMax = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("Month max: " + monthMax);
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

        panel.setBorder(
            BorderFactory.createLineBorder(Color.BLACK, 1) 
        );
        return panel;
    }

    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
}
