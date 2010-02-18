package edu.mccc.cos210.mvc;
import java.util.EventListener;
interface MVCModelListener extends EventListener {
	public void stateChanged(MVCModelEvent e);
}
