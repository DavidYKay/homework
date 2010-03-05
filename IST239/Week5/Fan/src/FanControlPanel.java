import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FanControlPanel extends JPanel implements ActionListener, AdjustmentListener {

    private FanPanel fanPanel;
    private Timer fanTimer;
    private boolean forwards;
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

        //JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        //JScrollBar(int orientation, int value, int extent, int min, int max) 
        JScrollBar scrollBar = new JScrollBar(
            JScrollBar.HORIZONTAL,
            180,
            0,
            0,
            360
        );

        scrollBar.addAdjustmentListener(this);
        add(buttonPanel);
        add(fanPanel);
        add(scrollBar);

        setBorder(
            BorderFactory.createLineBorder(Color.BLACK)
        );
        
        fanTimer = new Timer(100, this);
    }

    private void startFan() {
        System.out.println("start fan!");
        fanTimer.start();
    }
    private void stopFan() {
        System.out.println("stop fan!");
        fanTimer.stop();
    }
    private void reverseFan() {
        System.out.println("reverse fan!");
        forwards = !forwards;
    }

    /**
     * Called by the timer event
     */
    public void actionPerformed(ActionEvent e) {
        System.out.println("Timer event!");
        int newAngle;
        if (forwards) {
            newAngle = fanPanel.getCurrentAngle() + 10;
        } else {
            newAngle = fanPanel.getCurrentAngle() - 10;
        }
        fanPanel.setCurrentAngle(newAngle);
    }

    /**
     * Called by the scrollbar event
     */
    public void adjustmentValueChanged(AdjustmentEvent e) {
        System.out.println("Adjusted!");
        fanPanel.setCurrentAngle(e.getValue());
    }
}
