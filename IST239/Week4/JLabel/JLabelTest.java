import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class JLabelTest {

    public static void main(String[] sa) {
        new JLabelTest().doit();
    }

    public void doit() {
		JFrame frame = new JFrame();
		frame.setTitle("JLabel Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

        frame.add(new JLabelDemo());

		frame.pack();
		frame.setVisible(true);
    }
}
