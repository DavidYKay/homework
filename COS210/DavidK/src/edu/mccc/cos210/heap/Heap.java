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
        //start with last added entry
        int index = lastIndex();
        TreeNode<Entry<E>> node = arrayList.get(index);
        recurseUp(node);
    }
    private void recurseUp(TreeNode<Entry<E>> node) {
        TreeNode<Entry<E>> parent = parent(node);
        //is entry lower than parent?
        if (node.element().key() < parent.element().key()) {
            Debug.println("Swapping!");
            //if so, swap 
            replace(node, parent.element());
            replace(parent, node.element());
            //then recurse
            recurseUp(node);
        } else {
            Debug.println("Not Swapping!");
        }
    }
	private void bubbleDown() {
		Debug.println("Heap.bubbleDown()");
        //start with root
        //is root lower than left?
        //if not, swap with
        //is root lower than right?
        //if not, swap with
        //else, done
	}
}
