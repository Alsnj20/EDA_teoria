package RBT;
import AVL.NodeAVL;
public class NodeRBT<T> extends NodeAVL<T>{
  String color;
  public NodeRBT(T data, NodeRBT<T> left, NodeRBT<T> right, int height, String color) {
    super(data, left, right, height);
    this.color = color;
  }
  public NodeRBT(T data, int height, String color) {
    this(data, null, null, height, color);
  }
  public NodeRBT(T data){
    this(data, null, null, 1, "B");
  }
  public NodeRBT<T> getLeft() {
    return (NodeRBT<T>) super.getLeft();
  }
  public NodeRBT<T> getRight() {
    return (NodeRBT<T>) super.getRight();
  }
  public String getColor() {
    return color;
  }
  public void setColor(String color) {
    this.color = color;
  }
  public void setLeft(NodeRBT<T> left) {
    super.setLeft(left);
  }
  public void setRight(NodeRBT<T> right) {
    super.setRight(right);
  }

  public String toString() {
    return "[data:" + this.getData() + ", FE:" + this.getFE() +",C:"+this.getColor()+"]";
  }
}
