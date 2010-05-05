import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class TestTree extends JFrame {
  ImageIcon yourCustomLeafImageIcon =
    new ImageIcon(getClass().getResource("image/caIcon.gif"));
  ImageIcon yourCustomOpenImageIcon =
    new ImageIcon(getClass().getResource("image/chinaIcon.gif"));
  ImageIcon yourCustomClosedImageIcon =
    new ImageIcon(getClass().getResource("image/germanyIcon.gif"));

  public static void main(String[] args) {
    TestTree frame = new TestTree();
    frame.setTitle("A Sample Tree");
    frame.setSize(300, 300);
    frame.setVisible(true);
  }

  public TestTree() {
    JTree jTree1 = new JTree();

//    DefaultTreeCellRenderer renderer =
//        (DefaultTreeCellRenderer) jTree1.getCellRenderer();
//    renderer.setLeafIcon(yourCustomLeafImageIcon);
//    renderer.setOpenIcon(yourCustomOpenImageIcon);
//    renderer.setClosedIcon(yourCustomClosedImageIcon);
//    renderer.setBackgroundSelectionColor(Color.red);

    // Customize editor
//JComboBox jcboColor = new JComboBox();
//jcboColor.addItem("red");
//jcboColor.addItem("green");
//jcboColor.addItem("blue");
//jcboColor.addItem("yellow");
//jcboColor.addItem("orange");
//
//jTree1.setCellEditor(new javax.swing.DefaultCellEditor(jcboColor));
//        jTree1.setEditable(true);

//        jTree1.setCellEditor
//          (new javax.swing.tree.DefaultTreeCellEditor(jTree1,
//            new javax.swing.tree.DefaultTreeCellRenderer(),
//                    new javax.swing.DefaultCellEditor(jcboColor)));

    this.getContentPane().add(jTree1);
  }
}
