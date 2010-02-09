import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;


public class Fans {
	 public static void main(String[] args) {
	        new Fans().test();
	    }
	    public void test() {
	        JFrame frame = new JFrame();
	        frame.setTitle("Circles");
//	        frame.setSize(800,600);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocationRelativeTo(null);
	        frame.setLayout(new GridLayout(3, 3));

	        frame.add(new FanPanel());
	        frame.add(new FanPanel());
	        frame.add(new FanPanel());
	        frame.add(new FanPanel());
	        frame.pack();
	        frame.setVisible(true);
	    }
}
