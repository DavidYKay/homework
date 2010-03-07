package edu.mccc.cos210.leddisplay;
import java.util.*;
import com.cbthinkx.util.Debug;
public class LEDDisplayQueue extends LinkedList<LEDDisplayItem> {
	public LEDDisplayQueue() {
		Debug.println("LEDDisplayQueue.LEDDisplayQueue()");
	}
	public void enqueue(LEDDisplayItem i) {
		Debug.println("LEDDisplayQueue.enqueue()");
		offer(i);
	}
	public LEDDisplayItem dequeue() {
		Debug.println("LEDDisplayQueue.dequeue()");
		return poll();
	}
}
