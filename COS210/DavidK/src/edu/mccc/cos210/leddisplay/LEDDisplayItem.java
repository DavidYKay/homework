package edu.mccc.cos210.leddisplay;
import com.cbthinkx.util.Debug;
public class LEDDisplayItem {
	private String item;
	private LEDDisplayTransition transition;
	public LEDDisplayItem(String item, LEDDisplayTransition transition) {
		Debug.println("LEDDisplayItem.LEDDisplayItem()");
		this.item = item;
		this.transition = transition;
	}
	public String getItem() {
		Debug.println("LEDDisplayItem.getItem()");
		return this.item;
	}
	public LEDDisplayTransition getTransition() {
		Debug.println("LEDDisplayItem.getTransition()");
		return this.transition;
	}
}
