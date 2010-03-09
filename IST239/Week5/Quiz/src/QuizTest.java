import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuizTest extends JApplet {

    public void init() {
		setLayout(new BorderLayout());
        add(
            new QuizPanel(new QuizModel()),
            BorderLayout.CENTER
        );
    }

	public static void main(String[] args) {
		new QuizTest().test();
	}

	public void test() {
		JFrame frame = new JFrame();
		frame.setTitle("QuizTest");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

        frame.add(
            new QuizPanel(new QuizModel()),
            BorderLayout.CENTER
        );

		frame.pack();
		frame.setVisible(true);
	}
}
