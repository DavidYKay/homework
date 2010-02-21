import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A Game that tests hand-eye coordination of the player
 */
public class HandEyeTest extends JPanel implements NewGameListener {
    /** This is where the magic happens */
	HandEyePanel handEyePanel;

	public HandEyeTest() {
		super(new BorderLayout());

        //Create the function panel
        handEyePanel = new HandEyePanel(400, 400);
        handEyePanel.setBackground(Color.RED);

        OptionsPanel optionsPanel = new OptionsPanel(this);
        //Lay out the demo.
        add(handEyePanel, BorderLayout.CENTER);
        add(optionsPanel, BorderLayout.WEST);
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	}

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("Hand-Eye Coordination");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
        frame.add(new HandEyeTest());
		//frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
		//JComponent newContentPane = new HandEyeTest();
		//newContentPane.setOpaque(true); //content panes must be opaque
		//frame.setContentPane(newContentPane);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

    public void newGameEvent() {
        handEyePanel.newGame();
    }
}
