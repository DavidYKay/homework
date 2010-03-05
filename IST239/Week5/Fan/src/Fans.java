import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fans {
    private static final int NUM_FANS = 3;

    private ArrayList<FanControlPanel> fans;

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

        fans = new ArrayList<FanControlPanel>();
        for (int i = 0; i < NUM_FANS; i++) {
            fans.add(new FanControlPanel());
        }
        for (FanControlPanel fan : fans) {
            fansPanel.add(fan);
        }

		frame.add(
            fansPanel,
            BorderLayout.CENTER
        );
        //Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton startButton = new JButton("Start All");
        startButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for (FanControlPanel fan : fans) {
                        fan.startFan();
                    }
                }
            }
        );
        buttonPanel.add(startButton);
        JButton stopButton = new JButton("Stop All");
        stopButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for (FanControlPanel fan : fans) {
                        fan.stopFan();
                    }
                }
            }
        );

        buttonPanel.add(stopButton);
		frame.add(
            buttonPanel,
            BorderLayout.SOUTH
        );

		frame.pack();
		frame.setVisible(true);
	}
}
