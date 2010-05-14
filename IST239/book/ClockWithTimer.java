import java.awt.event.*;
import javax.swing.Timer;

public class ClockWithTimer extends StillClock
  implements ActionListener {
  // Create a timer with delay 1000 ms
  protected Timer timer = new Timer(1000, this);

  public void suspend() {
    timer.stop(); // Suspend clock
  }

  public void resume() {
    timer.start(); // Resume clock
  }

  /** Handle the action event */
  public void actionPerformed(ActionEvent e) {
    // Set new time and repaint the clock to display current time
    setCurrentTime();
    repaint();
  }
}
