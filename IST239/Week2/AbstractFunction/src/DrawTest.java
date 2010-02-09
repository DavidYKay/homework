import java.awt.BorderLayout;

import javax.swing.JFrame;

public class DrawTest {
	 public static void main(String[] args) {
	        new DrawTest().test();
	    }
	    public void test() {
	        JFrame frame = new JFrame();
	        frame.setTitle("Circles");
//	        frame.setSize(800,600);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocationRelativeTo(null);
	        frame.setLayout(new BorderLayout());

	        frame.add(new SquareDrawFunction(), BorderLayout.CENTER);
	        frame.pack();
	        frame.setVisible(true);
	    }
}
