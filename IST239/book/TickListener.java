public interface TickListener extends java.util.EventListener {
  /** Handle a TickEvent, to be implemented by a listener */
  public void handleTick(TickEvent e);
}