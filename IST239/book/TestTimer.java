import javax.swing.JOptionPane;
import java.util.*;

public class TestTimer {
  public static void main(String[] args) {
    Timer timer = new Timer();
    Reminder task = new Reminder();
    timer.scheduleAtFixedRate(task, 0, 5 * 1000);
  }

  static class Reminder
      extends TimerTask {
    public void run() {
      JOptionPane.showMessageDialog(null,
                                    "Reminder: Time is now " +
                                    new Date().toString());
    }
  }
}
