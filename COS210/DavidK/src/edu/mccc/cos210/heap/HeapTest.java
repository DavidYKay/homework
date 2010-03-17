package edu.mccc.cos210.heap;
import edu.mccc.cos210.binarytree.*;
import com.cbthinkx.util.Debug;
import java.util.*;
public class HeapTest {
	private Heap<String> binaryTree;
	public HeapTest() throws BinaryTreeException {
		Debug.println("HeapTest.HeapTest()");
		this.binaryTree = new Heap<String>();
		buildTree(this.binaryTree);
	}
	public static void main(String[] sa) throws BinaryTreeException {
		Debug.println("HeapTest.main()");
		HeapTest btt = new HeapTest();
	}

	private void buildTree(Heap<String> heap) throws BinaryTreeException {
		Debug.println("heapTest.buildTree()");
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put( 1, "A" );
        map.put( 2, "G");
        map.put( 3, "I");
        map.put( 5, "B");
        map.put( 6, "M");
        map.put( 7, "D");
        map.put( 10, "E");
        map.put( 11, "F");
        map.put( 12, "K");
        map.put( 13, "H");
        map.put( 14, "J");
        map.put( 15, "L");
        map.put( 16, "C");
        //add
        //Set<Integer> keySet = map.keySet():
        for (Integer key : map.keySet()) {
            String letter = map.get(key);
            Entry<String> entry = heap.insert(key, letter);
            if (entry.element() != letter) {
                Debug.println("Expected: " + letter);
                Debug.println("Received: " + entry.element());
                throw new BinaryTreeException();
            }
            if (entry.key() != key) {
                Debug.println("Expected: " + key);
                Debug.println("Received: " + entry.key());
                throw new BinaryTreeException();
            }
        }
        Debug.println("heapTest Finished construction!");
        //remove
        TreeSet<Integer> sortedSet = new TreeSet<Integer>(map.keySet());
        //for (int i = letters.length - 1; i >= 0; i--) {
        for (Integer key : sortedSet) {
            String letter = map.get(key);
            String element = heap.removeMin();
            if (!letter.equals(element)) {
                Debug.println("Expected: " + letter);
                Debug.println("Received: " + element);
                throw new BinaryTreeException();
            }
        }
	}
}
