import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class IntPanel extends JPanel {

	public IntPanel() {		
        setLayout(
            new BorderLayout()
        );

        JPanel cellPanel = new JPanel();
        cellPanel.setLayout(
            new GridLayout(2, 2)
        );

        final JTextField inputField = new JTextField();
        final JLabel result = new JLabel("Result");

        cellPanel.add(
            new JLabel("Input hex string:")
        );
        cellPanel.add(
            inputField
        );
        cellPanel.add(
            new JLabel("Integer value:")
        );
        cellPanel.add(
            result
        );

        JButton button = new JButton("Parse Hex");
        button.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    try {
                        String input = inputField.getText();
                        int hex = parseHex(input);
                        result.setText(
                            String.valueOf(
                                hex
                            )
                        );
                    } catch (HexFormatException ex) {
                        System.err.println(ex);
                        result.setText(
                            "Invalid Hex String!"
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
    public int parseHex(String s) throws HexFormatException {
        if (!s.matches("0x[a-fA-F0-9]++")) {
            throw new HexFormatException();
        } else {
            return Integer.decode(s);
        }
    }
}
