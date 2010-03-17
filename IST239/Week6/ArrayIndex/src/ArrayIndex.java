import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ArrayIndex {
	public static void main(String[] args) {
		new ArrayIndex().test();
	}

	public void test() {
		JFrame frame = new JFrame();
		frame.setTitle("ArrayIndex");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
        
        JPanel intPanel = new IntPanel();

		frame.add(
            intPanel,
            BorderLayout.CENTER
        );

		frame.pack();
		frame.setVisible(true);
	}
}
