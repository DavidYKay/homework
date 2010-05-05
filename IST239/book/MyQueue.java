public class MyQueue {
  private MyLinkedList list = new MyLinkedList();

  public void enqueue(Object o) {
    list.addLast(o);
  }

  public Object dequeue() {
    return list.removeFirst();
  }

  public int getSize() {
    return list.size();
  }

  public String toString() {
    return "Queue: " + list.toString();
  }
}