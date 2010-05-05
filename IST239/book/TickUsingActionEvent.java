import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.*;

public class TickUsingActionEvent
    implements java.io.Serializable, ActionListener {
  /** TickUsingActionEvent properties */
  private int tickCount = 0;
  private int tickInterval = 100;
  private int maxInterval = 5000;
  private int minInterval = 1;
  private int step = 0;

  /** Store listeners in a list */
  private ArrayList actionListenerList;

  // Control tick using a timer
  private Timer timer = new Timer(tickInterval, this);

  /** Construct a tick with the default properties */
  public TickUsingActionEvent() {
    this(100, 5000, 1, 0);
  }

  /** Construct a tick with the specified properties */
  public TickUsingActionEvent(int tickInterval, int maxInterval,
    int minInterval, int step) {
    this.tickInterval = tickInterval;
    this.maxInterval = maxInterval;
    this.minInterval = minInterval;
    this.step = step;

    // Start the thread
    timer.start();
  }

  /** Return tickCount */
  public long getTickCount() {
    return tickInterval;
  }

  /** Set a tickCount */
  public void setTickCount(int tickCount) {
    this.tickCount = tickCount;
  }

  /** Return tickInterval */
  public long getTickInterval() {
    return tickInterval;
  }

  /** Set tickInterval */
  public void setTickInterval(int tickInterval) {
    this.tickInterval = tickInterval;
    timer.setDelay(tickInterval);
  }

  /** Return maxInterval */
  public long getMaxInterval() {
    return maxInterval;
  }

  /** Set maxInterval */
  public void setMaxInterval(int maxInterval) {
    this.maxInterval = maxInterval;
  }

  /** Return minInterval */
  public long getMinInterval() {
    return minInterval;
  }

  /** Set minInterval */
  public void setMinInterval(int minInterval) {
    this.minInterval = minInterval;
  }

  /** Return step */
  public long getStep() {
    return step;
  }

  /** Set step */
  public void setStep(int step) {
    this.step = step;
  }

  /** Handle timer */
  public void actionPerformed(ActionEvent e) {
    if (tickInterval > maxInterval ||
        tickInterval < minInterval) {
      return;
    }

    // Increase the tick count and interval
    tickCount++;
    tickInterval += step;

    // Set new delay
    timer.setDelay(tickInterval);

    // Fire ActionEvent
    processEvent(new ActionEvent(this,
      ActionEvent.ACTION_PERFORMED, null));
  }

  /** Suspend the tick */
  public synchronized void suspend() {
    timer.stop();
  }

  /** Resume the tick */
  public synchronized void resume() {
    timer.start();
  }

  /** Register an action event listener */
  public synchronized void addActionListener(ActionListener l) {
    if (actionListenerList == null)
      actionListenerList = new ArrayList(2);

    if (!actionListenerList.contains(l))
      actionListenerList.add(l);
  }

  /** Remove an action event listener */
  public synchronized void removeActionListener(ActionListener l) {
    if (actionListenerList != null && actionListenerList.contains(l))
      actionListenerList.remove(l);
  }

  /** Fire ActionEvent */
  private void processEvent(ActionEvent e) {
    ArrayList list;

    synchronized (this) {
      list = (ArrayList)actionListenerList.clone();
    }

    for (int i = 0; i < list.size(); i++) {
      ActionListener listener = (ActionListener)list.get(i);
      listener.actionPerformed(e);
    }
  }
}
