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
  //setter y getter

  public E getData(){
    return this.data;
  }

  public void setData(E data){
    this.data = data;
  }
  public Node<E> getLeft(){
    return this.left;
  }
  public void setLeft(Node<E> left){
    this.left = left;
  }

  public Node<E> getRight(){
    return this.right;
  }

  public void setRight(Node<E> right){
    this.right = right;
  }



  public String printNode(){
    return "{left:"+this.left+", data:"+this.data+", right:"+this.right+"}"; 
  }

  public String toString(){
    return data.toString();
  }
}
