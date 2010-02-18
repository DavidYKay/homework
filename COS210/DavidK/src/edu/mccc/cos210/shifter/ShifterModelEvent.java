package edu.mccc.cos210.shifter;
import java.util.EventObject;
import com.cbthinkx.util.Debug;
public class ShifterModelEvent extends EventObject {
	private int gear;
	public ShifterModelEvent(ShifterModel model, int gear) {
		super(model);
		Debug.println("ShifterModelEvent:ShifterModelEvent()");
		this.gear = gear;
	}
	public int getGear() {
		Debug.println("ShifterModelEvent:getGear()");
		return this.gear;
	}
}
