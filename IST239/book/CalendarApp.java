import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class CalendarApp extends JApplet {
  // Create a CalendarPanel for showing calendars
  private CalendarPanel calendarPanel = new CalendarPanel();

  // Combo box for selecting available locales
  private JComboBox jcboLocale = new JComboBox();

  // Declare locales to store available locales
  private Locale locales[] = Calendar.getAvailableLocales();

  // Buttons Prior and Next to displaying prior and next month
  private JButton jbtPrior = new JButton("Prior");
  private JButton jbtNext = new JButton("Next");

  /** Initialize the applet */
  public void init() {
    // Panel jpLocale to hold the combo box for selecting locales
    JPanel jpLocale = new JPanel();
    jpLocale.setBorder(new TitledBorder("Choose a locale"));
    jpLocale.setLayout(new FlowLayout());
    jpLocale.add(jcboLocale);

    // Initialize the combo box to add locale names
    for (int i = 0; i < locales.length; i++)
      jcboLocale.addItem(locales[i].getDisplayName());

    // Panel jpButtons to hold buttons
    JPanel jpButtons = new JPanel();
    jpButtons.setLayout(new FlowLayout());
    jpButtons.add(jbtPrior);
    jpButtons.add(jbtNext);

    // Panel jpCalendar to hold calendarPanel and buttons
    JPanel jpCalendar = new JPanel();
    jpCalendar.setLayout(new BorderLayout());
    jpCalendar.add(calendarPanel, BorderLayout.CENTER);
    jpCalendar.add(jpButtons, BorderLayout.SOUTH);

    // Place jpCalendar and jpLocale to the applet
    add(jpCalendar, BorderLayout.CENTER);
    add(jpLocale, BorderLayout.SOUTH);

    // Register listeners
    jcboLocale.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jcboLocale)
          calendarPanel.changeLocale(
            locales[jcboLocale.getSelectedIndex()]);
      }
    });

    jbtPrior.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int currentMonth = calendarPanel.getMonth();
        if (currentMonth == 1) {
          calendarPanel.setMonth(12);
          calendarPanel.setYear(calendarPanel.getYear() - 1);
        }
        else
          calendarPanel.setMonth(currentMonth - 1);
      }
    });

    jbtNext.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int currentMonth = calendarPanel.getMonth();
        if (currentMonth == 12) {
          calendarPanel.setMonth(1);
          calendarPanel.setYear(calendarPanel.getYear() + 1);
        }
        else
          calendarPanel.setMonth(currentMonth + 1);
      }
    });

    calendarPanel.changeLocale(
      locales[jcboLocale.getSelectedIndex()]);
  }

  /** Main method */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("CalendarApp");

    // Create an instance of the applet
    CalendarApp applet = new CalendarApp();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
