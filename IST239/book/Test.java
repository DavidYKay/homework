import javax.swing.*;
import javax.swing.event.*;
import java.awt.BorderLayout;
import java.util.*;

public class Test extends JApplet {
  // Create a JSpinner
  private JSpinner spinner = new JSpinner();

  // Create a JLabel
  private JLabel label = new JLabel("", JLabel.CENTER);

  public Test() {
    // Add spinner and label to the UI
    add(spinner, BorderLayout.NORTH);
    add(label, BorderLayout.CENTER);

    SpinnerDateModel model = new SpinnerDateModel(
      new Date(), null, null, Calendar.MONTH);
    spinner.setModel(model);

    // Register and create a listener
    spinner.addChangeListener(new ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent e) {
        label.setText("Previous value: " + spinner.getPreviousValue()
          + " Current value: " + spinner.getValue()
          + " Next value: " + spinner.getNextValue());
      }
    });
  }

  public static void main(String[] args) {
    String s = "Welcome".substring(3, 1);
    String s1 = "";
    System.out.println(s.length());
    System.out.println(s1.length());

    System.out.println("Welcome".substring(1, 1) + "RR");
    JOptionPane.showMessageDialog(null, "SSN not found", "For Your Information", JOptionPane.INFORMATION_MESSAGE);
    javax.swing.JFrame frame = new javax.swing.JFrame(
        "SimpleSpinner");

    Test applet = new Test();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, java.awt.BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Invoke init and start
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(300, 300);
    frame.setVisible(true);
  }
}
