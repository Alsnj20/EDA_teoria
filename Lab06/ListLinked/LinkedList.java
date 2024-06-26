package ListLinked;
import java.util.ArrayList;

public class LinkedList<T extends Comparable<T>> implements TDAList<T> {
  private int count;
  protected Node<T> first;

  public LinkedList() {
    this.first = null;
    this.count = 0;
  }

  public void add(T item) {
    if (count % 2 == 0) {
      addFirst(item);
    } else {
      addLast(item);
    }
  }

  public boolean isEmpty() {
    return this.first == null && count == 0;
  }

  public int length() {
    return this.count;
  }

  public void initializeList() {
    destroyList();
  }

  protected void destroyList() {
    while (this.first != null) {
      this.first.setNext(null);
      this.first = this.first.getNext();
    }
    this.count = 0;
  }

  public int indexOf(T item) {
    int pos = 0;
    Node<T> aux = this.first;
    while (aux != null && !aux.getData().equals(item)) {
      pos++;
      aux = aux.getNext();
    }
    return (aux == null) ? -1 : pos;
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

  // beginning of the list.
  public void addFirst(T item) {
    Node<T> aux = new Node<T>(item);
    aux.setNext(this.first);
    this.first = aux;
    this.count++;
  }

  public void addLast(T item) {
    Node<T> node = new Node<>(item);
    if (isEmpty()) {
      addFirst(item);
    } else {
      Node<T> aux = this.first;
      while (aux.getNext() != null) {
        aux = aux.getNext();
      }
      aux.setNext(node);
    }
    this.count++;
  }

  public void remove(T item) {
    if (isEmpty()) {
      return;
    } else if (this.first.getData().equals(item)) {
      this.first = this.first.getNext();
      this.count--;
    } else {
      Node<T> aux = this.first;
      while (aux.getNext() != null && !aux.getNext().getData().equals(item)) {
        aux = aux.getNext();
      }
      if (aux.getNext() != null) {
        aux.setNext(aux.getNext().getNext());
        this.count--;
      }
    }
  }

  public void addKesimo(T data, int k) {
    if (k == 0) {
      addFirst(data);
    } else if (k >= count) {
      addLast(data);
    } else {
      Node<T> node = new Node<>(data);
      Node<T> aux = this.first;
      for (int i = 0; i < k - 1; i++) {
        aux = aux.getNext();
      }
      node.setNext(aux.getNext());
      aux.setNext(node);
    }
    this.count++;
  }

  public ArrayList<LinkedList<T>> sort(T x) {
    ArrayList<LinkedList<T>> order = new ArrayList<>();
    LinkedList<T> list1 = new LinkedList();
    LinkedList<T> list2 = new LinkedList();
    Node<T> aux = this.first;
    while (aux != null) {
      if (aux.getData().compareTo(x) <= 0) {
        list2.addsortList(aux.getData());
      } else {
        list1.addsortList(aux.getData());
      }
      aux = aux.getNext();
    }
    order.add(list1);
    order.add(list2);
    return order;
  }

  private void addsortList(T data){
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



  public String toString() {
    String str = "";
    Node<T> aux = this.first;
    while (aux != null) {
      str += aux.printNode() + "\n";
      aux = aux.getNext();
    }
    return str;
  }
}