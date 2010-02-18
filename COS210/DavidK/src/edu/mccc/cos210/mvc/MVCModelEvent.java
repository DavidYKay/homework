package edu.mccc.cos210.mvc;
import java.util.EventObject;
import com.cbthinkx.util.Debug;
public class MVCModelEvent extends EventObject {
	public MVCModelEvent(MVCModel model) {
		super(model);
		Debug.println("MVCModelEvent()");
	}
}
