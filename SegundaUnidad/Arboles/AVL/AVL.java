package AVL;

import BST.Node;

public class AVL<T extends Comparable<T>> {
  protected NodeAVL<T> root;
  public AVL(){
    this.root = null;
  }

  public void insert(T data) {
    this.root = insert(this.root, data);
  }

  public void remove(T data) {
    this.root = remove(this.root, data);
  }


  protected NodeAVL<T> rotateSR(NodeAVL<T> node){
    NodeAVL<T> h = node.getLeft();
    node.setLeft(h.getRight());
    node = h;
    return node;
  }

  protected NodeAVL<T> rotateSL(NodeAVL<T> node){
    NodeAVL<T> h = node.getRight();
    node.setRight(h.getLeft());
    node = h;
    return node;
  }

  protected NodeAVL<T> rotateDR(NodeAVL<T> node){
    NodeAVL<T> h = node.getLeft();
    node.setLeft(rotateSL(h));
    node = rotateSR(node);
    return node;


  }

  protected NodeAVL<T> rotateDL(NodeAVL<T> node){
    NodeAVL<T> h = node.getRight();
    node.setRight(rotateSR(h));
    node = rotateSL(node);
    return node;
  }
}
