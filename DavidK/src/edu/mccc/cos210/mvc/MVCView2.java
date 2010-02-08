package edu.mccc.cos210.mvc;
import java.awt.*;
import javax.swing.*;
import com.cbthinkx.util.Debug;
public class MVCView2 extends JProgressBar implements MVCModelListener {
	private MVCModel model;
	public MVCView2(MVCModel model) {
		super(
			model.getMinimum(),
			model.getMaximum()
		);
		Debug.println("MVCView2()");
		this.model = model;
		setBackground(new Color(212, 32, 212).darker());
		setForeground(new Color(212, 32, 212).brighter());
		setBorderPainted(false);
	}
	public Dimension getPreferredSize() {
		Debug.println("MVCView2.getPreferredSize()");
		return new Dimension(800, 64);
	}
	public void stateChanged(MVCModelEvent e) {
		Debug.println("MVCView2.stateChanged()");
		setValue(this.model.getValue());
	}
}
