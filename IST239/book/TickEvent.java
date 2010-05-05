public class TickEvent extends java.util.EventObject {
  /** tickCount counts the number of ticks for the event */
  private long tickCount;

  /** tickInterval is the interval between ticks in milliseconds */
  private long tickInterval;

  /** Construct a TickEvent */
  public TickEvent(Object source) {
    super(source);
  }

  /** Return tickCount */
  public long getTickCount() {
    return tickCount;
  }

  /** Set a new tickCount */
  public void setTickCount(long tickCount) {
    this.tickCount = tickCount;
  }

  /** Return tickInterval */
  public long getTickInterval() {
    return tickInterval;
  }

  /** Set a new tickInterval */
  public void setTickInterval(long milliseconds) {
    tickInterval = milliseconds;
  }
}
