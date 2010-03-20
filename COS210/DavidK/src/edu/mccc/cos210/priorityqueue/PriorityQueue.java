package edu.mccc.cos210.priorityqueue;
import edu.mccc.cos210.heap.*;
import edu.mccc.cos210.binarytree.BinaryTreeException;
import com.cbthinkx.util.Debug;
public class PriorityQueue<E> {
	private Heap<E> heap;
	public PriorityQueue() {
		Debug.println("PriorityQueue.PriorityQueue()");
        this.heap = new Heap<E>();
	}
    public int size() {
		Debug.println("PriorityQueue.size()");
		return heap.size();
	}
    public boolean isEmpty() {
		Debug.println("PriorityQueue.isEmpty()");
		return heap.isEmpty();
	}
	public Entry<E> insert(Integer key, E element) {
		Debug.println("PriorityQueue.insert()");
		return heap.insert(key, element);
	}
	public E removeMin() {
		Debug.println("PriorityQueue.removeMin()");
        try {
            return heap.removeMin();
        } catch (BinaryTreeException ex) {
            System.err.println(ex);
            return null;
        }
	}
	public String toString() {
		Debug.println("PriorityQueue.toString()");
		return this.heap.toString();
	}
}
