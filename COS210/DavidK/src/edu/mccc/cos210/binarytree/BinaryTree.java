package edu.mccc.cos210.binarytree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import com.cbthinkx.util.Debug;
public class BinaryTree<E> {
    private ArrayList<TreeNode<E>> arrayList;
	public BinaryTree() {
		// construct a BinaryTree implemented using a ArrayList<TreeNode<E>>
		Debug.println("BinaryTree.BinaryTree()");
        arrayList = new ArrayList<TreeNode<E>>();
	}
	public TreeNode<E> root() {
		// return the root TreeNode
		Debug.println("BinaryTree.root()");
        if (size() >= 1) {
            return arrayList.get(0);
        } else {
            return null;
        }
	}
	public TreeNode<E> parent(TreeNode<E> treeNode) {
		// return the parent of treeNode
		Debug.println("BinaryTree.parent()");
		return null;
	}
	public Iterable<TreeNode<E>> children(TreeNode<E> treeNode) {
		// return the children of treeNode as an Iterable
		Debug.println("BinaryTree.children()");
		return null;
	}
	public boolean isInternal(TreeNode<E> treeNode) {
		// is internal?
		Debug.println("BinaryTree.isInternal()");
        //has left or has right
        if (
            (left(treeNode) != null) ||
            (right(treeNode) != null)
        ) {
            return true;
        } else {
            return false;
        }
	}
	public boolean isExternal(TreeNode<E> treeNode) {
		// is external?
		Debug.println("BinaryTree.isExternal()");
		return !isInternal(treeNode);
	}
	public boolean isRoot(TreeNode<E> treeNode) {
		// is root?
		Debug.println("BinaryTree.isRoot()");
        //FIXME Pointer equality or object equality?
		return root().equals(treeNode);
	}
	public int size() {
		// current size, not capacity
		Debug.println("BinaryTree.size()");
        //TODO Remove 'placeholder' nodes
		return arrayList.size();
	}
	public boolean isEmpty() {
		// it the tree empty?
		Debug.println("BinaryTree.isEmpty()");
		return arrayList.isEmpty();
	}
	public Iterator<E> iterator() {
		// return an iterator
		Debug.println("BinaryTree.iterator()");
        LinkedList<E> tempList = new LinkedList<E>();
        for (TreeNode<E> node : arrayList) {
            if (!isPlaceholder(node)) {
                tempList.add(node.element());
            }
        }
        return tempList.iterator();
	}
	public Iterable<TreeNode<E>> nodes() {
		// return all the nodes in the tree as an Iterable
		Debug.println("BinaryTree.nodes()");
        //TODO Remove placeholders?
		return arrayList;
	}
	public E replace(TreeNode<E> treeNode, E element) {
		// replace the element stored in treeNode and return old element
		Debug.println("BinaryTree.TreeNode()");
		return null;
	}
	public TreeNode<E> left(TreeNode<E> treeNode) {
		// return the left child of treeNode
		Debug.println("BinaryTree.left()");
        if (treeNode == null) {
            return null;
        } else {
            int parentIndex = arrayList.indexOf(treeNode);
            int childIndex = leftChildIndex(parentIndex);
            if (childIndex <= lastIndex()) {
                return arrayList.get(
                    childIndex
                );
            } else {
                return null;
            }
        }
	}
	public TreeNode<E> right(TreeNode<E> treeNode) {
		// return the right child of treeNode
		Debug.println("BinaryTree.right()");
        if (treeNode == null) {
            return null;
        } else {
            int parentIndex = arrayList.indexOf(treeNode);
            int childIndex = rightChildIndex(parentIndex);
            if (childIndex <= lastIndex()) {
                return arrayList.get(
                    childIndex
                );
            } else {
                return null;
            }
        }
	}
	public boolean hasLeft(TreeNode<E> treeNode) {
		// does treeNode have a left child?
		Debug.println("BinaryTree.hasLeft()");
		return false;
	}
	public boolean hasRight(TreeNode<E> treeNode) {
		// does treeNode have a right child?
		Debug.println("BinaryTree.hasRight()");
		return false;
	}
	public TreeNode<E> addRoot(E element) throws BinaryTreeException {
		// create and return a new TreeNode storing element and
		// make it the root of this BinaryTree
		// throw exception if root exists
		Debug.println("BinaryTree.addRoot()");
        if (root() != null) {
            throw new BinaryTreeException();
        } else {
            if (size() == 0) {
                if (arrayList.add(new TreeNode<E>(element))) {
                    return root();
                } else {
                    throw new BinaryTreeException();
                }
            } else {
                //Consider replacing with replace()
                return arrayList.set(0, new TreeNode<E>(element));
            }
        }
	}
	public TreeNode<E> insertLeft(TreeNode<E> treeNode, E element) throws BinaryTreeException {
		// create and return a new TreeNode storing element and
		// add it as the left child of treeNode
		// throw exception if left child exists
		Debug.println("BinaryTree.insertLeft()");
        if (left(treeNode) != null && 
            !isPlaceholder(left(treeNode))
        ) {
            throw new BinaryTreeException();
        } else {
            int parentIndex = arrayList.indexOf(treeNode);
            if (parentIndex == -1) {
                //Node is not in our tree
                throw new BinaryTreeException();
            } else {
                int childIndex = leftChildIndex(parentIndex);
                //insertPlaceholders to ensure that childIndex fits
                insertPlaceholders(childIndex - lastIndex());
                TreeNode<E> node = new TreeNode<E>(element);
                arrayList.add(childIndex, node);
                return node;
            }
        }
	}
	public TreeNode<E> insertRight(TreeNode<E> treeNode, E element) throws BinaryTreeException {
		// create and return a new TreeNode storing element and
		// add it as the right child of treeNode
		// throw exception if right child exists
		Debug.println("BinaryTree.insertRight()");
        if (right(treeNode) != null &&
            !isPlaceholder(left(treeNode))
        ) {
            throw new BinaryTreeException();
        } else {
            int parentIndex = arrayList.indexOf(treeNode);
            if (parentIndex == -1) {
                //Node is not in our tree
                throw new BinaryTreeException();
            } else {
                int childIndex = rightChildIndex(parentIndex);
                //insertPlaceholders to ensure that childIndex fits
                insertPlaceholders(childIndex - lastIndex());
                TreeNode<E> node = new TreeNode<E>(element);
                arrayList.add(childIndex, node);
                return node;
            }
        }
	}

    private int lastIndex() {
        return size() - 1;
    }
    private int leftChildIndex(int parentIndex) {
            //left child:
            //2n + 1
        return 2 * parentIndex + 1;
    }
    private int rightChildIndex(int parentIndex) {
        //right child:
        //2n + 2
        return 2 * parentIndex + 2;
    }
    /**
     * Get the index of the parent node of this node
     */
    private int parentIndex(int childIndex) {
        //return Math.floor((childIndex - 1) / 2);
        return (childIndex - 1) / 2;
    }
    /**
     * Adds placeholder nodes so that the arraylist doesn't complain about empty indicies
     */
    private void insertPlaceholders(int n) {
        for (int i = 1; i <= n; i++) {
            //Is null a valid element?
            arrayList.add(new TreeNode<E>(null));
        }
    }
    /**
     * Currently, we're defining placeholders as nodes with null elements
     */
    private boolean isPlaceholder(TreeNode<E> treeNode) {
        if (treeNode.element() == null) {
            return true;
        } else {
            return false;
        }
    }
}
