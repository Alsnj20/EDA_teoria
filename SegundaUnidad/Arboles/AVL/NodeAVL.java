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

  public void setFE(int fe) {
    this.fe = fe;
  }

  public String toString() {
    return super.toString() + " FE:" + this.fe;
  }
  
}
