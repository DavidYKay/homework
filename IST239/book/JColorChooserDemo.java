import javax.swing.*;
import java.awt.Color;

public class JColorChooserDemo extends javax.swing.JApplet {
  public void init() {
    Color color = JColorChooser.showDialog(this, "Choose a color",
      Color.YELLOW);
  }
}
