package edu.mccc.cos210.binarytree;
import com.cbthinkx.util.Debug;
public class BinaryTreeTest {
	private BinaryTree<String> binaryTree;
	public BinaryTreeTest() throws BinaryTreeException {
		Debug.println("BinaryTreeTest.BinaryTreeTest()");
		this.binaryTree = new BinaryTree<String>();
		buildTree(this.binaryTree);
	}
	public static void main(String[] sa) throws BinaryTreeException {
		Debug.println("BinaryTreeTest.main()");
		BinaryTreeTest btt = new BinaryTreeTest();
        btt.testConstruction();
		btt.displayTreePreOrder(btt.binaryTree);
		btt.displayTreeInOrder(btt.binaryTree);
		btt.displayTreePostOrder(btt.binaryTree);
	}
	private void displayTreePreOrder(BinaryTree<String> bts) {
		Debug.println("BinaryTreeTest.displayTreePreOrder()");
	}
	private void displayTreeInOrder(BinaryTree<String> bts) {
		Debug.println("BinaryTreeTest.displayTreeInOrder()");
	}
	private void displayTreePostOrder(BinaryTree<String> bts) {
		Debug.println("BinaryTreeTest.displayTreePostOrder()");
	}
	private void buildTree(BinaryTree<String> bts) throws BinaryTreeException {
		Debug.println("BinaryTreeTest.buildTree()");
		TreeNode<String> root = bts.addRoot("A");
		TreeNode<String> b = bts.insertLeft(root, "B");
		TreeNode<String> c = bts.insertRight(root, "C");
		TreeNode<String> d = bts.insertLeft(b, "D");
		TreeNode<String> e = bts.insertRight(b, "E");
		TreeNode<String> f = bts.insertLeft(c, "F");
		TreeNode<String> g = bts.insertRight(c, "G");
		TreeNode<String> h = bts.insertLeft(d, "H");
		TreeNode<String> i = bts.insertRight(d, "I");
		TreeNode<String> j = bts.insertLeft(e, "J");
		TreeNode<String> k = bts.insertRight(e, "K");
		TreeNode<String> l = bts.insertRight(k, "L");
		TreeNode<String> m = bts.insertLeft(g, "M");
	}

    private void testConstruction() {
        Debug.println("BEGAN CONSTRUCTION TEST");
        if (binaryTree.root().toString().equals("A")) {
            Debug.println("Root: created/retrieved correctly!");
        } else {
            Debug.println("Root: created/retrieved INCORRECTLY!");
        }
        if (binaryTree.left(
                binaryTree.root()
            ).toString().equals("B")) {
            Debug.println("LEFT: created/retrieved correctly!");
        } else {
            Debug.println("LEFT: created/retrieved INCORRECTLY!");
        }
        if (binaryTree.right(
                binaryTree.root()
            ).toString().equals("C")) {
            Debug.println("RIGHT: created/retrieved correctly!");
        } else {
            Debug.println("RIGHT: created/retrieved INCORRECTLY!");
        }
        Debug.println("END CONSTRUCTION TEST");
    }
}
