package edu.mccc.cos210.car;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class ShifterModel {
	private Car car;
	private int maxGear = 2;
	private int gear = 1;
	public ShifterModel(int maxGear, Car car) {
		Debug.println("ShifterModel:ShifterModel()");
		setMaxGear(maxGear);
		this.car = car;
	}
	public Car getCar() {
		return this.car;
	}
	public int getGear() {
		Debug.println("ShifterModel:getGear()");
		return this.gear;
	}
	public void setGear(int n) {
		Debug.println("ShifterModel:setGear()");
		this.gear = n > maxGear ? maxGear : n < 1 ? 1 : n;
	}
	public int getMaxGear() {
		Debug.println("ShifterModel:getMaxGear()");
		return this.maxGear;
	}
	private void setMaxGear(int n) {
		Debug.println("ShifterModel:setMaxGear()");
		this.maxGear = n < 2 ? 2 : n;
	}
	public void upShift() {
		Debug.println("ShifterModel:upShift()");
		setGear(getGear() + 1);
	}
	public void downShift() {
		Debug.println("ShifterModel:downShift()");
		setGear(getGear() - 1);
	}
}
