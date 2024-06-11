package AVL;
import BST.Node;

public class NodeAVL<T> extends Node<T> {
  private int height;

  public NodeAVL(T data, NodeAVL<T> left, NodeAVL<T> right, int height) {
    super(data, left, right);
    this.height = height;
  }

  public NodeAVL(T data, int height) {
    this(data, null, null, height);
  }

  public NodeAVL(T data) {
    this(data, null, null, 1);
  }

  public NodeAVL<T> getLeft() {
    return (NodeAVL<T>) super.getLeft();
  }

  public NodeAVL<T> getRight() {
    return (NodeAVL<T>) super.getRight();
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getRightHeight() {
    NodeAVL<T> right = this.getRight();
    return right != null ? right.getHeight() : 0;
  }

  public int getLeftHeight() {
    NodeAVL<T> left = this.getLeft();
    return left != null ? left.getHeight() : 0;
  }

  public int getFE() {
    return this.getRightHeight() - this.getLeftHeight();
  }

  public void updateHeight() {
    this.setHeight(Math.max(this.getLeftHeight(), this.getRightHeight()) + 1);
  }

  public void setLeft(NodeAVL<T> left) {
    super.setLeft(left);
  }

  public void setRight(NodeAVL<T> right) {
    super.setRight(right);
  }

  public String toString() {
    return "[data:" + this.getData() + ", FE:" + this.getFE() + "]";
  }

  public String printNode() {
    return "{left:" + this.getLeft() + ",data:" + this.getData() + " ,right:" + this.getRight() + ", fe:" + this.getFE()
        + "}";
  }
}