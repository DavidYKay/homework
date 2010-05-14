// ViewWebPage.java: Access HTML pages through applets
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class ViewWebPage extends JApplet implements ActionListener {
  // Button to display an HTML page on the applet
  private JButton jbtGo = new JButton("Go");

  // Text field for receiving the URL of the HTML page
  private JTextField jtfURL = new JTextField(20);

  /** Initialize the applet */
  public void init() {
    // Add URL text field and Go button
    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(new JLabel("URL"));
    getContentPane().add(jtfURL);
    getContentPane().add(jbtGo);

    // Register listener
    jbtGo.addActionListener(this);
  }

  /** Handle the ActionEvent */
  public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == jbtGo)
      try {
        AppletContext context = getAppletContext();

        // Get the URL from text field
        URL url = new URL(jtfURL.getText());
        context.showDocument(url);
      }
      catch(Exception ex) {
        showStatus("Error " + ex);
      }
  }
}
