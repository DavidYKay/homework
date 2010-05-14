import java.awt.*;
import javax.swing.ImageIcon;

public class ImageIconProxy extends ImageIcon {
  private java.net.URL url;
  private String filename;
  private ImageIcon image;

  /** Constructs a proxy for delayed loading of an image file */
  public ImageIconProxy(String filename) {
    this.filename = filename;
  }

  /** Constructs a proxy for delayed loading of an image from URL */
  public ImageIconProxy(java.net.URL url) {
    this.url = url;
  }

  /** Override paintIcon to display image icon */
  public void paintIcon(Component c, Graphics g, int x, int y) {
    // Load the image if it hasn't been loaded yet.
    if (image == null) {
      if (filename != null) {
        System.out.println("Loading " + filename);
        image = new ImageIcon(filename);
      }
      else if (url != null) {
        System.out.println("Loading " + url);
        image = new ImageIcon(url);
      }
    }

    image.paintIcon(c, g, x, y);
  }

  /** Override getIconWidth to return icon width */
  public int getIconWidth() {
    return (image == null) ? 200 : image.getIconWidth();
  }

  /** Override getIconHeight to return icon height */
  public int getIconHeight() {
    return (image == null) ? 100 : image.getIconHeight();
  }
}
