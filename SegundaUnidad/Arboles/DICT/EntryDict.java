package DICT;

public class EntryDict<K extends Comparable<K>, V> implements Comparable<EntryDict<K,V>>{
  private K key;
  private V value;

  public EntryDict(K key, V value){
    this.key = key;
    this.value = value;
  }

  public K getKey(){
    return key;
  }

  public V getValue(){
    return value;
  }

  public void setValue(V value){
    this.value = value;
  }

  public int compareTo(EntryDict<K,V> e){
    return key.compareTo(e.getKey());
  }

  public String toString(){
    return "(" + key + "," + value + ")";
  }
}
