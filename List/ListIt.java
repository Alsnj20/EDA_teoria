package List;

public interface ListIt<E> {
  void insertFirst(E data);
  void insertLast(E data);
  int search(E data);
  void remove(E data);
  boolean isEmpty();
}
