import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FanControlPanel extends JPanel implements ActionListener, AdjustmentListener {
    private static final int FAN_TICK = 5;

    private FanPanel fanPanel;
    private Timer fanTimer;
    private boolean forwards;
    private JScrollBar scrollBar;
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

        //JScrollBar(int orientation, int value, int extent, int min, int max) 
        scrollBar = new JScrollBar(
            JScrollBar.HORIZONTAL,
            150,
            0,
            0,
            300
        );

        scrollBar.addAdjustmentListener(this);
        add(buttonPanel);
        add(fanPanel);
        add(scrollBar);

        setBorder(
            BorderFactory.createLineBorder(Color.BLACK)
        );
        
        fanTimer = new Timer(
            scrollBar.getValue(), 
            this
        );
    }

    public void startFan() {
        System.out.println("start fan!");
        fanTimer.start();
    }
    public void stopFan() {
        System.out.println("stop fan!");
        fanTimer.stop();
    }
    public void reverseFan() {
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
            newAngle = fanPanel.getCurrentAngle() + FAN_TICK;
        } else {
            newAngle = fanPanel.getCurrentAngle() - FAN_TICK;
        }
        fanPanel.setCurrentAngle(newAngle);
    }

    /**
     * Called by the scrollbar event
     */
    public void adjustmentValueChanged(AdjustmentEvent e) {
        System.out.println("Adjusted!");
        //Set the timer speed to the INVERSE of the value
        fanTimer.setDelay(
            scrollBar.getMaximum() - e.getValue()
        );
    }
}
