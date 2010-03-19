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
        
        //TreeNode<E> node = new TreeNode<E>(element);
        ArrayListTreeNode<E> node = new ArrayListTreeNode<E>( 
            new TreeNode<E>(element),
            arrayList.size() - 1
        );
        if (arrayList.add(node)) {
            return node;
        } else {
            return null;
        }
	}
	public E remove() throws BinaryTreeException {
		Debug.println("CompleteBinaryTree.remove()");
		// remove the last TreeNode stored in this
		// CompleteBinaryTree and return its element
		// throw exception if tree is empty
        if (isEmpty()) {
            throw new BinaryTreeException();
        }
        TreeNode<E> node = arrayList.remove(lastIndex());
		return node.element();
	}
    public String toString() {
        Debug.println("CompleteBinaryTree.toString()");
        return super.toString();
    }
}
