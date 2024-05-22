package List;

import java.util.List;

public class LinkList<T> implements ListIt<T> {
  private Node<T> head;

  public LinkList() {
    this.head = null;
  }

  public void insertFirst(T data) {
    this.head = new Node<T>(data, this.head);
  }

  public void insertLast(T data) {
    if (isEmpty()) {
      this.head = new Node<T>(data);
    } else {
      Node<T> aux = this.head;
      while (aux.getNext() != null) {
        aux.setNext(aux.getNext());
      }
    }
  }

  public void remove(T data) {
    if (!isEmpty()) {
      if(this.head.getData().equals(data)){
        this.head = this.head.getNext();
      }else{
        Node<T> aux = this.head;
        while(aux.getNext() != null && !aux.getNext().getData().equals(data)){
          aux = aux.getNext();
          if(aux.getNext() != null){
            aux.setNext(aux.getNext().getNext());
          }
        }
      }
    }
  }

  public int search(T data) {
    int pos = 0;
    Node<T> aux = this.head;
    while (aux != null && !aux.getData().equals(aux)) {
      pos++;
      aux = aux.getNext();
    }
    return aux != null ? pos : -1;
  }

  public boolean isEmpty() {
    return this.head == null;
  }

  public String toString() {
    String str = "";
    Node<T> aux = this.head;
    for (; aux != null; aux = aux.getNext()) {
      str += aux.toString() + ", ";
    }
    return str;
  }
}
