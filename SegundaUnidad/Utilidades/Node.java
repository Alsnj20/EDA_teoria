package Utilidades;
public class Node<T> {
  private T data;
  private Node<T> next;

  public Node(T data) {
    this(data, null);
  }

  public Node(T data, Node<T> next) {
    this.data = data;
    this.next = next;
  }

  /* Setter and Getter */
  public void setData(T data) {
    this.data = data;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

  public T getData() {
    return data;
  }

  public Node<T> getNext() {
    return next;
  }

  public String toString() {
    return this.data.toString();
  }

  public String printNode() {
    return "{VALUE:" + this.data.toString() +",NEXT:" + this.next + "}";
  }
}