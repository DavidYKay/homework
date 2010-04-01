package edu.mccc.cos210.priorityqueue;
import com.cbthinkx.util.Debug;
public class PriorityQueueTest {
	private PriorityQueue<String> priorityQueue;
	public PriorityQueueTest() throws Exception {
		Debug.println("PriorityQueueTest.PriorityQueueTest()");
		this.priorityQueue = new PriorityQueue<String>();
		loadQueue(this.priorityQueue);
	}
	public static void main(String[] sa) throws Exception {
		Debug.println("PriorityQueueTest.main()");
		PriorityQueueTest pqt = new PriorityQueueTest();
		String s;
		while ((s = pqt.priorityQueue.removeMin()) != null) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
	private void loadQueue(PriorityQueue<String> pq) throws Exception {
		Debug.println("PriorityQueueTest.loadQueue()");
		pq.insert(2, "rain");
		pq.insert(8, "the");
		pq.insert(1, "the");
		pq.insert(3, "in");
		pq.insert(9, "plain");
		pq.insert(7, "in");
		pq.insert(5, "falls");
		pq.insert(4, "spain");
		pq.insert(6, "mainly");
	}
}
