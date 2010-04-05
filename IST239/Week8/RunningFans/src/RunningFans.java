import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RunningFans extends JApplet {
    private static final int NUM_FANS = 3;
    private ArrayList<FanControlPanel> fans;
    public void init() {
		this.setLayout(new BorderLayout());

        JPanel fansPanel = new JPanel();
        fansPanel.setLayout(new GridLayout(1, 3));

        fans = new ArrayList<FanControlPanel>();
        for (int i = 0; i < NUM_FANS; i++) {
            fans.add(new FanControlPanel());
        }
        for (FanControlPanel fan : fans) {
            fansPanel.add(fan);
        }

		this.add(
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
		this.add(
            buttonPanel,
            BorderLayout.SOUTH
        );
		//this.pack();
    }
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("RunningFans");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
        frame.setSize(1024, 600);
        RunningFans applet = new RunningFans();
        frame.add(applet);
        applet.init();
        frame.pack();
		frame.setVisible(true);
	}
}
