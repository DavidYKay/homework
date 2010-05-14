public interface MyList {
  /** Add a new element o at the end of this list */
  public void add(Object o);

  /** Add a new element o at the specified index in this list */
  public void add(int index, Object o);

  /** Clear the list */
  public void clear();

  /** Return true if this list contains the element o */
  public boolean contains(Object o);

  /** Return the element from this list at the specified index */
  public Object get(int index);

  /** Return the index of the first matching element in this list.
   *  Return -1 if no match. */
  public int indexOf(Object o);

  /** Return true if this list contains no elements */
  public boolean isEmpty();

  /** Return the index of the last matching element in this list
   *  Return -1 if no match. */
  public int lastIndexOf(Object o);

  /** Remove the first occurrence of the element o from this list.
   *  Shift any subsequent elements to the left.
   *  Return true if the element is removed. */
  public boolean remove(Object o);

  /** Remove the element at the specified position in this list
   *  Shift any subsequent elements to the left.
   *  Return the element that was removed from the list. */
  public Object remove(int index);

  /** Replace the element at the specified position in this list
   *  with the specified element. */
  public Object set(int index, Object o);

  /** Return the number of elements in this list */
  public int size();
}