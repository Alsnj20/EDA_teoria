package EjercicioR1.Tienda.listDoubleCircular;

import EjercicioR1.Interfaces.TDAList;
import EjercicioR1.listDouble.NodeDouble;
public class LinkedDoubleCircularList<T extends Comparable<T>> implements TDAList<T> {
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
      System.out.println("Actual" + aux.printNode());
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
      if (this.first.getData().equals(item)) {
        this.first = this.first.getNext();
        this.last.setNext(first);
        this.first.setBack(last);
      } else if (this.last.getData().equals(item)) {
        this.last = this.last.getBack();
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

  public int indexOf(T data) {
    int pos = 0;
    NodeDouble<T> aux = this.first;
    while (aux.getNext() != this.first && !aux.getData().equals(data)) {
      aux = aux.getNext();
      pos++;
    }
    System.out.println(aux.printNode());
    return (aux.getData().equals(data)) ? pos : -1;
  }

  public String toString() {
    String str = "";
    NodeDouble<T> aux = this.first;
    while (aux.getNext() != this.first) {
      str += aux.printNode();
      aux = aux.getNext();
    }
    return str + this.last.printNode();
  }
}
