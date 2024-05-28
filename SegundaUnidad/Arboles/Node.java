package Arboles;

public class Node<E> {
  private E data;
  private Node<E> left;
  private Node<E> right;

  // Constructores
  public Node(E data, Node<E> left, Node<E> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public Node(E data) {
    this(data, null, null);
  }

  public String printNode(){
    return "{left:"+this.left+", data:"+this.data+", right:"+this.right+"}"; 
  }

  public String toString(){
    return data.toString();
  }
}
