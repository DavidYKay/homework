package edu.mccc.cos210.heap;
import edu.mccc.cos210.binarytree.*;
import com.cbthinkx.util.Debug;
public class Heap<E> extends CompleteBinaryTree<Entry<E>> {
	public Heap() {
		super();
		Debug.println("Heap.Heap()");
	}
	public Entry<E> insert(Integer key, E element) {
		Debug.println("Heap.insert()");
		return null;
	}
	public E removeMin() throws BinaryTreeException {
		Debug.println("Heap.removeMin()");
		return null;
	}
	private void bubbleUp() {
		Debug.println("Heap.bubbleUp()");
	}
	private void bubbleDown() {
		Debug.println("Heap.bubbleDown()");
	}
}
