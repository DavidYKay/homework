import java.awt.*;

import javax.swing.*;

public class FanControlPanel extends JPanel {

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
        JButton startButton   = new JButton("Start");
        JButton stopButton    = new JButton("Stop");
        JButton reverseButton = new JButton("Reverse");
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(reverseButton);
        fanPanel = new FanPanel();
        JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        add(buttonPanel);
        add(fanPanel);
        add(scrollBar);

        setBorder(
            BorderFactory.createLineBorder(Color.BLACK)
        );
    }

}
