public class ClockApp extends javax.swing.JApplet {
  public ClockApp() {
    getContentPane().add(new ClockControl());
  }

  public static void main(String[] args) {
    ClockApp applet = new ClockApp();
    javax.swing.JFrame frame = new javax.swing.JFrame();
    frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    frame.setTitle("ClockApplet");
    frame.getContentPane().add(applet, java.awt.BorderLayout.CENTER);
    frame.setSize(400, 320);
    frame.setVisible(true);
  }
}
