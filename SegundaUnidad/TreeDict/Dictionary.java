package TreeDict;

import Exceptions.ItemDuplicated;
import Exceptions.ItemNotFound;

public interface Dictionary<K,V> {
  void insert(K key, V value) throws ItemDuplicated;
  V search(K key) throws ItemNotFound;
  void remove(K key) throws ItemNotFound;
  boolean isEmpty();
}
