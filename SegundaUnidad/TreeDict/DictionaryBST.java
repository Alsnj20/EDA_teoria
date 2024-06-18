package TreeDict;
import java.util.ArrayList;

import Exceptions.ItemDuplicated;
import Exceptions.ItemNotFound;
import TreeBST.BSTree;
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

  public ArrayList<EntryDict<K,V>> toArrayList(){
    return this.bst.toArrayList();
  }

  public void printDict(){
    //System.out.println(this.bst.inOrder());
    this.bst.printTree();
  }
}
  
