import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class FlagAnthem extends JApplet implements ActionListener {
  // Image viewer for displaying an image
  private ImageViewer imageViewer = new ImageViewer();

  // Combo box for selecting a country
  private JComboBox jcboCountry = new JComboBox(new String[] {
    "United States of America", "United Kingdom", "Denmark",
    "Norway", "China", "India", "Germany"});

  // Create flag images
  private Image[] images = {
    new ImageIcon(getClass().getResource("image/us.gif")).getImage(),
    new ImageIcon(getClass().getResource("image/uk.gif")).getImage(),
    new ImageIcon(
      getClass().getResource("image/denmark.gif")).getImage(),
    new ImageIcon(
      getClass().getResource("image/norway.gif")).getImage(),
    new ImageIcon(
      getClass().getResource("image/china.gif")).getImage(),
    new ImageIcon(
      getClass().getResource("image/india.gif")).getImage(),
    new ImageIcon(
      getClass().getResource("image/germany.gif")).getImage()
  };

  // Create audio clips
  private AudioClip[] audioClips = {
    Applet.newAudioClip(getClass().getResource("anthem/us.mid")),
    Applet.newAudioClip(getClass().getResource("anthem/uk.mid")),
    Applet.newAudioClip(getClass().getResource("anthem/denmark.mid")),
    Applet.newAudioClip(getClass().getResource("anthem/norway.mid")),
    Applet.newAudioClip(getClass().getResource("anthem/china.mid")),
    Applet.newAudioClip(getClass().getResource("anthem/india.mid")),
    Applet.newAudioClip(getClass().getResource("anthem/germany.mid"))
  };

  private int currentIndex = 0; // Denote the current selected index

  // Button to play an audio
  private JButton jbtPlayAnthem = new JButton("Play Anthem");

  /** Initialize the applet */
  public void init() {
    // Panel p to hold a label combo box and a button for play audio
    JPanel p = new JPanel();
    p.add(new JLabel("Select a country"));
    p.add(jcboCountry);
    p.add(jbtPlayAnthem);

    // By default, the US flag is displayed
    imageViewer.setImage(images[0]);

    // Place p and an image panel in the applet
    getContentPane().add(p, BorderLayout.NORTH);
    getContentPane().add(imageViewer, BorderLayout.CENTER);

    // Register listener
    jbtPlayAnthem.addActionListener(this);
    jcboCountry.addActionListener(this);
  }

  /** Handle ActionEvent */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jcboCountry)
      imageViewer.setImage(images[jcboCountry.getSelectedIndex()]);
    else if (e.getSource() == jbtPlayAnthem) {
      audioClips[currentIndex].stop(); // Stop current audio clip
      currentIndex = jcboCountry.getSelectedIndex();
      audioClips[currentIndex].play();
    }
  }

  /** Main method */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("FlagAnthem");

    // Create an instance of the applet
    FlagAnthem applet = new FlagAnthem();
    applet.init();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Display the frame
    frame.setSize(400, 300);
    frame.setVisible(true);
  }
}
