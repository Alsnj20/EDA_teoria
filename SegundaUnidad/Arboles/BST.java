package Arboles;

public class BST<T extends Comparable<T>> {
  private Node<T> root;

  // Constructores de un BST vacio
  public BST() {
    this.root = null;
  }

  public void inser(T x) {
    return;
  }

  public void remove(T x) {
    return;
  }

  public T search(T x) throws ItemNotFound {
    Node<T> res = searchNode(x, root);
    if (res == null)
      throw new ItemNotFound("El dato " + x + "no esta");
    return res.data;
  }

  protected Node<T> searchNode(T x, Node<T> n) {
    if (n == null)
      return null;
    else {
      int resC = n.data.compareTo(x);
      if (resC < 0)
        return searchNode(x, n.right);
      else if (resC > 0)
        return searchNode(x, n.left);
      else
        return n;
    }
  }

}
