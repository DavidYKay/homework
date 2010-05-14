import java.util.*;

public class Enumeration2Iterator<E> implements Iterator<E> {
  Enumeration<E> enumeration;

  public Enumeration2Iterator(Enumeration<E> enumeration) {
    this.enumeration = enumeration;
  }

  public boolean hasNext() {
    return enumeration.hasMoreElements();
  }

  public E next() {
    return enumeration.nextElement();
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }
}
