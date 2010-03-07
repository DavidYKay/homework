package edu.mccc.cos210.leddisplay;
import com.cbthinkx.util.Debug;
public abstract class LEDDisplayTransition {
	private String data = "";
	public static LEDDisplayTransition getTransition(String s) {
		Debug.println("LEDDisplayTransition.getTransition()");
		LEDDisplayTransition transition = null;
		try {
			Class c = Class.forName("edu.mccc.cos210.leddisplay.transition.Transition" + s);
			transition = (LEDDisplayTransition) c.newInstance();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return transition;
	}
	public final String getData() {
		Debug.println("LEDDisplayTransition.getData()");
		return this.data;
	}
	public final void setData(String s) {
		Debug.println("LEDDisplayTransition.setData()");
		this.data = s;
	}
	public abstract void go(LEDDisplayView view, LEDDisplayView.LED[][] leds);
}
