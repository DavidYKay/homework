package edu.mccc.cos210.binarytree;
import com.cbthinkx.util.Debug;
import java.util.*;
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
        //btt.testConstruction();
        //btt.testRetrieval();
        btt.testParents();
        System.out.println("PreOrder");
		btt.displayTreePreOrder(btt.binaryTree);
        System.out.println("InOrder");
		btt.displayTreeInOrder(btt.binaryTree);
        System.out.println("PostOrder");
		btt.displayTreePostOrder(btt.binaryTree);
        System.out.println("toString:");
        System.out.println(btt.getBinaryTree());
	}
    private BinaryTree<String> getBinaryTree() {
        return binaryTree;
    }
	private void displayTreePreOrder(BinaryTree<String> bts) {
		Debug.println("BinaryTreeTest.displayTreePreOrder()");
        preOrder(bts.root(), bts);
        System.out.println();
	}
    private void preOrder(TreeNode<String> node, BinaryTree<String> bts) {
		Debug.println("BinaryTreeTest.preOrder()");
        System.out.print(node.element());
        if (bts.left(node) != null) {
            preOrder(bts.left(node), bts);
        } 
        if (bts.right(node) != null) {
            preOrder(bts.right(node), bts);
        } 
    }
	private void displayTreeInOrder(BinaryTree<String> bts) {
		Debug.println("BinaryTreeTest.displayTreeInOrder()");
        inOrder(bts.root(), bts);
        System.out.println();
	}
    private void inOrder(TreeNode<String> node, BinaryTree<String> bts) {
		Debug.println("BinaryTreeTest.inOrder()");
        if (bts.left(node) != null) {
            inOrder(bts.left(node), bts);
        } 
        System.out.print(node.element());
        if (bts.right(node) != null) {
            inOrder(bts.right(node), bts);
        } 
    }
	private void displayTreePostOrder(BinaryTree<String> bts) {
		Debug.println("BinaryTreeTest.displayTreePostOrder()");
        postOrder(bts.root(), bts);
        System.out.println();
	}
    private void postOrder(TreeNode<String> node, BinaryTree<String> bts) {
		Debug.println("BinaryTreeTest.postOrder()");
        if (bts.left(node) != null) {
            postOrder(bts.left(node), bts);
        } 
        if (bts.right(node) != null) {
            postOrder(bts.right(node), bts);
        } 
        System.out.print(node.element());
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
        Debug.println("BEGIN CONSTRUCTION TEST");

        if (binaryTree.size() == 13) {
            Debug.println("Size: correctly!");
        } else {
            Debug.println("Size: INCORRECTLY!");
            Debug.println("Size: " + binaryTree.size());
            System.exit(1);
        }

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

        //ArrayList<TreeNode<String>> arrayList = binaryTree.getArrayList();
        //Debug.println("ArrayList size " + arrayList.size());

        HashMap<String, Integer> letterMap = new HashMap<String, Integer>();
        letterMap.put("A", 0);
        letterMap.put("B", 1);
        letterMap.put("C", 2);
        letterMap.put("D", 3);
        letterMap.put("E", 4);
        letterMap.put("F", 5);
        letterMap.put("G", 6);
        letterMap.put("H", 7);
        letterMap.put("I", 8);
        letterMap.put("J", 9);
        letterMap.put("K", 10);
        letterMap.put("L", 22);
        letterMap.put("M", 13);

        testLetters(letterMap);

        Debug.println("END CONSTRUCTION TEST");
    }

    private void testParents() throws BinaryTreeException {
        boolean success =testParents(
            binaryTree.root(),
            null
        );
       if (success) {
           Debug.println("testParents - SUCCESS");
       } else {
           throw new BinaryTreeException();
       }
    }
    private boolean testParents(TreeNode<String> node, TreeNode<String>parent) {
        if (node == null||
            parent == null
        ) {
            return true;
        }
        if (!parent.equals(binaryTree.parent(node))) {
            return false;
        }
        TreeNode<String> left  = binaryTree.left(node);
        TreeNode<String> right = binaryTree.right(node);
        return (testParents(left, node) && testParents(right, node));
    }

    // Verifies that the letters are at the anticipated locations
    private void testLetters(HashMap<String, Integer> map) {
        //Iterator it = map.entrySet().iterator();
        //while (it.hasNext()) {
        //    Map.Entry pairs = (Map.Entry)it.next();

        //    TreeNode<String> node = binaryTree.getLegalNode((Integer) pairs.getValue());
        //    if (node != null) {
        //        String element = node.element();
        //        if (element != null &&
        //                element.equals(pairs.getKey())
        //           ) {
        //            Debug.println(
        //                String.format(
        //                    "%s was found at the correct position, %d",
        //                    pairs.getKey(),
        //                    pairs.getValue() 
        //                )
        //            );
        //        } else {
        //            Debug.println(
        //                String.format(
        //                    "%s DID NOT MATCH value at the POSITION, %d",
        //                    pairs.getKey(),
        //                    pairs.getValue() 
        //                )
        //            );
        //        }
        //    } else {
        //        Debug.println(
        //            String.format(
        //                "%s was NOT FOUND at the POSITION, %d",
        //                pairs.getKey(),
        //                pairs.getValue() 
        //            )
        //        );
        //    }
        //}
    }

    /*
    private void testRetrieval() {
        Debug.println("BEGIN RETRIEVAL TEST");

        Debug.println("testRetrieval: Printing iterator");
        Iterator<String> iterator = binaryTree.iterator();
        while (iterator.hasNext()) {
            Debug.println(iterator.next());
        }
        Iterable<TreeNode<String>> nodes = binaryTree.nodes();

        Debug.println("END RETRIEVAL TEST");
    }
    */
}
