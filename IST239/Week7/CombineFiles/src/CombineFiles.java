import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Combine a given file into N different piece of equal size, 
 * INPUT: file name, N different equally sized chunks
 * OUTPUT: Reformed file
 */
public class CombineFiles {
	public static void main(String[] args) {
		new CombineFiles().test();
	}
	public void test() {
		JFrame frame = new JFrame();
		frame.setTitle("CombineFiles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
        JPanel combinePanel = new CombinePanel();
		frame.add(
            combinePanel,
            BorderLayout.CENTER
        );
		frame.pack();
		frame.setVisible(true);
	}
}
