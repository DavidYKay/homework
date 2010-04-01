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
        System.out.println("Heap:");
        System.out.println(binaryTree);
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

        //Integer[] keys = (Integer[]) map.keySet().toArray();
        //add
        //for (int i = keys.length - 1; i >= 0; i--) {
            //Integer key = keys[i];
        for (Integer key : map.keySet()) {
            String letter = map.get(key);
            Debug.println("Inserting letter: " + letter + " index: " + key);
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
        Debug.println(heap);
        //remove
        TreeSet<Integer> sortedSet = new TreeSet<Integer>(map.keySet());
        int successes = 0;
        ArrayList<String> expected = new ArrayList<String>();
        ArrayList<String> received = new ArrayList<String>();
        for (Integer key : sortedSet) {
            String letter = map.get(key);
            String element = heap.removeMin();
            expected.add(letter);
            received.add(element);
            if (!letter.equals(element)) {
                //Debug.println("Expected: " + letter);
                //Debug.println("Received: " + element);
                Debug.println("Expected: " + expected);
                Debug.println("Received: " + received);
                throw new BinaryTreeException();
            }
            successes++;
            Debug.println("Successes: " + successes);
        }
        Debug.println("heapTest Finished removal!");
	}
}
