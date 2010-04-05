import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FanControlPanel extends JPanel implements AdjustmentListener {
    private static final int FAN_TICK = 5;

    private FanPanel fanPanel;
    private FanThread fanThread;
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
        
        fanThread = new FanThread(
            scrollBar.getMaximum() - scrollBar.getValue()
        );
        fanThread.start();
    }

    public void startFan() {
        System.out.println("start fan!");
        fanThread.setRunning(true);
    }
    public void stopFan() {
        System.out.println("stop fan!");
        fanThread.setRunning(false);
    }
    public void reverseFan() {
        System.out.println("reverse fan!");
        forwards = !forwards;
    }

    /**
     * Adjust the current fan angle
     */
    private void bumpFanAngle() {
        System.out.println("bumping fan!");
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
        //Set the thread delay to the INVERSE of the value
        fanThread.setDelay(
            scrollBar.getMaximum() - e.getValue()
        );
    }

    /**
     * Thread to manage the animation of the blades
     */
    private class FanThread extends Thread {
        private boolean running;
        private int delay;
        public FanThread(int delay) {
            this.delay = delay;
            this.running = false;
        }
        public void run() {
            for (;;) {
                if (running) {
                    System.out.println("thread running!");
                    bumpFanAngle();
                } 
                try {
                    sleep(delay);
                } catch (InterruptedException iex) {
                    System.err.println(iex.getMessage());
                }
            }
        }
        public void setDelay(int delay) {
            this.delay = delay;
        }
        public void setRunning(boolean running) {
            this.running = running;
        }
    }
}
