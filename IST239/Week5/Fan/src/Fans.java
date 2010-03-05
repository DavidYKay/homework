import java.awt.*;
import javax.swing.*;

public class Fans {

	public static void main(String[] args) {
		new Fans().test();
	}

	public void test() {
		JFrame frame = new JFrame();
		frame.setTitle("Fans");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

        JPanel fansPanel = new JPanel();
        fansPanel.setLayout(new GridLayout(1, 3));
        fansPanel.add(new FanControlPanel());
        fansPanel.add(new FanControlPanel());
        fansPanel.add(new FanControlPanel());

		frame.add(
            fansPanel,
            BorderLayout.CENTER
        );
        //Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton startButton = new JButton("Start All");
        buttonPanel.add(startButton);
        JButton stopButton = new JButton("Stop All");
        buttonPanel.add(stopButton);
		frame.add(
            buttonPanel,
            BorderLayout.SOUTH
        );

		frame.pack();
		frame.setVisible(true);
	}
}
