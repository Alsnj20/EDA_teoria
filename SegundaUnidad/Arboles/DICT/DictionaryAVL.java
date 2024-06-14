package DICT;
import AVL.TreeAVL;
import BST.ItemDuplicated;
import BST.ItemNotFound;
public class DictionaryAVL<K extends Comparable<K>, V> implements Dictionary<K,V>{
  private TreeAVL<EntryDict<K,V>> bst;

  public DictionaryAVL(){
    bst = new TreeAVL<EntryDict<K,V>>();
  }

  public void insert(K key, V value) throws ItemDuplicated{
    this.bst.insert(new EntryDict<K,V>(key, value));
  }
  public void remove(K key) throws ItemNotFound{
    this.bst.remove(new EntryDict<K,V>(key, null));
  }

  public V search(K key) throws ItemNotFound{
    EntryDict<K,V> e = this.bst.search(new EntryDict<K,V>(key, null));
    return e.getValue();
  }

  public boolean isEmpty(){
    return false;
  }

  public String toString(){
    return this.bst.toString();
  }

  public void printDict(){
    this.bst.printTree();
  }
}
  

