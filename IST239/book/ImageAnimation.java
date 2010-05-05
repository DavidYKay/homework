import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageAnimation extends JApplet
    implements ActionListener {
  // Total number of images
  public final static int NUM_OF_IMAGES = 52;
  protected Image[] images = new Image[NUM_OF_IMAGES]; // Hold images
  protected int currentImageIndex = 0, // Current image subscript
                sleepTime = 100; // Milliseconds to sleep
  protected int direction = 1; // Image rotating direction

  // Image viewer to display an image
  private ImageViewer imageViewer = new ImageViewer();

  // Text field for setting animation speed
  protected JTextField jtfSpeed = new JTextField(5);

  // Button for reversing direction
  private JButton jbtReverse = new JButton("Reverse");

  // Create a timer with delay 1000 ms and listener Clock
  private Timer timer = new Timer(1000, this);

  /** Initialize the applet */
  public void init() {
    // Load the image, the image files are named
    // L1 - L52 in image directory
    for (int i = 0; i < images.length; i++ ) {
      images[i] = new ImageIcon(getClass().getResource(
        "image/L" + (i + 1) + ".gif")).getImage();
    }

    // Panel p to hold animation control
    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());
    p.add(new JLabel("Animation speed in millisecond"),
      BorderLayout.WEST);
    p.add(jtfSpeed, BorderLayout.CENTER);
    p.add(jbtReverse, BorderLayout.EAST);

    // Add the image panel and p to the applet
    getContentPane().add(imageViewer, BorderLayout.CENTER);
    getContentPane().add(p, BorderLayout.SOUTH);

    // Register listener
    jtfSpeed.addActionListener(this);
    jbtReverse.addActionListener(this);

    // Start the timer
    timer.start();
  }

  /** Handle ActionEvent */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jtfSpeed) {
      sleepTime = Integer.parseInt(jtfSpeed.getText());
      timer.setDelay(sleepTime);
    }
    else if (e.getSource() == jbtReverse) {
      direction = -direction;
    }
    else if (e.getSource() == timer) {
      imageViewer.setImage(
        images[currentImageIndex % NUM_OF_IMAGES]);

      // Make sure currentImageIndex is nonnegative
      if (currentImageIndex == 0) currentImageIndex = NUM_OF_IMAGES;
      currentImageIndex = currentImageIndex + direction;
    }
  }

  /** Main method */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("ImageAnimation");

    // Create an instance of the applet
    ImageAnimation applet = new ImageAnimation();
    applet.init();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Display the frame
    frame.setSize(200, 500);
    frame.setVisible(true);
  }
}
