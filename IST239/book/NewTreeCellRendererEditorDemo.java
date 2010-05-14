import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class NewTreeCellRendererEditorDemo extends JApplet {
  ImageIcon yourCustomLeafImageIcon =
    new ImageIcon(getClass().getResource("/image/caIcon.gif"));
  ImageIcon yourCustomOpenImageIcon =
    new ImageIcon(getClass().getResource("/image/flag16.gif"));
  ImageIcon yourCustomClosedImageIcon =
    new ImageIcon(getClass().getResource("/image/rbs.gif"));

  public NewTreeCellRendererEditorDemo() {
    JTree jTree1 = new JTree();
    getContentPane().add(new JScrollPane(jTree1),
      BorderLayout.CENTER);

    DefaultTreeCellRenderer renderer =
      (DefaultTreeCellRenderer)jTree1.getCellRenderer();
    renderer.setLeafIcon(yourCustomLeafImageIcon);
    renderer.setOpenIcon(yourCustomOpenImageIcon);
    renderer.setClosedIcon(yourCustomClosedImageIcon);
    renderer.setBackgroundSelectionColor(Color.red);

    // Customize editor
    JComboBox jcboColor = new JComboBox();
    jcboColor.addItem("red");
    jcboColor.addItem("green");
    jcboColor.addItem("blue");
    jcboColor.addItem("yellow");
    jcboColor.addItem("orange");


    jTree1.setCellEditor
      (new DefaultTreeCellEditor(jTree1,
        new DefaultTreeCellRenderer(),
                new DefaultCellEditor(jcboColor)));

//    jTree1.setCellEditor(new DefaultCellEditor(jcboColor));
    jTree1.setEditable(true);
  }

  public static void main(String[] args) {
    NewTreeCellRendererEditorDemo applet =
      new NewTreeCellRendererEditorDemo();
    JFrame frame = new JFrame();
    //EXIT_ON_CLOSE == 3
    frame.setDefaultCloseOperation(3);
    frame.setTitle("NewTreeCellRendererEditorDemo");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation((d.width - frame.getSize().width) / 2,
      (d.height - frame.getSize().height) / 2);
    frame.setVisible(true);
  }
}
