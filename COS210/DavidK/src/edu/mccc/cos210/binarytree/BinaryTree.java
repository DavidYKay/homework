package edu.mccc.cos210.binarytree;
import java.util.ArrayList;
import java.util.Iterator;
import com.cbthinkx.util.Debug;
public class BinaryTree<E> {
	public BinaryTree() {
		// construct a BinaryTree implemented using a ArrayList<TreeNode<E>>
		Debug.println("BinaryTree.BinaryTree()");
	}
	public TreeNode<E> root() {
		// return the root TreeNode
		Debug.println("BinaryTree.root()");
		return null;
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
		return false;
	}
	public boolean isExternal(TreeNode<E> treeNode) {
		// is external?
		Debug.println("BinaryTree.isExternal()");
		return false;
	}
	public boolean isRoot(TreeNode<E> treeNode) {
		// is root?
		Debug.println("BinaryTree.isRoot()");
		return false;
	}
	public int size() {
		// current size, not capacity
		Debug.println("BinaryTree.size()");
		return 0;
	}
	public boolean isEmpty() {
		// it the tree empty?
		Debug.println("BinaryTree.isEmpty()");
		return false;
	}
	public Iterator<E> iterator() {
		// return an iterator
		Debug.println("BinaryTree.iterator()");
		return null;
	}
	public Iterable<TreeNode<E>> nodes() {
		// return all the nodes in the tree as an Iterable
		Debug.println("BinaryTree.nodes()");
		return null;
	}
	public E replace(TreeNode<E> treeNode, E element) {
		// replace the element stored in treeNode and return old element
		Debug.println("BinaryTree.TreeNode()");
		return null;
	}
	public TreeNode<E> left(TreeNode<E> treeNode) {
		// return the left child of treeNode
		Debug.println("BinaryTree.left()");
		return null;
	}
	public TreeNode<E> right(TreeNode<E> treeNode) {
		// return the right child of treeNode
		Debug.println("BinaryTree.right()");
		return null;
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
		return null;
	}
	public TreeNode<E> insertLeft(TreeNode<E> treeNode, E element) throws BinaryTreeException {
		// create and return a new TreeNode storing element and
		// add it as the left child of treeNode
		// throw exception if root exists
		Debug.println("BinaryTree.insertLeft()");
		return null;
	}
	public TreeNode<E> insertRight(TreeNode<E> treeNode, E element) throws BinaryTreeException {
		// create and return a new TreeNode storing element and
		// add it as the right child of treeNode
		// throw exception if root exists
		Debug.println("BinaryTree.insertRight()");
		return null;
	}
}
