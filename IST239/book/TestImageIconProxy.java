import java.awt.*;
import javax.swing.*;

public class TestImageIconProxy extends JApplet {
  public TestImageIconProxy() {
    JTabbedPane tabbedPane = new JTabbedPane();
    tabbedPane.add(new JLabel(new ImageIconProxy(
      getClass().getResource("image/us.gif"))), "US");
    tabbedPane.add(new JLabel(new ImageIconProxy(
      getClass().getResource("image/ca.gif"))), "Canada");

    add(tabbedPane, BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    TestImageIconProxy applet = new TestImageIconProxy();
    JFrame frame = new JFrame();
    //EXIT_ON_CLOSE == 3
    frame.setDefaultCloseOperation(3);
    frame.setTitle("TestImageIconProxy");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400, 320);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
