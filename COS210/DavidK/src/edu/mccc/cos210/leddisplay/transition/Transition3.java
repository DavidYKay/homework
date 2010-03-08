package edu.mccc.cos210.leddisplay.transition;
import edu.mccc.cos210.leddisplay.*;
import com.cbthinkx.util.Debug;
public class Transition3 extends DKTransition {
	public void go(LEDDisplayView view, LEDDisplayView.LED[][] leds) {
		Debug.println("Transition3.go()");
		view.setLEDs();
		try {
			Thread.sleep(1000);
		} catch (Exception ex) {
		}
	}
}
