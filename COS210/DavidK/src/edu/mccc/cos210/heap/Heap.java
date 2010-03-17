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
        //Entry<E> entry = remove();
        TreeNode<Entry<E>> root = root();
        Entry<E> entry = root.element();
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
        Debug.println(
            String.format(
                "Node: %s Parent: %s",
                node.toString(),
                parent.toString()
            )
        );
        Entry<E> parentElement = parent.element();
        Entry<E> nodeElement = node.element();

        //is entry lower than parent?
        if (node.element().key() < parent.element().key()) {
            Debug.println("Swapping!");
            //if so, swap 
            replace(node, parentElement);
            replace(parent, nodeElement);
            //then recurse
            //recurseUp(node);
            //FIXME Test
            recurseUp(parent);
        } else {
            Debug.println("Not Swapping!");
            Debug.println(
                String.format(
                    "Child: %d, Parent: %d",
                    node.element().key(),
                    parent.element().key()
                )
            );
        }
    }
	private void bubbleDown() {
		Debug.println("Heap.bubbleDown()");
        //Pluck the last entry and set it as the root
        Entry<E> lastEntry = null;
        try {
            lastEntry = remove();
        } catch (BinaryTreeException ex) {
            System.err.println(ex);
            return;
        }
        System.out.println(this.toString());
        replace(root(), lastEntry);
        recurseDown(root());
        //start with root
        //is root lower than left?
        //if not, swap with
        //is root lower than right?
        //if not, swap with
        //else, done
	}
    private void recurseDown(TreeNode<Entry<E>> node) {
        Iterable<TreeNode<Entry<E>>> children = children(node);
        Entry<E> nodeElement = node.element();

        for (TreeNode<Entry<E>> child : children) {
            if (child == null) {
                continue;
            }
            Entry<E> childElement = null;
            Debug.println(child);
            childElement = child.element();
            //is entry lower than parent?
            if (nodeElement.key() > childElement.key()) {
                Debug.println("Swapping!");
                //if so, swap 
                replace(node, childElement);
                replace(child, nodeElement);                
                //then recurse
                recurseDown(node);
            } else {
                Debug.println("Not Swapping!");
                Debug.println(
                    String.format(
                        "Child: %d, Parent: %d",
                        node.element().key(),
                        child.element().key()
                    )
                );
            }
        }
    }
    public String toString() {
        Debug.println("Heap.toString()");
        return super.toString();
    }
}
