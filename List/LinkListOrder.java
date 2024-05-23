package List;

import java.util.Comparator;

public class LinkListOrder<T extends Comparable<T>> extends LinkList1<T> {

  public LinkListOrder() {
    super();
  }

  public void insertFirst(T data) {
    Node<T> node = new Node<>(data);
    if (isEmpty()) {
      this.head = node;
    } else if (this.head.getNext() == null) {
      if (this.head.getData().compareTo(node.getData()) < 0) {
        this.head.setNext(node);
      } else {
        node.setNext(this.head);
      }
    } else {
      Node<T> aux = this.head;
      while (aux.getNext() != null && aux.getNext().getData().compareTo(node.getData()) < 0) {
        aux = aux.getNext();
      }
      System.out.println("Insert");
      node.setNext(aux.getNext());      
      aux.setNext(node);
    }
  }

  public String toString() {
    String str = "";
    Node<T> aux = this.head;
    while (aux != null) {
      str += aux.printNode();
      aux = aux.getNext();
    }
    return str;
  }

  public int compareTo(T data) {
    return 0;
  }

  public static void main(String[] args) {
    System.out.println("Hola");
    LinkListOrder<Integer> list = new LinkListOrder<>();
    list.insertFirst(1);
    System.out.println(list.toString());
    list.insertFirst(2);
    System.out.println(list.toString());
    list.insertFirst(4);
    System.out.println(list.toString());
    list.insertFirst(3);
    System.out.println(list.toString());
  }
}
