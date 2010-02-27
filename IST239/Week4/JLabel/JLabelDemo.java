import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class JLabelDemo extends JPanel implements ActionListener {

    private JButton mainButton;
    private ArrayList<JComboBox> comboBoxes = new ArrayList<JComboBox>();

    String[] horizontalAlignStrings = { 
        "LEFT"    , 
        "CENTER"  ,
        "RIGHT"   , 
        "LEADING" , 
        "TRAILING"
    };

    int[] horizontalAlignValues = { 
        SwingConstants.LEFT    , 
        SwingConstants.CENTER  ,
        SwingConstants.RIGHT   , 
        SwingConstants.LEADING , 
        SwingConstants.TRAILING
    };

    String[] verticalAlignStrings = { 
        "TOP"    , 
        "CENTER"  ,
        "BOTTOM"   
    };

    int[] verticalAlignValues = { 
        SwingConstants.TOP   , 
        SwingConstants.CENTER,
        SwingConstants.BOTTOM
    };

    public JLabelDemo() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        /** Button, which holds our label */
        mainButton = new JButton(
            "Grapes",
            new ImageIcon("ussr.png")
        );
        add(mainButton);

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

        JComboBox comboBox = new JComboBox(horizontalAlignStrings);
        comboBox.addActionListener(this);
        comboBoxPanel.add(comboBox);

        addBoxToList(comboBox);

        comboBox = new JComboBox(verticalAlignStrings);
        comboBox.addActionListener(this);
        comboBoxPanel.add(comboBox);
        
        addBoxToList(comboBox);

        mainPanel.add(comboBoxPanel);

        return mainPanel;
    }

    private void addBoxToList(JComboBox box) { 
        comboBoxes.add(box);
    }

	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		int index = cb.getSelectedIndex();
        String command = e.getActionCommand();
        Object source = e.getSource();
        System.out.println("Command: " + command);
        System.out.println("Source: " + source);
        if (source == comboBoxes.get(0)) {
            mainButton.setHorizontalAlignment(
                horizontalAlignValues[index]
            );
        } else if (source == comboBoxes.get(1)) {
            mainButton.setVerticalAlignment(
                verticalAlignValues[index]
            );
        } else if (source == comboBoxes.get(2)) {
            mainButton.setHorizontalTextPosition(
                horizontalAlignValues[index]
            );
        } else if (source == comboBoxes.get(3)) {
            mainButton.setVerticalTextPosition(
                verticalAlignValues[index]
            );
        }
        System.out.println("Index selected: " + index);
	}
}
