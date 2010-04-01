import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ParseHex {
	public static void main(String[] args) {
		new ParseHex().test();
	}

	public void test() {
		JFrame frame = new JFrame();
		frame.setTitle("ParseHex");
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
