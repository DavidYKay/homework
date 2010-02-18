package edu.mccc.cos210.shifter;
import java.awt.EventQueue;
import javax.swing.event.EventListenerList;
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
	private void setGear(int n) {
		Debug.println("ShifterModel:setGear()");
		this.gear = n > maxGear ? maxGear : n < 1 ? 1 : n;
		fireShifterModelStateChanged();
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
	private EventListenerList listenerList = new EventListenerList();
	public void addShifterModelListener(ShifterModelListener l) {
		Debug.println("ShifterModel:addShifterModelListener()");
		listenerList.add(ShifterModelListener.class, l);
	}
	public void removeShifterModelListener(ShifterModelListener l) {
		Debug.println("ShifterModel:removeShifterModelListener()");
		listenerList.remove(ShifterModelListener.class, l);
	}
	protected void fireShifterModelStateChanged() {
		Debug.println("ShifterModel:fireShifterModelStateChanged()");
		if (!EventQueue.isDispatchThread()) {
			try {
				EventQueue.invokeAndWait(
					new Runnable() {
						public void run() {
							Debug.println("Runnable:run()");
							notifyListeners();
						}
					}
				);
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		} else {
			notifyListeners();
		}
	}
	private void notifyListeners() {
		Debug.println("ShifterModel:notifyListeners()");
		ShifterModelEvent e = new ShifterModelEvent(this, this.gear);
		Object[] listeners = listenerList.getListenerList();
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == ShifterModelListener.class) {
				((ShifterModelListener) listeners[i + 1]).shift(e);
			}
		}
	}
}
