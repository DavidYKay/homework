package edu.mccc.cos210.mvc;
import java.awt.*;
import javax.swing.*;
import com.cbthinkx.util.Debug;
public class MVCView1 extends JPanel implements MVCModelListener {
	private MVCModel model;
	public MVCView1(MVCModel model) {
		Debug.println("MVCView1()");
		this.model = model;
		setBackground(new Color(212, 32, 212));
		setLayout(null);
		setFont(
			getFont().deriveFont(256.0f)
		);
	}
	public void paintComponent(Graphics g) {
		Debug.println("MVCView1.paintComponent()");
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		String value = String.valueOf(model.getValue());
		int w = SwingUtilities.computeStringWidth(g2d.getFontMetrics(), value);
		g2d.setPaint(Color.BLACK);
		g2d.drawString(
			value,
			getWidth() / 2 - w / 2,
			getHeight() / 2
		);
		g2d.dispose();
	}
	public Dimension getPreferredSize() {
		Debug.println("MVCView1.getPreferredSize()");
		return new Dimension(800, 600);
	}
	public void stateChanged(MVCModelEvent e) {
		Debug.println("MVCView1.stateChanged()");
		repaint();
	}
}
