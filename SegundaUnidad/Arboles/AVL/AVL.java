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

  }

  protected NodeAVL<T> rotateSL(){

  }

  protected NodeAVL<T> rotateDR(){

  }

  protected NodeAVL<T> rotateDL(){

  }

  
}
