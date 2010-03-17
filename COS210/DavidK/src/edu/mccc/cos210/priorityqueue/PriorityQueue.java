package edu.mccc.cos210.priorityqueue;
import edu.mccc.cos210.heap.*;
import com.cbthinkx.util.Debug;
public class PriorityQueue<E> {
	private Heap<E> heap;
	public PriorityQueue() {
		Debug.println("PriorityQueue.PriorityQueue()");
	}
    public int size() {
		Debug.println("PriorityQueue.size()");
		return 0;
	}
    public boolean isEmpty() {
		Debug.println("PriorityQueue.isEmpty()");
		return false;
	}
	public Entry<E> insert(Integer key, E element) {
		Debug.println("PriorityQueue.insert()");
		return null;
	}
	public E removeMin() {
		Debug.println("PriorityQueue.removeMin()");
		return null;
	}
	public String toString() {
		Debug.println("PriorityQueue.toString()");
		return this.heap.toString();
	}
}
