package edu.mccc.cos210.shifter;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class ShifterCoordinator {
	private ShifterModel model;
	private ShifterView view;
	private ShifterController controller;
	public ShifterCoordinator(Car car, int maxGear) {
		Debug.println("ShifterCoordinator:ShifterCoordinator()");
		this.model = new ShifterModel(maxGear, car);
		this.view = new ShifterView(this.model);
		this.model.addShifterModelListener(this.view);
		this.controller = new ShifterController(this.model);
	}
	public ShifterModel getModel() {
		Debug.println("ShifterCoordinator:getModel()");
		return this.model;
	}
	public ShifterView getView() {
		Debug.println("ShifterCoordinator:getView()");
		return this.view;
	}
	public ShifterController getController() {
		Debug.println("ShifterCoordinator:getController()");
		return this.controller;
	}
}
