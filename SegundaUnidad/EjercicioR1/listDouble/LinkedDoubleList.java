package EjercicioR1.listDouble;

import EjercicioR1.Interfaces.TDAList;
import EjercicioR1.listSimple.Node;

//Lista ordenada doblemente enlazada
public class LinkedDoubleList<T extends Comparable<T>> implements TDAList<T> {

  private int count;
  private NodeDouble<T> first;

  public LinkedDoubleList() {
    first = null;
    count = 0;
  }

  public void add(T data) {
    NodeDouble<T> node = new NodeDouble<T>(data);
    if (isEmpty()) {
      this.first = node;
    } else if (node.getData().compareTo(this.first.getData()) < 0) {
      node.setNext(this.first);
      this.first.setBack(node);
      this.first = node;
    } else {
      NodeDouble<T> aux = this.first;
      while (aux.getNext() != null && aux.getNext().getData().compareTo(node.getData()) < 0) {
        aux = aux.getNext();
      }
      node.setNext(aux.getNext());
      if (aux.getNext() != null) {
        node.getNext().setBack(node);
      }
      node.setBack(aux);
      aux.setNext(node);
    }
    this.count++;
  }

  public void remove(T data) {
    if (isEmpty()) {
      return;
    } else if (this.first.getData().equals(data)) {
      this.first = this.first.getNext();
      this.first.setBack(null);
      this.count--;
    } else {
      NodeDouble<T> aux = this.first;
      while (aux.getNext() != null && aux.getNext().getData().compareTo(data) < 0) {
        aux = aux.getNext();
      }
      if (aux.getNext() != null && aux.getNext().getData().equals(data)) {
        aux.setNext(aux.getNext().getNext());
        aux.getNext().setBack(aux);
        this.count--;
      }
    }
  }

  public boolean isEmpty() {
    return this.first == null && this.length() == 0;
  }

  public void initializeList() {
    destroyList();
  }

  public int length() {
    return this.count;
  }

  protected void destroyList() {
    while (this.first != null) {
      this.first.setNext(null);
      this.first.setBack(null);
      this.first = this.first.getNext();
    }
    this.count = 0;
  }

  //Buscar
  public boolean contains(T data) {
    Node<T> aux = this.first;
    while (aux != null && aux.getData().compareTo(data) < 0) {
      aux = aux.getNext();
    }
    return (aux != null && aux.getData().equals(data));
  }

  public int indexOf(T data) {
    int pos = 0;
    Node<T> aux = this.first;
    while (aux != null && aux.getData().compareTo(data) < 0) {
      aux = aux.getNext();
      pos++;
    }
    return (aux != null && aux.getData().equals(data)) ? pos : -1;
  }

  public T get(int index) {
    if (index < 0 || index >= count) {
      return null;
    } else {
      Node<T> aux = this.first;
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
      Node<T> aux = this.first;
      for (int i = 0; i < n; i++) {
        aux = aux.getNext();
      }
      return aux.getData();
    }
  }

  public String toString() {
    String str = "";
    NodeDouble<T> aux = this.first;
    while (aux != null) {
      str += aux.printNode() + "\n";
      aux = aux.getNext();
    }
    return str;
  }
}
