package edu.mccc.cos210.leddisplay;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.cbthinkx.util.Debug;
public class LEDDisplayView extends JPanel implements Runnable {
	private LEDDisplayQueue queue;
	private LED[][] leds = new LED[10][80];
	public LEDDisplayView(LEDDisplayQueue queue) {
		Debug.println("LEDDisplayView.LEDDisplayView()");
		this.queue = queue;
		setLayout(new GridLayout(10, 80));
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 80; col++) {
				this.leds[row][col] = new LED();
				add(this.leds[row][col]);
			}
		}
	}
	public Dimension getPreferredSize() {
		Debug.println("LEDDisplayView.getPreferredSize()");
		return new Dimension(800, 100);
	}
	public void run() {
		Debug.println("LEDDisplayView.run()");
		LEDDisplayItem item = null;
		while ((item = this.queue.dequeue()) != null) {
			this.queue.enqueue(item);
			LEDDisplayTransition transition = item.getTransition();
			transition.setData(item.getItem());
			clearLEDs();
			transition.go(this, this.leds);
		}
	}
	public void clearLEDs() {
		Debug.println("LEDDisplayView.clearLEDs()");
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 80; col++) {
				LED led = leds[row][col];
				led.setState(false);
			}
		}
	}
	public void setLEDs() {
		Debug.println("LEDDisplayView.clearLEDs()");
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 80; col++) {
				LED led = leds[row][col];
				led.setState(true);
			}
		}
	}
	public class LED extends JPanel {
		private boolean state = false;
		public LED() {
			//Debug.println("LED.LED()");
			setLayout(null);
			setBackground(Color.LIGHT_GRAY);
			setBorder(new LineBorder(Color.BLACK));
		}
		public boolean isOn() {
			return this.state;
		}
		public boolean isOff() {
			return !this.state;
		}
		public void setState(boolean b) {
			//Debug.println("LED.setState()");
			this.state = b;
			if (this.state) {
				setBackground(Color.RED);
			} else {
				setBackground(Color.LIGHT_GRAY);
			}
		}
	}
}
