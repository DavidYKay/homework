package edu.mccc.cos210.leddisplay.transition;
import edu.mccc.cos210.leddisplay.*;
import com.cbthinkx.util.Debug;
public class Transition0 extends LEDDisplayTransition {
	public void go(LEDDisplayView view, LEDDisplayView.LED[][] leds) {
		Debug.println("Transition0.go()");
		try {
            view.clearLEDs();
            //Milliseconds
			Thread.sleep(1000);
            view.setLEDs();
			Thread.sleep(1000);
            view.clearLEDs();
		} catch (Exception ex) {
		}
	}
}
