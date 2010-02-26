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

        //this.monthLabel = new JLabel("Months go here");
        this.monthLabel = new JLabel(
            getMonthString(),
            JLabel.CENTER
        );

        weekDays        = createWeekdaysComponent();
        mainCalendar    = new JLabel("Main Calendar");
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
        //return new JLabel("Days of week");

        JPanel panel = new JPanel();
        //panel.setLayout(new GridLayout(0, 1));
        panel.setLayout(new GridLayout(1, 0));
        
        for (DaysOfWeek day : DaysOfWeek.values()) {
            //protoDeck.add(new Card(rank, suit));
            panel.add(
                new JLabel(
                    day.getName()
                )
            );
        }

        return panel;
    }

    public Dimension getPreferredSize() {
        //return new Dimension(300, 300);
        return new Dimension(600, 600);
    }

    /*
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawOval(
                0,
                0,
                getWidth(),
                getHeight()
        );
    }
    */
}
