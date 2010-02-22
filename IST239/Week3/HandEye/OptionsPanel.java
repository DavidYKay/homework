import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Panel to hold buttons, options for the game
 */
public class OptionsPanel extends JPanel {
	
	private NewGameListener listener;

	public OptionsPanel(NewGameListener listener) {
		this.listener = listener;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JButton button = new JButton("New Game");
		button.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					notifyListeners();
				}
			}
		);
		add(button);
		button = new JButton("Quit");
		button.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			}
		);
		add(button);
	}

	private void notifyListeners() {
		listener.newGameEvent();
	}
}
