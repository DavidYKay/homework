package edu.mccc.cos210.binarytree;
import com.cbthinkx.util.Debug;
import java.util.*;
public class CompleteBinaryTreeTest {
	private CompleteBinaryTree<String> completeBinaryTree;
	public CompleteBinaryTreeTest() throws BinaryTreeException {
		Debug.println("CompleteBinaryTreeTest.CompleteBinaryTreeTest()");
		this.completeBinaryTree = new CompleteBinaryTree<String>();
		buildTree(this.completeBinaryTree);
	}
	public static void main(String[] sa) throws BinaryTreeException {
		Debug.println("CompleteBinaryTreeTest.main()");
		CompleteBinaryTreeTest cbtt = new CompleteBinaryTreeTest();
        //cbtt.testConstruction();
        //cbtt.testRetrieval();
	}

	private void buildTree(CompleteBinaryTree<String> bts) throws BinaryTreeException {
		Debug.println("CompleteBinaryTreeTest.buildTree()");
		TreeNode<String> root = bts.add("A");
		TreeNode<String> b = bts.add("B");
		TreeNode<String> c = bts.add("C");
		TreeNode<String> d = bts.add("D");
		TreeNode<String> e = bts.add("E");
		TreeNode<String> f = bts.add("F");
		TreeNode<String> g = bts.add("G");
		TreeNode<String> h = bts.add("H");
		TreeNode<String> i = bts.add("I");
		TreeNode<String> j = bts.add("J");
		TreeNode<String> k = bts.add("K");
		TreeNode<String> l = bts.add("L");
		TreeNode<String> m = bts.add("M");

        for (String letter : letters) {
            if (!letter.equals(completeBinaryTree.remove())) {
                throw new BinaryTreeException();
            }
        }
	}
    //add
    //remove
}
