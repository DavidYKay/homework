import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class IntPanel extends JPanel {
    int[] randomNum;

	public IntPanel() {		
        Random rand = new Random();
        randomNum = new int[100];
        for (int i = 0; i < randomNum.length; i++) {
            randomNum[i] = rand.nextInt();
        }

        setLayout(
            new BorderLayout()
        );

        JPanel cellPanel = new JPanel();
        cellPanel.setLayout(
            new GridLayout(2, 2)
        );

        final JTextField indexField = new JTextField();
        final JLabel result = new JLabel("Element");

        cellPanel.add(
            new JLabel("Input Index:")
        );
        cellPanel.add(
            indexField
        );
        cellPanel.add(
            new JLabel("Array Element:")
        );
        cellPanel.add(
            result
        );

        JButton button = new JButton("Show Element");
        button.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    try {
                        int index = Integer.parseInt(
                            indexField.getText()
                        );
                        result.setText(
                            String.valueOf(
                                randomNum[index]
                            )
                        );
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.err.println(ex);
                        result.setText(
                            "Array index out of bounds!"
                        );
                    } 
                }
            }
        );

        add(
            cellPanel,
            BorderLayout.CENTER
        );
        add(
            button,
            BorderLayout.SOUTH
        );
	}
    public Dimension getPreferredSize() {
		return new Dimension(500, 400);
    }
}
