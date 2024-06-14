package EjercicioR1.listOrder;

import EjercicioR1.listSimple.LinkedList;
import EjercicioR1.listSimple.Node;

public class OrderLinkedList<T extends Comparable<T>> extends LinkedList<T> {

  public OrderLinkedList() {
    super();
  }

  public void add(T data) {
    Node<T> node = new Node<>(data);
    if (isEmpty() || this.first.getData().compareTo(node.getData()) > 0) {
      node.setNext(this.first);
      this.first = node;
    } else {
      Node<T> aux = this.first;
      while (aux.getNext() != null && aux.getNext().getData().compareTo(node.getData()) < 0) {
        aux = aux.getNext();
      }
      node.setNext(aux.getNext());
      aux.setNext(node);
    }

  }

  public void remove(T item) {
    if (isEmpty()) {
      return;
    } else if (this.first.getData().equals(item)) {
      this.first = this.first.getNext();
    } else {
      Node<T> aux = this.first;
      while (aux.getNext() != null && aux.getNext().getData().compareTo(item) < 0) {
        aux = aux.getNext();
      }
      if (aux.getNext() != null && aux.getNext().getData().equals(item)) {
        aux.setNext(aux.getNext().getNext());
      }
    }
  }

  public boolean contains(T item) {
    Node<T> aux = this.first;
    while (aux != null && aux.getData().compareTo(item) < 0) {
      aux = aux.getNext();
    }
    return (aux != null && aux.getData().equals(item)); 
  }

  public String toString() {
    return super.toString();
  }

  public static void main(String[] args) {
    OrderLinkedList<Integer> list = new OrderLinkedList<>();
    list.add(5);
    list.add(3);
    list.add(7);
    list.add(1);
    list.add(9);
    list.add(2);
    list.add(6);
    list.add(4);
    list.add(8);
    System.out.println(list.toString());
  }
}
