import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IntPanel extends JPanel {

	public IntPanel() {		
        setLayout(
            new BorderLayout()
        );

        JPanel cellPanel = new JPanel();
        cellPanel.setLayout(
            new GridLayout(2, 2)
        );

        final JTextField field1 = new JTextField();
        final JTextField field2 = new JTextField();
        final JLabel result = new JLabel();

        cellPanel.add(
            new JLabel("Number one")
        );
        cellPanel.add(field1);
        cellPanel.add(
            new JLabel("Number two")
        );
        cellPanel.add(field2);

        JButton button = new JButton("Divide");
        button.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    int a, b;
                    try {
                        a = Integer.parseInt(
                            field1.getText()
                        );
                        b = Integer.parseInt(
                            field2.getText()
                        );
                    } catch (NumberFormatException ex) {
                        result.setText("Error: input number is not an integer");
                        return;
                    }
                    try {
                        result.setText(
                            String.valueOf(
                                a / b
                            )
                        );
                    } catch (ArithmeticException ex) {
                        System.err.println(ex);
                        result.setText(
                            "Error: Divide by zero"
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
            BorderLayout.EAST
        );
        add(
            result,
            BorderLayout.SOUTH
        );
	}
    public Dimension getPreferredSize() {
		return new Dimension(300, 300);
    }
}
