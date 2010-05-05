public class MyLinkedList extends MyAbstractList {
  private Node first, last;

  /** Create a default list */
  public MyLinkedList() {
  }

  /** Create a list from an array of objects */
  public MyLinkedList(Object[] objects) {
    super(objects);
  }

  /** Return the first element in the list */
  public Object getFirst() {
    if (size == 0) return null;
    else return first.element;
  }

  /** Return the last element in the list */
  public Object getLast() {
    if (size == 0) return null;
    else return last.element;
  }

  /** Add an element to the beginning of the list */
  public void addFirst(Object o) {
    Node newNode = new Node(o);
    newNode.next = first;
    first = newNode;
    size++;

    if (last == null)
      last = first;
  }

  /** Add an element to the end of the list */
  public void addLast(Object o) {
    if (last == null) {
      first = last = new Node(o);
    }
    else {
      last.next = new Node(o);
      last = last.next;
    }

    size++;
  }

  /** Adds a new element o at the specified index in this list
   * The index of the first element is 0 */
  public void add(int index, Object o) {
    if (index == 0) addFirst(o);
    else if (index >= size) addLast(o);
    else {
      Node current = first;
      for (int i = 1; i < index; i++)
        current = current.next;
      Node temp = current.next;
      current.next = new Node(o);
      (current.next).next = temp;
      size++;
    }
  }

  /** Remove the first node and
   *  return the object that is contained in the removed node. */
  public Object removeFirst() {
    if (size == 0) return null;
    else {
      Node temp = first;
      first = first.next;
      size--;
      if (first == null) last = null;
      return temp.element;
    }
  }

  /** Remove the last node and
   * return the object that is contained in the removed node. */
  public Object removeLast() {
    // Implementation left as an exercise
    return null;
  }

  /** Removes the element at the specified position in this list.
   *  Returns the element that was removed from the list. */
  public Object remove(int index) {
    if ((index < 0) || (index >= size)) return null;
    else if (index == 0) return removeFirst();
    else if (index == size - 1) return removeLast();
    else {
      Node previous = first;

      for (int i = 1; i < index; i++) {
        previous = previous.next;
      }

      Node current = previous.next;
      previous.next = current.next;
      size--;
      return current.element;
    }
  }

  /** Override toString() to return elements in the list */
  public String toString() {
    StringBuffer result = new StringBuffer("[");

    Node current = first;
    for (int i = 0; i < size; i++) {
      result.append(current.element);
      current = current.next;
      if (current != null)
        result.append(", "); // Seperate two elements with a comma
      else
        result.append("]"); // Insert the closing ] in the string
    }

    return result.toString();
  }

  /** Clear the list */
  public void clear() {
    first = last = null;
  }

  /** Return true if this list contains the element o */
  public boolean contains(Object o) {
    // Implementation left as an exercise
    return true;
  }

  /** Return the element from this list at the specified index */
  public Object get(int index) {
    // Implementation left as an exercise
    return null;
  }

  /** Returns the index of the first matching element in this list.
   *  Returns -1 if no match. */
  public int indexOf(Object o) {
    // Implementation left as an exercise
    return 0;
  }

  /** Returns the index of the last matching element in this list
   *  Returns -1 if no match. */
  public int lastIndexOf(Object o) {
    // Implementation left as an exercise
    return 0;
  }

  /** The implementation of methods clear(), contains(Object o),
   *  get(int index), indexOf(Object o), lastIndexOf(Object o),
   *  remove(Object o), and set(int index, Object o) are omitted and  */

  /** Replace the element at the specified position in this list
   *  with the specified element. */
  public Object set(int index, Object o) {
    // Implementation left as an exercise
    return null;
  }

  private class Node {
    Object element;
    Node next;

    public Node(Object o) {
      element = o;
    }
  }
}
