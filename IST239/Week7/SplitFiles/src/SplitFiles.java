
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Split a given file into N different piece of equal size, 
 * INPUT: file name, with option to browse filesystem
 * OUTPUT: N different equally sized chunks
 */
public class SplitFiles {
	public static void main(String[] args) {
		new SplitFiles().test();
	}
	public void test() {
		JFrame frame = new JFrame();
		frame.setTitle("SplitFiles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
        JPanel splitPanel = new SplitPanel();
		frame.add(
            splitPanel,
            BorderLayout.CENTER
        );
		frame.pack();
		frame.setVisible(true);
	}
}
