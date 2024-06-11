package RBT;

import AVL.NodeAVL;

public class NodeRBT<T> extends NodeAVL<T> {
  // Design
  private static final String RED = "\u001B[31m";
  private static final String BLACK = "\u001B[2m";
  private static final String RESET = "\u001B[0m";
  private String color;

  public NodeRBT(T data, NodeRBT<T> left, NodeRBT<T> right, int height, String color) {
    super(data, left, right, height);
    this.color = color;
  }

  public NodeRBT(T data, int height, String color) {
    this(data, null, null, height, color);
  }

  public NodeRBT(T data) {
    this(data, null, null, 1, "R");
  }

  public NodeRBT(T data, String color) {
    this(data, null, null, 1, color);
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

  public void setColor(int n) {
    switch (n) {
      case 1:
        this.color = "B";
        break;
      case 2:
        this.color = "R";
        break;
    }
  }

  public void setLeft(NodeRBT<T> left) {
    super.setLeft(left);
  }

  public void setRight(NodeRBT<T> right) {
    super.setRight(right);
  }

  public void updateColor() {
    NodeRBT<T> left = this.getLeft();
    NodeRBT<T> right = this.getRight();
    if (this.getColor() == "R" && left != null && right != null) {
      if (left.getColor() == "R" && right.getColor() == "R") {
        this.setColor(1);
        left.setColor(2);
        right.setColor(2);
      }
    }
  }

  private String colorToANSI() {
    return this.color.equals("R") ? RED : BLACK;
  }

  public String toString() {
    return colorToANSI() + "[data:" + this.getData() + ", FE:" + this.getFE() + ", C:" + this.getColor() + "]" + RESET;
  }
}
