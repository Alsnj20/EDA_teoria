package TreeBST;

public class NodeBST<E> {
  private E data;
  private NodeBST<E> left;
  private NodeBST<E> right;

  // Constructores
  public NodeBST(E data, NodeBST<E> left, NodeBST<E> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public NodeBST(E data) {
    this(data, null, null);
  }
  //setter y getter

  public E getData(){
    return this.data;
  }

  public void setData(E data){
    this.data = data;
  }
  public NodeBST<E> getLeft(){
    return this.left;
  }
  public void setLeft(NodeBST<E> left){
    this.left = left;
  }

  public NodeBST<E> getRight(){
    return this.right;
  }

  public void setRight(NodeBST<E> right){
    this.right = right;
  }



  public String printNode(){
    return "{left:"+this.left+", data:"+this.data+", right:"+this.right+"}"; 
  }

  public String toString(){
    return data.toString();
  }
}
