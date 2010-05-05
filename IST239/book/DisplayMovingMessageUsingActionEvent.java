import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DisplayMovingMessageUsingActionEvent extends JApplet {
  private TickUsingActionEvent tick =
    new TickUsingActionEvent(100, 1000, 100, 10);

  public DisplayMovingMessageUsingActionEvent() {
    MovingMessageNew messagePanel = new MovingMessageNew();
    getContentPane().add(messagePanel);
    tick.addActionListener(messagePanel);
  }

  class MovingMessageNew extends JPanel implements ActionListener {
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

    public void actionPerformed(ActionEvent e) {
      setMessage("tickCount: " + tick.getTickCount()
                 + " tickInterval: " + tick.getTickInterval());
      repaint();
    }
  }

  public static void main(String[] args) {
    DisplayMovingMessageUsingActionEvent applet =
         new DisplayMovingMessageUsingActionEvent();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("DisplayMovingMessage");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setSize(200, 80);
    frame.setVisible(true);
  }
}
