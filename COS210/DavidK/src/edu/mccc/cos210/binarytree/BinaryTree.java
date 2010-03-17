package edu.mccc.cos210.binarytree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import com.cbthinkx.util.Debug;
public class BinaryTree<E> {
    protected ArrayList<TreeNode<E>> arrayList;
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
        int childIndex = arrayList.indexOf(treeNode);
        if (childIndex == -1) {
            return null;
        } else {
            int parentIndex = parentIndex(childIndex);
            return getLegalNode(parentIndex);
        }
	}
	public Iterable<TreeNode<E>> children(TreeNode<E> treeNode) {
		// return the children of treeNode as an Iterable
		Debug.println("BinaryTree.children()");
        LinkedList<TreeNode<E>> tempList = new LinkedList<TreeNode<E>>();
        tempList.add(
            left(treeNode)
        );
        tempList.add(
            right(treeNode)
        );
		return tempList;
	}
	public boolean isInternal(TreeNode<E> treeNode) {
		// is internal?
		Debug.println("BinaryTree.isInternal()");
        //has left or has right
        if (
            (
                isLegalNode(left(treeNode)) ||
                isLegalNode(right(treeNode)) 
            ) 
            //&& isLegalNode(parent(treeNode))
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
		//Debug.println("BinaryTree.size()");
        int count = 0;
        for (TreeNode<E> node : arrayList) {
            if (isLegalNode(node)) {
                count++;
            }
        }
		return count;
	}
	public boolean isEmpty() {
		// it the tree empty?
		Debug.println("BinaryTree.isEmpty()");
		return size() == 0;
	}
	public Iterator<E> iterator() {
		// return an iterator
		Debug.println("BinaryTree.iterator()");
        LinkedList<E> tempList = new LinkedList<E>();
        for (TreeNode<E> node : arrayList) {
            if (isLegalNode(node)) {
                tempList.add(node.element());
            }
        }
        return tempList.iterator();
	}
	public Iterable<TreeNode<E>> nodes() {
		// return all the nodes in the tree as an Iterable
		Debug.println("BinaryTree.nodes()");
        LinkedList<TreeNode<E>> tempList = new LinkedList<TreeNode<E>>();
        for (TreeNode<E> node : arrayList) {
            if (isLegalNode(node)) {
                tempList.add(node);
            }
        }
		return tempList;
	}
	public E replace(TreeNode<E> treeNode, E element) {
		// replace the element stored in treeNode and return old element
		Debug.println("BinaryTree.TreeNode()");
        int index = arrayList.indexOf(treeNode);
        try {
            if (index == -1) {
                Debug.println("Replace exception!");
                throw new BinaryTreeException();
            } else {
                Debug.println("Replace success!");
                E old = arrayList.get(index).element();
                arrayList.set(index, new TreeNode<E>(element));
                return old;
            }
        } catch (BinaryTreeException e) {
            //FIXME Handle this in a more robust way?
            Debug.println("Replace failed!");
            return null;
        }
	}
	public TreeNode<E> left(TreeNode<E> treeNode) {
		// return the left child of treeNode
		Debug.println("BinaryTree.left()");
        if (treeNode == null) {
            return null;
        } else {
            int parentIndex = arrayList.indexOf(treeNode);
            if (parentIndex == -1) {
                return null;
            }
            int childIndex = leftChildIndex(parentIndex);
            return getLegalNode(childIndex);
        }
	}
	public TreeNode<E> right(TreeNode<E> treeNode) {
		// return the right child of treeNode
		Debug.println("BinaryTree.right()");
        if (treeNode == null) {
            return null;
        } else {
            int parentIndex = arrayList.indexOf(treeNode);
            if (parentIndex == -1) {
                return null;
            }
            int childIndex = rightChildIndex(parentIndex);
            return getLegalNode(childIndex);
        }
	}
	public boolean hasLeft(TreeNode<E> treeNode) {
		// does treeNode have a left child?
		Debug.println("BinaryTree.hasLeft()");
        if (isLegalNode(left(treeNode))) {
            return true;
        } else {
            return false;
        }
	}
	public boolean hasRight(TreeNode<E> treeNode) {
		// does treeNode have a right child?
		Debug.println("BinaryTree.hasRight()");
        if (isLegalNode(right(treeNode))) {
            return true;
        } else {
            return false;
        }
	}
	public TreeNode<E> addRoot(E element) throws BinaryTreeException {
		// create and return a new TreeNode storing element and
		// make it the root of this BinaryTree
		// throw exception if root exists
		Debug.println("BinaryTree.addRoot()");
        if (isLegalNode(root())) {
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
        if (hasLeft(treeNode)) {
            throw new BinaryTreeException();
        } else {
            int parentIndex = arrayList.indexOf(treeNode);
            if (parentIndex == -1) {
                //Node is not in our tree
                throw new BinaryTreeException();
            } else {
                int childIndex = leftChildIndex(parentIndex);
                //insertPlaceholders to ensure that childIndex fits
                insertPlaceholders(childIndex);
                TreeNode<E> node = new TreeNode<E>(element);
                arrayList.set(childIndex, node);
                return node;
            }
        }
	}
	public TreeNode<E> insertRight(TreeNode<E> treeNode, E element) throws BinaryTreeException {
		// create and return a new TreeNode storing element and
		// add it as the right child of treeNode
		// throw exception if right child exists
		Debug.println("BinaryTree.insertRight()");
        if (hasRight(treeNode)) {
            throw new BinaryTreeException();
        } else {
            int parentIndex = arrayList.indexOf(treeNode);
            if (parentIndex == -1) {
                //Node is not in our tree
                throw new BinaryTreeException();
            } else {
                int childIndex = rightChildIndex(parentIndex);
                //insertPlaceholders to ensure that childIndex fits
                insertPlaceholders(childIndex);
                TreeNode<E> node = new TreeNode<E>(element);
                arrayList.set(childIndex, node);
                return node;
            }
        }
	}
    protected int lastIndex() {
		Debug.println("BinaryTree.lastIndex()");
        return arrayList.size() - 1;
    }
    private int leftChildIndex(int parentIndex) {
		Debug.println("BinaryTree.leftChildIndex()");
        return 2 * parentIndex + 1;
    }
    private int rightChildIndex(int parentIndex) {
		Debug.println("BinaryTree.rightChildIndex()");
        return 2 * parentIndex + 2;
    }
    /**
     * Get the index of the parent node of this node
     */
    private int parentIndex(int childIndex) {
		Debug.println("BinaryTree.parentIndex()");
        return (childIndex - 1) / 2;
    }
    /**
     * Adds placeholder nodes so that the arraylist doesn't complain about empty indicies
     */
    private void insertPlaceholders(int index) {
        Debug.println("insertPlaceholders: " + index);
        int delta = index - lastIndex();
        for (int i = 1; i <= delta; i++) {
            //Is null a valid element?
            arrayList.add(new TreeNode<E>(null));
        }
    }
    /**
     * Currently, we're defining placeholders as nodes with null elements
     */
    private boolean isPlaceholder(TreeNode<E> treeNode) {
		Debug.println("BinaryTree.isPlaceholder()");
        if (treeNode.element() == null) {
            return true;
        } else {
            return false;
        }
    }
    private boolean isLegalNode(TreeNode<E> treeNode) {
		Debug.println("BinaryTree.isLegalNode()");
        if (treeNode != null &&
            !isPlaceholder(treeNode)
        ) {
            return true;
        } else {
            return false;
        }
    }
    private TreeNode<E> getLegalNode(int index) {
		Debug.println("BinaryTree.getLegalNode()");
        if (index <= lastIndex()) {
            TreeNode<E> node = arrayList.get(index);
            if (isLegalNode(node)) {
                return node;
            } 
        } 
        return null;
    }
    //public String toString() {
    //    Debug.println("BinaryTree.toString()");
    //    StringBuilder sb = new StringBuilder();
    //    int powerOfTwo = 1;
    //    for (int i = 0; i < arrayList.size(); i++) {
    //        if (i == powerOfTwo) {
    //            i *= 2;
    //            sb.append("\n");
    //        }
    //        TreeNode<E> node = arrayList.get(i);
    //        if (!isLegalNode(node)) {

    //        } else {
    //            sb.append(node);
    //        }
    //    }
    //    return sb.toString();
    //}
    public String toString() {
        Debug.println("BinaryTree.toString()");
        return "Hello";
    }
}
