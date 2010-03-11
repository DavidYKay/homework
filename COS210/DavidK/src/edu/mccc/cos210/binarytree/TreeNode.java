package edu.mccc.cos210.binarytree;
import com.cbthinkx.util.Debug;
public class TreeNode<E> {
	private E element;
	public TreeNode(E e) {
		//Debug.println("TreeNode.TreeNode()");
		this.element = e;
	}
	public E element() {
		//Debug.println("TreeNode.element()");
		return this.element;
	}
	public String toString() {
		//Debug.println("TreeNode.toString()");
		return element.toString();
	}
}
