import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz {

	public static void main(String[] args) {
		new Quiz().test();
	}

	public void test() {
		JFrame frame = new JFrame();
		frame.setTitle("Quiz");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

        frame.add(
            new QuizPanel(),
            BorderLayout.CENTER
        );

		frame.pack();
		frame.setVisible(true);
	}
}
