import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * ComboBoxDemo.java uses these additional files:
 *   images/Bird.gif
 *   images/Cat.gif
 *   images/Dog.gif
 *   images/Rabbit.gif
 *   images/Pig.gif
 */
public class ComboBoxDemo extends JPanel
implements ActionListener {
	MultiDrawFunction funcPanel;

	public ComboBoxDemo() {
		super(new BorderLayout());

		String[] functionStrings = { 
            "X^2",
            "Sin(x)",
            "Cos(x)",
            "Tan(x)",
            "X^3",
            "X"
        };

		//Create the combo box, select the item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		JComboBox funcOptionBox = new JComboBox(functionStrings);
		funcOptionBox.setSelectedIndex(2);
		funcOptionBox.addActionListener(this);

        //funcPanel = new SquareDrawFunction();
        funcPanel = new MultiDrawFunction(5);

		//Lay out the demo.
		add(funcOptionBox, BorderLayout.PAGE_START);
		add(funcPanel, BorderLayout.CENTER);
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	}

	/** Listens to the combo box. */
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		String petName = (String)cb.getSelectedItem();
		int index = cb.getSelectedIndex();
		updateGraph(index);
	}

	protected void updateGraph(int index) {
		//funcPanel.setToolTipText("A drawing of a " + name.toLowerCase());
        System.out.println("Index selected " + index );
//        funcPanel = new MultiDrawFunction(index);
        funcPanel.setFuncType(index);
        funcPanel.repaint();
        funcPanel.invalidate();
	} 

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("ComboBoxDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create and set up the content pane.
		JComponent newContentPane = new ComboBoxDemo();
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
