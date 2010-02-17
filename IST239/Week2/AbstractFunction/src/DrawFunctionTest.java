import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Provides the 'framework' for showcasing MultiDrawFunction
 * It does this by displaying a JComboBox and a JPanel
 * The JComboBox is used to select which function to view
 * The JPanel then renders the appropriate graph
 *
 * Note: Basic code for ComboBox, ContentPane, and EventQueue usage taken 
 * from Sun tutorial
 */
public class DrawFunctionTest extends JPanel
implements ActionListener {
    /** This is where the magic happens */
	MultiDrawFunction funcPanel;

	public DrawFunctionTest() {
		super(new BorderLayout());

        //Labels for the available functions
		String[] functionStrings = { 
            "X^2",
            "Sin(x)",
            "Cos(x)",
            "Tan(x)",
            "X^3",
            "Cos(x) + 5Sin(x)",
            "5Cos(x) + Sin(x)",
            "Log(x) + X^2",
            "X"
        };

		//Create the combo box, select the item at index 0.
		JComboBox funcOptionBox = new JComboBox(functionStrings);
		funcOptionBox.setSelectedIndex(0);
		funcOptionBox.addActionListener(this);

        //Create the function panel
        funcPanel = new MultiDrawFunction(0);

		//Lay out the demo.
		add(funcOptionBox, BorderLayout.PAGE_START);
		add(funcPanel, BorderLayout.CENTER);
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	}

	/** 
     * Listens to the combo box. 
     * In our case, we call updateGraph
     */
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		int index = cb.getSelectedIndex();
		updateGraph(index);
	}

    /**
     * Changes the graph to draw the selected function.
     */
	protected void updateGraph(int index) {
        //System.out.println("Index selected " + index );
        funcPanel.setFuncType(index);
        funcPanel.repaint();
	} 

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("MultiDrawFunction");
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
