package edu.mccc.cos210.dial;
import java.awt.EventQueue;
import javax.swing.event.EventListenerList;
import com.cbthinkx.util.Debug;
public class MVCModel {
	private static final int MAX = 100;
	private int value = 0;
	public int getValue() {
		Debug.println("MVCModel.getValue()");
		return this.value;
	}
	public void setValue(int n) {
		Debug.println("MVCModel.setValue()");
		this.value = n % MAX;
		fireMVCModelStateChanged();
	}
	public int getMinimum() {
		Debug.println("MVCModel.getMinimum()");
		return 0;
	}
	public int getMaximum() {
		Debug.println("MVCModel.getMinimum()");
		return MAX - 1;
	}
	private EventListenerList listenerList = new EventListenerList();
	public void addMVCModelListener(MVCModelListener l) {
		Debug.println("MVCModel.addMVCModelListener()");
		listenerList.add(MVCModelListener.class, l);
	}
	public void removeMVCModelListener(MVCModelListener l) {
		Debug.println("MVCModel.removeMVCModelListener()");
		listenerList.remove(MVCModelListener.class, l);
	}
	protected void fireMVCModelStateChanged() {
		Debug.println("MVCModel.fireMVCModelStateChanged()");
		if (!EventQueue.isDispatchThread()) {
			try {
				EventQueue.invokeAndWait(
					new Runnable() {
						public void run() {
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
		Debug.println("MVCModel.notifyListeners()");
		MVCModelEvent e = new MVCModelEvent(this);
		Object[] listeners = listenerList.getListenerList();
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == MVCModelListener.class) {
				((MVCModelListener) listeners[i + 1]).stateChanged(e);
			}
		}
	}
}
