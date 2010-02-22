package edu.mccc.cos210.shifter;
import java.awt.*;
import javax.swing.*;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class ShifterView extends JPanel implements ShifterModelListener {
	private ShifterModel model;
	private Car car;
	private int maxGear;
	private int gear;
	public ShifterView(ShifterModel model) {
		Debug.println("ShifterView:ShifterView()");
		this.model = model;
		this.car = model.getCar();
		this.maxGear = model.getMaxGear();
		this.gear = model.getGear();
		setOpaque(false);
		setLayout(null);
		setFont(
			getFont().deriveFont(32.0f)
		);
	}
	public void paintComponent(Graphics g) {
		Debug.println("ShifterView:paintComponent()");
		Debug.println("Graphics: " + g);
		super.paintComponent(g);
		Debug.println("Finished paintComponent");
		Graphics2D g2d = (Graphics2D) g.create();
		Debug.println(this.gear);
		Debug.println(this.maxGear);
        
		car.paintShifter(this, g2d, this.gear, this.maxGear);
		g2d.dispose();
	}
	public void shift(ShifterModelEvent e) {
		Debug.println("ShifterView:shift()");
		this.gear = e.getGear();
		repaint();
	}
}
