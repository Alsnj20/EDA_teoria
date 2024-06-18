package listDoubleCircular;

import java.util.ArrayList;
import Interfaces.TDAList;
import Utilidades.NodeDouble;

public class LinkedDoubleCircularList<T> implements TDAList<T>{
  private NodeDouble<T> first;
  private NodeDouble<T> last;
  private int count;

  public LinkedDoubleCircularList() {
    this.first = null;
    this.count = 0;
    this.last = null;
  }

  public void add(T item) {
    NodeDouble<T> node = new NodeDouble<T>(item);
    if (isEmpty()) {
      this.first = this.last = node;
      this.first.setBack(this.last);
      this.last.setNext(this.first);
    } else {
      NodeDouble<T> aux = this.first;
      while (aux.getNext() != this.first) {
        aux = aux.getNext();
      }
      aux.setNext(node);
      this.last = node;
      node.setBack(aux);
      this.last.setNext(this.first);
      this.first.setBack(this.last);
    }
    this.count++;
  }

  public int length() {
    return count;
  }

  public void remove(T item) {
    if (isEmpty()) {
      return;
    } else {
      boolean isFirst = this.first.getData().equals(item);
      boolean isLast = this.last.getData().equals(item);
      if (isFirst || isLast) {
        if (isFirst) {
          this.first = this.first.getNext();
        } else {
          this.last = this.last.getBack();
        }
        this.last.setNext(first);
        this.first.setBack(last);
      } else {
        NodeDouble<T> aux = this.first;
        while (aux.getNext() != this.first && !aux.getData().equals(item)) {
          aux = aux.getNext();
        }
        if (aux.getData().equals(item)) {
          aux.getBack().setNext(aux.getNext());
          aux.getNext().setBack(aux.getBack());
        } else {
          return;
        }
      }
      this.count--;
    }
  }

  public void printStartEnd() {
    System.out.println("Inicio" + this.first.printNode());
    System.out.println("Final" + this.last.printNode());
  }

  /*
   * public void addFirst(T item){
   * NodeDouble<T> node = new NodeDouble<T>(item);
   * if(isEmpty())
   * 
   * }
   * 
   * public void addLast(T item){
   * 
   * }
   */

  public boolean isEmpty() {
    return this.first == null && this.last == null && this.count == 0;
  }

  /* Search */
  public boolean contains(T data) {
    NodeDouble<T> aux = this.first;
    while (aux != this.first && aux.getData().equals(data)) {
      aux = aux.getNext();
    }
    return (aux.getData().equals(data));
  }

  public int indexOf(T data) {
    if (isEmpty()) {
      return -1;
    } else {
      NodeDouble<T> aux = this.first;
      int pos = 0;
      while (aux != this.first && !aux.getData().equals(data)) {
        aux = aux.getNext();
        pos++;
      }
      return (aux.getData().equals(data)) ? pos : -1;
    }
  }

  public T get(int index) {
    if (index < 0 || index >= count) {
      return null;
    } else {
      NodeDouble<T> aux = this.first;
      for (int i = 0; i < index; i++) {
        aux = aux.getNext();
      }
      return aux.getData();
    }
  }

  public T find(T data) {
    int n = indexOf(data);
    if (n == -1) {
      return null;
    } else {
      NodeDouble<T> aux = this.first;
      for (int i = 0; i < n; i++) {
        aux = aux.getNext();
      }
      return aux.getData();
    }
  }

  public String toString() {
    if (!isEmpty()) {
      String str = "";
      NodeDouble<T> aux = this.first;
      while (aux.getNext() != this.first) {
        str += aux.printNode();
        aux = aux.getNext();
      }
      return str + this.last.printNode();
    }
    return null;
  }

  protected void toArrayList(ArrayList<T> arr) {
    if (!isEmpty()) {
      NodeDouble<T> aux = this.first;
      while (aux.getNext() != this.first) {
        arr.add(aux.getData());
        aux = aux.getNext();
      }
      arr.add(this.last.getData());
    }
  }

  public ArrayList<T> toArrayList(){
    ArrayList<T> arr = new ArrayList<>();
    toArrayList(arr);
    return arr;
  }
}
