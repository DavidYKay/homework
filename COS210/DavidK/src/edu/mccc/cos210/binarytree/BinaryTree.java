package edu.mccc.cos210.binarytree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import com.cbthinkx.util.Debug;
public class BinaryTree<E> {
	protected ArrayList<ArrayListTreeNode<E>> arrayList;
	protected int size = 0;
	public BinaryTree() {
		// construct a BinaryTree implemented using a ArrayList<TreeNode<E>>
		Debug.println("BinaryTree.BinaryTree()");
		this.arrayList = new ArrayList<ArrayListTreeNode<E>>();
	}
	public TreeNode<E> root() {
		// return the root TreeNode
		Debug.println("BinaryTree.root()");
		if (!isEmpty()) {
			return this.arrayList.get(0);
		} else {
            Debug.println("BinaryTree.root() null, size: " + size);
			return null;
		}
	}
	public TreeNode<E> parent(TreeNode<E> treeNode) {
		// return the parent of treeNode
		Debug.println("BinaryTree.parent()");
		int index = ((ArrayListTreeNode<E>) treeNode).getIndex();
		return this.arrayList.get((index - 1) / 2);
	}
	public Iterable<TreeNode<E>> children(TreeNode<E> treeNode) {
		// return the children of treeNode as an Iterable
		Debug.println("BinaryTree.children()");
		ArrayList<TreeNode<E>> kids = new ArrayList<TreeNode<E>>();
		int index = ((ArrayListTreeNode<E>) treeNode).getIndex();
        int leftIndex  = leftChildIndex(index);
        int rightIndex = rightChildIndex(index);
        
        TreeNode<E> left  = null;
        TreeNode<E> right = null;
        if (leftIndex <= lastIndex()) {
            left = validate(
                this.arrayList.get(leftIndex)
            );
        }
        if (rightIndex <= lastIndex()) {
            right = validate(
                this.arrayList.get(rightIndex)
            );
        }
		if (left != null) {
			kids.add(left);
		}
		if (right != null) {
			kids.add(right);
		}
		return kids;
	}
	public boolean isInternal(TreeNode<E> treeNode) {
		// is internal?
		Debug.println("BinaryTree.isInternal()");
		ArrayList<TreeNode<E>> kids = (ArrayList<TreeNode<E>>) children(treeNode);
		if (kids.isEmpty()) {
			return false;
		} else {
			return true;
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
		if (((ArrayListTreeNode<E>) treeNode).getIndex() == 0) {
			return true;
		} else {
			return false;
		}
	}
	public int size() {
		// current size, not capacity
		Debug.println("BinaryTree.size()");
		return this.size;
	}
	public boolean isEmpty() {
		// it the tree empty?
		Debug.println("BinaryTree.isEmpty()");
		return (size == 0);
	}
	public Iterator<E> iterator() {
		// return an iterator
		Debug.println("BinaryTree.iterator()");
        LinkedList<E> tempList = new LinkedList<E>();
        for (TreeNode<E> node : arrayList) {
            if (validate(node) != null) {
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
            if (validate(node) != null) {
                tempList.add(node);
            }
        }
		return tempList;
	}
	public E replace(TreeNode<E> treeNode, E element) {
		Debug.println("BinaryTree.replace()");
		int index = ((ArrayListTreeNode<E>) treeNode).getIndex();
		Debug.println("BinaryTree.replace() index: " + index);
		Debug.println("BinaryTree.replace() value: " + treeNode);
		this.arrayList.set(index, new ArrayListTreeNode<E>(new TreeNode<E>(element), index));
		return treeNode.element();
	}
	public TreeNode<E> left(TreeNode<E> treeNode) {
		// return the left child of treeNode
		Debug.println("BinaryTree.left()");
		int index = ((ArrayListTreeNode<E>) treeNode).getIndex();
		int leftIndex = 2 * (index + 1) - 1;
		if (leftIndex < this.arrayList.size()) {
			return validate(this.arrayList.get(leftIndex));
		} else {
			return null;
		}
	}
	public TreeNode<E> right(TreeNode<E> treeNode) {
		// return the right child of treeNode
		Debug.println("BinaryTree.right()");
		int index = ((ArrayListTreeNode<E>) treeNode).getIndex();
		int rightIndex = 2 * (index + 1);
		if (rightIndex < this.arrayList.size()) {
			return validate(this.arrayList.get(rightIndex));
		} else {
			return null;
		}
	}
	public boolean hasLeft(TreeNode<E> treeNode) {
		// does treeNode have a left child?
		Debug.println("BinaryTree.hasLeft()");
		TreeNode<E> kid = left(treeNode);
		if (kid == null) {
			return false;
		} else {
			return true;
		}
	}
	public boolean hasRight(TreeNode<E> treeNode) {
		// does treeNode have a right child?
		Debug.println("BinaryTree.hasRight()");
		TreeNode<E> kid = right(treeNode);
		if (kid == null) {
			return false;
		} else {
			return true;
		}
	}
	public TreeNode<E> addRoot(E element) throws BinaryTreeException {
		// create and return a new TreeNode storing element and
		// make it the root of this BinaryTree
		// throw exception if root exists
		Debug.println("BinaryTree.addRoot()");
		ArrayListTreeNode<E> root = new ArrayListTreeNode<E>(new TreeNode<E>(element), 0);
		if (!isEmpty()) {
			throw new BinaryTreeException();
		} else {
			this.arrayList.add(root);
			this.size++;
			return root;
		}
	}
	public TreeNode<E> insertLeft(TreeNode<E> treeNode, E element) throws BinaryTreeException {
		// create and return a new TreeNode storing element and
		// add it as the left child of treeNode
		// throw exception if left child exists
		Debug.println("BinaryTree.insertLeft()");
		int index = ((ArrayListTreeNode<E>) treeNode).getIndex();
		ArrayListTreeNode<E> left = new ArrayListTreeNode<E>(new TreeNode<E>(element), 2 * (index + 1) - 1);
		if (hasLeft(treeNode)) {
			throw new BinaryTreeException();
		} else {
			int leftIndex = 2 * (index + 1) - 1;
			if (leftIndex >= this.arrayList.size()) {
				for (int i = this.arrayList.size(); i <= leftIndex; i++) {
					this.arrayList.add(i, new ArrayListTreeNode<E>(new TreeNode<E>(element), -1));
				}
			}
			this.arrayList.set(leftIndex, left);
			this.size++;
			return left;
		}
	}
	public TreeNode<E> insertRight(TreeNode<E> treeNode, E element) throws BinaryTreeException {
		// create and return a new TreeNode storing element and
		// add it as the right child of treeNode
		// throw exception if right child exists
		Debug.println("BinaryTree.insertRight()");
		int index = ((ArrayListTreeNode<E>) treeNode).getIndex();
		ArrayListTreeNode<E> right = new ArrayListTreeNode<E>(new TreeNode<E>(element), 2 * (index + 1));
		if (hasRight(treeNode)) {
			throw new BinaryTreeException();
		} else {
			int rightIndex = 2 * (index + 1);
			if (rightIndex >= this.arrayList.size()) {
				for (int i = this.arrayList.size(); i <= rightIndex; i++) {
					this.arrayList.add(i, new ArrayListTreeNode<E>(new TreeNode<E>(element), -1));
				}
			}
			this.arrayList.set(rightIndex, right);
			this.size++;
			return right;
		}
	}

	private TreeNode<E> validate(TreeNode<E> treeNode) {
		Debug.println("BinaryTree.validate()");
		int index = ((ArrayListTreeNode<E>) treeNode).getIndex();
		if (index == -1) {
			return null;
		} else {
			return treeNode;
		}
	}

    protected int lastIndex() {
		Debug.println("BinaryTree.lastIndex()");
        int index = arrayList.size() - 1;
        if (index < 0) {
            return 0;
        } else {
            return index;
        }
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
    ///**
    // * Adds placeholder nodes so that the arraylist doesn't complain about empty indicies
    // */
    //private void insertPlaceholders(int index) {
    //    Debug.println("insertPlaceholders: " + index);
    //    int delta = index - lastIndex();
    //    for (int i = 1; i <= delta; i++) {
    //        //Is null a valid element?
    //        arrayList.add(new TreeNode<E>(null));
    //    }
    //}
    ///**
    // * Currently, we're defining placeholders as nodes with null elements
    // */
    //private boolean isPlaceholder(TreeNode<E> treeNode) {
	//	Debug.println("BinaryTree.isPlaceholder()");
    //    if (treeNode.element() == null) {
    //        return true;
    //    } else {
    //        return false;
    //    }
    //}
    //private boolean isLegalNode(TreeNode<E> treeNode) {
	//	Debug.println("BinaryTree.isLegalNode()");
    //    if (treeNode != null &&
    //        !isPlaceholder(treeNode)
    //    ) {
    //        return true;
    //    } else {
    //        return false;
    //    }
    //}
    //private TreeNode<E> getLegalNode(int index) {
	//	Debug.println("BinaryTree.getLegalNode()");
    //    if (index <= lastIndex()) {
    //        TreeNode<E> node = arrayList.get(index);
    //        if (isLegalNode(node)) {
    //            return node;
    //        } 
    //    } 
    //    return null;
    //}
    public String toString() {
        Debug.println("BinaryTree.toString()");
        StringBuilder sb = new StringBuilder();
        int powerOfTwo = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            TreeNode<E> node = arrayList.get(i);
            if (validate(node) == null) {
                sb.append("_");
            } else {
                sb.append(node);
            }
            if (i == powerOfTwo) {
                sb.append("\n");
                powerOfTwo = (powerOfTwo * 2) + 2;
            }
        }
        return sb.toString();
    }
	public class ArrayListTreeNode<E> extends TreeNode<E> {
		private int index;
		public ArrayListTreeNode(TreeNode<E> treeNode, int index) {
			super(treeNode.element());
			Debug.println("ArrayListTreeNode.ArrayListTreeNode()");
			this.index = index;
		}
		public int getIndex() {
			Debug.println("ArrayListTreeNode.getIndex()");
			return this.index;
		}
		public void setIndex(int n) {
			this.index = n;
		}
		public String toString() {
			//Debug.println("ArrayListTreeNode.toString()");
			return "[" + super.toString() + ":" + getIndex() + "]";
		}
	}
}
