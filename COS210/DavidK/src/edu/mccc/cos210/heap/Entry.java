package edu.mccc.cos210.heap;
import edu.mccc.cos210.binarytree.*;
import com.cbthinkx.util.Debug;
public class Entry<E> extends TreeNode<E> implements Comparable<Entry<E>> {
	private Integer key;
	public Entry(Integer k, E e) {
		super(e);
		Debug.println("Entry.Entry()");
		this.key = k;
	}
	public Integer key() {
		Debug.println("Entry.key()");
		return this.key;
	}
	public int compareTo(Entry<E> that) {
		Debug.println("Entry.compareTo()");
		return this.key.compareTo(that.key);
	}
	public String toString() {
		Debug.println("Entry.toString()");
		return "{" + key + "," + super.toString() + "}";
	}
}
