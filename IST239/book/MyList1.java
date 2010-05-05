public interface MyList1<E> {
  /** Add a new element o at the end of this list */
  public void add(E o);

  /** Add a new element o at the specified index in this list */
  public void add(int index, E o);

  /** Clear the list */
  public void clear();

  /** Return true if this list contains the element o */
  public boolean contains(E o);

  /** Return the element from this list at the specified index */
  public E get(int index);

  /** Return the index of the first matching element in this list.
   *  Return -1 if no match. */
  public int indexOf(E o);

  /** Return true if this list contains no elements */
  public boolean isEmpty();

  /** Return the index of the last matching element in this list
   *  Return -1 if no match. */
  public int lastIndexOf(E o);

  /** Remove the first occurrence of the element o from this list.
   *  Shift any subsequent elements to the left.
   *  Return true if the element is removed. */
  public boolean remove(E o);

  /** Remove the element at the specified position in this list
   *  Shift any subsequent elements to the left.
   *  Return the element that was removed from the list. */
  public E remove(int index);

  /** Replace the element at the specified position in this list
   *  with the specified element. */
  public E set(int index, E o);

  /** Return the number of elements in this list */
  public int size();
}
