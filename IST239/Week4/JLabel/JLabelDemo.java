import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class JLabelDemo extends JPanel {

    String[] horizontalAlignStrings = { 
        "LEFT"    , 
        "CENTER"  ,
        "RIGHT"   , 
        "LEADING" , 
        "TRAILING"
    };

    String[] verticalAlignStrings = { 
        "TOP"    , 
        "CENTER"  ,
        "BOTTOM"   
    };

    public JLabelDemo() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        /** Button, which holds our label */
        JButton button = new JButton(
            "Grapes",
            new ImageIcon("ussr.png")
        );
        //button.setVerticalTextPosition(JButton.BOTTOM);
        //button.setHorizontalTextPosition(JButton.CENTER);
        add(button);

        JPanel bottomHalf = new JPanel();
        bottomHalf.add(createPanel(true));
        bottomHalf.add(createPanel(false));

        add(bottomHalf);
    }
    
    /**
     * Method to create both the left and the right panels
     */
    private JPanel createPanel(boolean isLeftPanel) {
        String title; 
        if (isLeftPanel) {
            title = "Horizontal Alignment";
        } else {
            title = "Text Position";
        }
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        mainPanel.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                title
            ) 
        );

        /** Panel to hold the 'horizontal' and 'vertical' labels */
        JPanel leftLabelsPanel = new JPanel();
        leftLabelsPanel.setLayout(new GridLayout(0,1));
        leftLabelsPanel.add(new JLabel("Horizontal"));
        leftLabelsPanel.add(new JLabel("Vertical"));
        mainPanel.add(leftLabelsPanel);

        /** Panel to hold the combo boxes */
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new GridLayout(0,1));
        comboBoxPanel.add(
            new JComboBox(horizontalAlignStrings)
        );
        comboBoxPanel.add(
            new JComboBox(verticalAlignStrings)
        );
        mainPanel.add(comboBoxPanel);

        return mainPanel;
    }

}
