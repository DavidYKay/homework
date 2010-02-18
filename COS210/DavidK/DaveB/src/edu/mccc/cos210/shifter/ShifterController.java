package edu.mccc.cos210.shifter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.cbthinkx.util.Debug;
public class ShifterController extends JPanel implements KeyListener {
	private ShifterModel model;
	public ShifterController(ShifterModel model) {
		Debug.println("ShifterController:ShifterController()");
		this.model = model;
		setLayout(new GridLayout(1, 1));
		setOpaque(false);
		addKeyListener(this);
	}
	public Dimension getPreferredSize() {
		Debug.println("ShifterController:getPreferredSize()");
		return new Dimension(144, 144);
	}
	public void keyPressed(KeyEvent e) {
		Debug.println("ShifterController:keyPressed()");
		switch (e.getKeyCode()) {
			case KeyEvent.VK_PERIOD:
				this.model.upShift();
				break;
			case KeyEvent.VK_COMMA:
				this.model.downShift();
				break;
			default:
				break;
		}
	}
	public void keyReleased(KeyEvent e) {
		Debug.println("ShifterController:keyReleased()");
	}
	public void keyTyped(KeyEvent e) {
		Debug.println("ShifterController:keyTyped()");
	}
}
