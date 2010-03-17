package edu.mccc.cos210.binarytree;
import com.cbthinkx.util.Debug;
public class CompleteBinaryTree<E> extends BinaryTree<E> {
	public CompleteBinaryTree() {
		super();
		Debug.println("CompleteBinaryTree.CompleteBinaryTree()");
	}
	public TreeNode<E> add(E element) {
		Debug.println("CompleteBinaryTree.add()");
		// create and return a new TreeNode storing element as
		// the last node of this CompleteBinaryTree
        TreeNode<E> node = new TreeNode<E>(element);
        if (arrayList.add(node)) {
            return node;
        } else {
            return null;
        }
	}
	public E remove() throws CompleteBinaryTreeException {
		Debug.println("CompleteBinaryTree.remove()");
		// remove the last TreeNode stored in this
		// CompleteBinaryTree and return its element
		// throw exception if tree is empty
        if (isEmpty()) {
            throw new CompleteBinaryTreeException();
        }
        TreeNode<E> node = arrayList.remove(lastIndex());
		return node.element();
	}
}
