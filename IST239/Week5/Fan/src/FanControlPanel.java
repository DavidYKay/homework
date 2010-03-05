import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FanControlPanel extends JPanel implements AdjustmentListener {

    FanPanel fanPanel;
    public FanControlPanel() {
        setLayout(
            new BoxLayout(
                this,
                BoxLayout.Y_AXIS
            )
        );
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,3));
        //Buttons
        JButton startButton   = new JButton("Start");
        startButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    startFan();
                }
            }
        );
        buttonPanel.add(startButton);

        JButton stopButton    = new JButton("Stop");
        buttonPanel.add(stopButton);
        stopButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    stopFan();
                }
            }
        );

        JButton reverseButton = new JButton("Reverse");
        buttonPanel.add(reverseButton);
        reverseButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    reverseFan();
                }
            }
        );

        //The fan itself
        fanPanel = new FanPanel();

        JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        scrollBar.addAdjustmentListener(this);
        add(buttonPanel);
        add(fanPanel);
        add(scrollBar);

        setBorder(
            BorderFactory.createLineBorder(Color.BLACK)
        );
    }

    private void startFan() {
        System.out.println("start fan!");
    }
    private void stopFan() {
        System.out.println("stop fan!");
    }
    private void reverseFan() {
        System.out.println("reverse fan!");
    }

    /**
     * Called by the scrollbar event
     */
    public void adjustmentValueChanged(AdjustmentEvent e) {
        System.out.println("Adjusted!");
    }
}
