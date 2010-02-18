package edu.mccc.cos210.shifter;
import java.util.EventListener;
interface ShifterModelListener extends EventListener {
	public void shift(ShifterModelEvent e);
}
