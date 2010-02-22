import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A Game that tests hand-eye coordination of the player
 */
public class HandEyeTest extends JPanel implements NewGameListener, GameScoreListener {
    /** This is where the magic happens */
	private HandEyePanel handEyePanel;
    private JLabel scoreLabel;

	public HandEyeTest() {
		super(new BorderLayout());

        //Create the function panel
        handEyePanel = new HandEyePanel(400, 400, this);
        handEyePanel.setBackground(Color.RED);

        OptionsPanel optionsPanel = new OptionsPanel(this);

        scoreLabel = new JLabel();
        updateScoreLabel(0);

        //Lay out the demo.
        add(handEyePanel, BorderLayout.CENTER);
        add(optionsPanel, BorderLayout.WEST);
        add(scoreLabel, BorderLayout.SOUTH);
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

    private void updateScoreLabel(long score) {
        scoreLabel.setText("Score: " + Long.toString(score));
    }

    /**
     * Handles the newgame event from the button
     */
    public void newGameEvent() {
        updateScoreLabel(0);
        handEyePanel.newGame();
    }
    /**
     * Handles the endGame event from the button
     */
    public void gameScoreEvent(GameScoreEvent e) {
        //scoreLabel.setText("WOOT");
        updateScoreLabel(e.getScore());
        //display final score
        System.out.println("gameScoreEvent executed!");
    }
}
