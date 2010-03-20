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
		Debug.println("Heap.removeMin()");
        TreeNode<Entry<E>> root = root();
        if (root == null) {
            return null;
        } else {
            E element = root.element().element();
            bubbleDown();
            return element;
        }
	}
	private void bubbleUp() {
		Debug.println("Heap.bubbleUp()");
        //start with last added entry
        int index = lastIndex();
        TreeNode<Entry<E>> node = arrayList.get(index);
        Debug.println("Before bubbleUp:");
        Debug.println(this);
        recurseUp(node);
        Debug.println("After bubbleUp:");
        Debug.println(this);
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
        Debug.println("Before pluck:");
        Debug.println(this);
        //Pluck the last entry and set it as the root
        Entry<E> lastEntry = null;
        try {
            lastEntry = remove();
        } catch (BinaryTreeException ex) {
            System.err.println(ex);
            return;
        }
        if (root() == null) {
            return;
        }
        Debug.println("Root before: " + root());
        replace(root(), lastEntry);
        Debug.println("Root after: " + root());
        Debug.println("After pluck:");
        Debug.println(this);
        recurseDown(root());
        Debug.println("After bubbleDown:");
        Debug.println(this);
        //start with root
        //is root lower than left?
        //if not, swap with
        //is root lower than right?
        //if not, swap with
        //else, done
	}
    private void recurseDown(TreeNode<Entry<E>> node) {
        Debug.println("RecurseDown");
        //Debug.println(this);
        Entry<E> nodeElement = node.element();
        TreeNode<Entry<E>> left  = left(node);
        TreeNode<Entry<E>> right = right(node);
        if (left == null) {
            //Bottom row
            return;
        }
        Debug.println("Left: " + left);
        Debug.println("Right: " + right);
        Entry<E> leftElement = left.element();
        Entry<E> rightElement = null;
        if (right != null) {
            rightElement = right.element();
        }

        TreeNode<Entry<E>> child = null;
        if ( 
            rightElement != null &&
            leftElement.key() > rightElement.key()
        ) { 
            //right is greater
            child = right;
        } else {
            //equal or left is lesser
            child = left;
        }
        //Debug.println(child);
        Entry<E> childElement = child.element();
        //is entry lower than parent?
        if (nodeElement.key() > childElement.key()) {
            int childIndex = ((ArrayListTreeNode) child).getIndex();
            Debug.println("Swapping!");
            //if so, swap 
            replace(node, childElement);
            replace(child, nodeElement);                
            //then recurse
            if (childIndex < lastIndex()) {
                recurseDown(
                    arrayList.get(childIndex)
                );
            }
        } else {
            Debug.println("Not Swapping!");
        }
        Debug.println(
            String.format(
                "Child: %s, Parent: %s,",
                child.element(),
                node.element()
            )
        );
        //Debug.println(
        //    String.format(
        //        "Child: %s, Parent: %s,",
        //        child.hashCode(),
        //        node.hashCode()
        //    )
        //);
    }
    public String toString() {
        Debug.println("Heap.toString()");
        return super.toString();
    }
}
