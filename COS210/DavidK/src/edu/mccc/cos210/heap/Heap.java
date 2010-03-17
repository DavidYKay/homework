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
        Entry<E> entry = new Entry<E>(key, element);
        if (super.add(entry) != null) {
            bubbleUp();
            return entry;
        } else {
            return null;
        }
	}
	public E removeMin() throws BinaryTreeException {
		Debug.println("Heap.removeMin()");
        Entry<E> entry = remove();
        E element = entry.element();
        bubbleDown();
		return element;
	}
	private void bubbleUp() {
		Debug.println("Heap.bubbleUp()");
	}
	private void bubbleDown() {
		Debug.println("Heap.bubbleDown()");
	}
}
