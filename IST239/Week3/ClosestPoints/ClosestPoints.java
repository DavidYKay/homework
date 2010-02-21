import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A Game that tests hand-eye coordination of the player
 */
public class ClosestPoints extends JPanel {
    /** This is where the magic happens */
	private ClosestPointsPanel closestPointsPanel;
	
    public ClosestPoints() {
		super(new BorderLayout());

        //Create the function panel
        closestPointsPanel = new ClosestPointsPanel(400, 400, this);
        closestPointsPanel.setBackground(Color.RED);

        //Lay out the demo.
        add(closestPointsPanel, BorderLayout.CENTER);
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	}

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("Closest Points");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

        frame.add(new ClosestPoints());

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
}
