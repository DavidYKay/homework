package edu.mccc.cos210.dial;
import java.awt.event.*;
import javax.swing.*;
import com.cbthinkx.util.Debug;
public class MVCController implements ActionListener {
	private MVCModel model;
	public MVCController(MVCModel model) {
		Debug.println("MVCController()");
		this.model = model;
		new Timer(333, this).start();
	}
	public void actionPerformed(ActionEvent e) {
		Debug.println("MVCController.actionPerformed()");
		this.model.setValue(this.model.getValue() + 1);
	}
}
