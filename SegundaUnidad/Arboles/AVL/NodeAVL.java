package AVL;

import BST.Node;

public class NodeAVL<T> extends Node<T> {
  private int fe;

  public NodeAVL(T data, NodeAVL<T> left, NodeAVL<T> right) {
    super(data, left, right);
    this.fe = 0;
  }

  public NodeAVL(T data) {
    this(data, null, null);
  }

  public int getFE() {
    return this.fe;
  }
  public NodeAVL<T> getLeft() {
    return (NodeAVL<T>) super.getLeft();
  }

  public NodeAVL<T> getRight() {
    return (NodeAVL<T>) super.getRight();
  }

  public void setFE(int fe) {
    this.fe = fe;
  }

  public void setLeft(NodeAVL<T> left) {
    super.setLeft(left);
  }

  public void setRight(NodeAVL<T> right) {
    super.setRight(right);
  }
  
  public String toString() {
    return "[data:" + this.getData()+", fe:" + this.fe + "]";
  }
  public String printNode(){
    return "{left:"+ this.getLeft()+",data:" + this.getData()+" ,right:" + this.getRight()+", fe:" + this.fe +"}";
  }
  
}
