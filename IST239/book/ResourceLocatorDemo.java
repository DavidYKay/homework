// ResourceLocatorDemo.java: Demonstrate using resource locator to
// load image files and audio files to applets and applications
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.net.URL;
import java.applet.*;

public class ResourceLocatorDemo extends JApplet
  implements ActionListener, ItemListener {
  // Image panel for displaying an image
  private ImagePanel imagePanel = new ImagePanel();

  // Combo box for selecting a country
  private JComboBox jcboCountry = new JComboBox();

  // Button to play an audio
  private JButton jbtPlayAnthem = new JButton("Play Anthem");

  // Selected country
  private String country = "United States of America";

  /** Initialize the applet */
  public void init() {
    // Panel p to hold a label combo box and a button for play audio
    JPanel p = new JPanel();
    p.add(new JLabel("Select a country"));
    p.add(jcboCountry);
    p.add(jbtPlayAnthem);

    // Initialize the combo box
    jcboCountry.addItem("United States of America");
    jcboCountry.addItem("United Kingdom");
    jcboCountry.addItem("Denmark");
    jcboCountry.addItem("Norway");
    jcboCountry.addItem("China");
    jcboCountry.addItem("India");
    jcboCountry.addItem("Germany");

    // By default, the US flag is displayed
    imagePanel.showImage(createImage("us.gif"));
    imagePanel.setPreferredSize(new Dimension(300, 300));

    // Place p and an image panel in the applet
    getContentPane().add(p, BorderLayout.NORTH);
    getContentPane().add(imagePanel, BorderLayout.CENTER);
    imagePanel.setBorder(new LineBorder(Color.black, 1));

    // Register listener
    jbtPlayAnthem.addActionListener(this);
    jcboCountry.addItemListener(this);
  }

  /** Handle ActionEvent */
  public void actionPerformed(ActionEvent e) {
    // Get the file name
    String filename = null;

    // The .mid audio files are stored in the anthem folder
    if (country.equals("United States of America"))
      filename = "us.mid";
    else if (country.equals("United Kingdom"))
      filename = "uk.mid";
    else if (country.equals("Denmark"))
      filename = "denmark.mid";
    else if (country.equals("Norway"))
      filename = "norway.mid";
    else if (country.equals("China"))
      filename = "china.mid";
    else if (country.equals("India"))
      filename = "india.mid";
    else if (country.equals("Germany"))
      filename = "germany.mid";

    // Create an audio clip and play it
    createAudioClip(filename).play();
  }

  /** Handle ItemEvent */
  public void itemStateChanged(ItemEvent e) {
    // Get selected country
    country = (String)jcboCountry.getSelectedItem();

    // Get the file name
    String filename = null;

    // The .gif files are stored in the image folder
    if (country.equals("United States of America"))
      filename = "us.gif";
    else if (country.equals("United Kingdom"))
      filename = "uk.gif";
    else if (country.equals("Denmark"))
      filename = "denmark.gif";
    else if (country.equals("Norway"))
      filename = "norway.gif";
    else if (country.equals("China"))
      filename = "china.gif";
    else if (country.equals("India"))
      filename = "india.gif";
    else if (country.equals("Germany"))
      filename = "germany.gif";

    // Load image from the file and show it on the panel
    imagePanel.showImage(createImage(filename));
  }

  /** Create an audio from the specified file */
  public AudioClip createAudioClip(String filename) {
    // Get the URL for the file name
    URL url = this.getClass().getResource("anthem/" + filename);

    // Return the audio clip
    return Applet.newAudioClip(url);
  }

  /** Create an image from the specified file */
  public Image createImage(String filename) {
    // Get the URL for the file name
    URL url = this.getClass().getResource("image/" + filename);

    // Obtain an image icon
    ImageIcon imageIcon = new ImageIcon(url);

    // Return the image
    return imageIcon.getImage();
  }

  /** Main method */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Display Flags and Play Anthem");

    // Create an instance of the applet
    ResourceLocatorDemo applet = new ResourceLocatorDemo();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.pack();
    frame.setVisible(true);
  }
}