package Refuerzo;

import Utilidades.Node;

public class ListaSimpleOrdenada<T extends Comparable<T>> {
  private Node<T> first;

  public ListaSimpleOrdenada(){
    first = null;
  }
  public void add(T data) {
    Node<T> node = new Node<T>(data);
    if (isEmpty()) {
      first = node;
    } else if(this.first.getData().compareTo(data) > 0){
      node.setNext(this.first.getNext());
      this.first.setNext(node);
      this.first = node;
    }else{
      Node<T> aux = this.first;
      while(aux.getNext() != null && aux.getNext().getData().compareTo(data) < 0){
        aux = aux.getNext();
      }
      node.setNext(aux.getNext());
      aux.setNext(node);
    }
  }

  public void remove(T data) {
    if (!isEmpty()) {
      Node<T> aux = this.first;
      while (aux.getNext() != null && !aux.getNext().getData().equals(data)) {
        aux = aux.getNext();
      }
      if (aux.getNext() != null && aux.getNext().getData().equals(data)) {
        aux.setNext(aux.getNext().getNext());
      }
    }
  }

  public T search(T data) {
    if (!isEmpty()) {
      Node<T> aux = this.first;
      while (aux.getNext() != null && !aux.getNext().getData().equals(data)) {
        aux = aux.getNext();
      }
      if (aux.getNext() != null && aux.getNext().getData().equals(data)) {
        return aux.getNext().getData();
      }
    }
    return null;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public String toString(){
    String str = "";
    Node<T> aux = this.first;
    while(aux != null){
      str += aux.printNode();
      aux = aux.getNext();
    }
    return str;
  }
}
