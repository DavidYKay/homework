package edu.mccc.cos210.dial;
import java.awt.*;
import javax.swing.*;
import com.cbthinkx.util.Debug;
public class MVCView3 extends JPanel {
	private MVCModel model;
	public MVCView3(MVCModel model) {
		Debug.println("MVCView3()");
		this.model = model;
		setLayout(null);
		setBackground(Color.RED);
	}
	public void paintComponent(Graphics g) {
		Debug.println("MVCView3.paintComponent()");
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.dispose();
	}
	public Dimension getPreferredSize() {
		Debug.println("MVCView3.getPreferredSize()");
		return new Dimension(400, 400);
	}
}
