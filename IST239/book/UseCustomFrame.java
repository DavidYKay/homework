import javax.swing.*;

public class UseCustomFrame {
  public static void main(String[] args) {
    JFrame frame = new CustomFrame();
    frame.setTitle("Use CustomFrame");
    frame.setSize(200, 150);
    frame.setLocation(200, 100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}

