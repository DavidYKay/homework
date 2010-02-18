package edu.mccc.cos210.dial;
import java.util.EventListener;
interface MVCModelListener extends EventListener {
	public void stateChanged(MVCModelEvent e);
}
