import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalendarApp {

	public void doit() {
		JFrame frame = new JFrame();
		frame.setTitle("Calendar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

        frame.add(new CalendarPanel());
		frame.pack();
		frame.setVisible(true);
    }

	public static void main(String[] args) {
		new CalendarApp().doit();
	}
}
