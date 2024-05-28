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
    return res.getData();
  }

  protected Node<T> searchNode(T x, Node<T> n) {
    if (n == null)
      return null;
    else {
      int resC = n.getData().compareTo(x);
      if (resC < 0)
        return searchNode(x, n.getRight());
      else if (resC > 0)
        return searchNode(x, n.getLeft());
      else
        return n;
    }
  }
}
