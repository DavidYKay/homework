import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DrawTest {
	 public static void main(String[] args) {

         javax.swing.SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 new DrawTest().test();
             }
         });
     }

	    public void test() {
	        JFrame frame = new JFrame();
	        frame.setTitle("Abstract Formula");

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocationRelativeTo(null);
	        frame.setLayout(new BorderLayout());

            JComponent newContentPane = new ComboBoxDemo();
            newContentPane.setOpaque(true); //content panes must be opaque
            frame.setContentPane(newContentPane);

	        //frame.add(new AbstractDrawFunction(), BorderLayout.CENTER);
	        //frame.add(new SquareDrawFunction(), BorderLayout.CENTER);
	        frame.pack();
	        frame.setVisible(true);
	    }

}
