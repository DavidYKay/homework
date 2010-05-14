import javax.swing.*;
import java.awt.*;

public class DisplayMovingMessage extends JApplet {
  public DisplayMovingMessage() {
    MovingMessage messagePanel = new MovingMessage();
    getContentPane().add(messagePanel);
    Tick tick = new Tick(100, 1000, 100, 10);
    tick.addTickListener(messagePanel);
  }

  class MovingMessage extends JPanel implements TickListener {
    private int xCoordinate = 20;
    private int yCoordinate = 20;
    private String message = "I am moving";

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (xCoordinate > getWidth())
        xCoordinate = -20;
      else
        xCoordinate += 5;
      g.drawString(message, xCoordinate, yCoordinate);
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public void handleTick(TickEvent e) {
      setMessage("tickCount: " + e.getTickCount() +
                 " tickInterval: " + e.getTickInterval());
      repaint();
    }
  }

  public static void main(String[] args) {
    DisplayMovingMessage applet = new DisplayMovingMessage();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("DisplayMovingMessage");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setSize(200, 80);
    frame.setVisible(true);
  }
}
