public class MyArrayList1<E> extends MyAbstractList1<E> {
  public static final int INITIAL_CAPACITY = 16;
  private E[] data = (E[])new Object[INITIAL_CAPACITY];

  /** Create a default list */
  public MyArrayList1() {
  }

  /** Create a list from an array of objects */
  public MyArrayList1(E[] objects) {
    data = objects;
    size = objects.length;
  }

  /** Add a new element o at the specified index in this list */
  public void add(int index, E o) {
    ensureCapacity();

    // Move the elements to the right after the specified index
    for (int i = size - 1; i >= index; i--)
      data[i + 1] = data[i];

    // Insert new element to data[index]
    data[index] = o;

    // Increase size by 1
    size++;
  }

  /** Create a new larger array, double the current size */
  private void ensureCapacity() {
    if (size >= data.length) {
      E[] newData = (E[])(new Object[data.length * 2]);
      System.arraycopy(data, 0, newData, 0, data.length);
      data = newData;
    }
  }

  /** Clear the list */
  public void clear() {
    data = (E[])new Object[INITIAL_CAPACITY];
  }

  /** Return true if this list contains the element o */
  public boolean contains(E o) {
    for (int i = 0; i < size; i++)
      if (o.equals(data[i])) return true;

    return false;
  }

  /** Return the element from this list at the specified index */
  public E get(int index) {
    return data[index];
  }

  /** Return the index of the first matching element in this list.
   *  Return -1 if no match. */
  public int indexOf(E o) {
    for (int i = 0; i < size; i++)
      if (o.equals(data[i])) return i;

    return -1;
  }

  /** Return the index of the last matching element in this list
   *  Return -1 if no match. */
  public int lastIndexOf(E o) {
    for (int i = size - 1; i >= 0; i--)
      if (o.equals(data[i])) return i;

    return -1;
  }

  /** Remove the first occurrence of the element o from this list.
   *  Shift any subsequent elements to the left.
   *  Return true if the element is removed. */
  public boolean remove(E o) {
    for (int i = 0; i < size; i++)
      if (o.equals(data[i])) {
        remove(i);
        return true;
      }

    return false;
  }

  /** Remove the element at the specified position in this list
   *  Shift any subsequent elements to the left.
   *  Return the element that was removed from the list. */
  public E remove(int index) {
    E o = data[index];

    // Shift data to the left
    for (int j = index; j < size - 1; j++)
      data[j] = data[j + 1];

    // Decrement size
    size--;

    return o;
  }

  /** Replace the element at the specified position in this list
   *  with the specified element. */
  public E set(int index, E o) {
    data[index] = o;
    return o;
  }

  /** Override toString() to return elements in the list */
  public String toString() {
    StringBuffer result = new StringBuffer("[");

    for (int i = 0; i < size; i++) {
      result.append(data[i]);
      if (i < size - 1) result.append(", ");
    }

    return result.toString() + "]";
  }
}
