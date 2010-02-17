import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Provides the 'framework' for showcasing MultiDrawFunction
 * It does this by displaying a JComboBox and a JPanel
 * The JComboBox is used to select which function to view
 * The JPanel then renders the appropriate graph
 *
 * Note: Basic code for ComboBox usage taken from Sun tutorial
 */
public class DrawFunctionTest extends JPanel
implements ActionListener {
    /** This is where the magic happens */
	AbstractDrawFunction funcPanel;

	public DrawFunctionTest() {
		super(new BorderLayout());

        funcPanel = new SquareDrawFunction();

		//Lay out the demo.
		add(funcPanel, BorderLayout.CENTER);
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	}

	/** Listens to the combo box. */
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		int index = cb.getSelectedIndex();
		updateGraph(index);
	}

	protected void updateGraph(int index) {
        //System.out.println("Index selected " + index );
        funcPanel.repaint();
	} 

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("SquareFunction");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create and set up the content pane.
		JComponent newContentPane = new DrawFunctionTest();
		newContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(newContentPane);

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
