package edu.mccc.cos210.binarytree;
import com.cbthinkx.util.Debug;
import java.util.*;
public class CompleteBinaryTreeTest {
	private CompleteBinaryTree<String> completeBinaryTree;
	public CompleteBinaryTreeTest() throws BinaryTreeException {
		Debug.println("CompleteBinaryTreeTest.CompleteBinaryTreeTest()");
		this.completeBinaryTree = new CompleteBinaryTree<String>();
		buildTree(this.completeBinaryTree);
        Debug.println("CompleteBinaryTreeTest SUCCESS!");
	}
	public static void main(String[] sa) throws BinaryTreeException {
		Debug.println("CompleteBinaryTreeTest.main()");
		CompleteBinaryTreeTest cbtt = new CompleteBinaryTreeTest();
        //cbtt.testConstruction();
        //cbtt.testRetrieval();
	}

	private void buildTree(CompleteBinaryTree<String> bts) throws BinaryTreeException {
		Debug.println("CompleteBinaryTreeTest.buildTree()");
        String letters[] = new String[] {
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "M",
        };
        //add
        for (String letter : letters) {
            TreeNode<String> node = bts.add(letter);
            if (node.element() != letter) {
                Debug.println("Expected: " + letter);
                Debug.println("Received: " + node.element());
                throw new BinaryTreeException();
            }
        }
        Debug.println("CompleteBinaryTreeTest Finished construction!");
        //remove
        for (int i = letters.length - 1; i >= 0; i--) {
            String letter = letters[i];
            String element = completeBinaryTree.remove();
            if (!letter.equals(element)) {
                Debug.println("Expected: " + letter);
                Debug.println("Received: " + element);
                throw new BinaryTreeException();
            }
        }
	}
}
