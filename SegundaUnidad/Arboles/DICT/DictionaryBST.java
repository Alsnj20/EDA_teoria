package DICT;
import BST.BSTree;
import BST.ItemDuplicated;
import BST.ItemNotFound;
public class DictionaryBST<K extends Comparable<K>, V> implements Dictionary<K,V>{
  private BSTree<EntryDict<K,V>> bst;

  public DictionaryBST(){
    bst = new BSTree<EntryDict<K,V>>();
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
    return this.bst.isEmpty();
  }

  public String toString(){
    return this.bst.toString();
  }

  public void printDict(){
    this.bst.printTree();
  }
}
  
