package Arboles;

public class BST<T extends Comparable<T>> {
  private Node<T> root;

  // Constructores de un BST vacio
  public BST() {
    this.root = null;
  }

  public void insert(T x) throws ItemDuplicated {
    this.root = insertNode(x, this.root);
  }

  protected Node<T> insertNode(T x, Node<T> actual) throws ItemDuplicated {
    Node<T> res = actual;
    if (actual == null) {
      res = new Node<T>(x);
    } else {
      res = new Node<T>(x);
      // buscamos el lugar para inserción
      int resC = actual.getData().compareTo(x);
      if (resC == 0)
        throw new ItemDuplicated(x + "esta duplicado");
      if (resC < 0)
        res.setRight(insertNode(x, actual.getRight()));
      else
        res.setLeft(insertNode(x, actual.getLeft()));
    }
    return res;

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

  public void remove(T x) throws ItemNotFound {
    this.root = removeNode(x, this.root);
  }

  protected Node<T> removeNode(T x, Node<T> actual) throws ItemNotFound {
    Node<T> res = actual;
    if (actual == null)
      throw new ItemNotFound(x + "no esta");
    int resC = actual.getData().compareTo(x);
    if (resC < 0)
      res.setRight(removeNode(x, actual.getRight()));
    else if (resC > 0)
      res.setLeft(removeNode(x, actual.getLeft()));
    else if (actual.getLeft() != null && actual.getRight() != null) {// dos hijos
      res.setData(minRecover(actual.getRight()).getData());
      res.setRight(minRemove(actual.getRight()));
    } else { // 1 hijo o ninguno
      res = (actual.getLeft() != null) ? actual.getLeft() : actual.getRight();
    }
    return res;
  }

  public T minRemove() {
    T min = minRecover(); // devuelve el menor del árbol
    this.root = minRemove(this.root);
    return min;
  }

  // Elimina el menor de la izquierda de un nodo
  protected Node<T> minRemove(Node<T> actual) {
    if (actual.getLeft() != null) { // busca el mínimo
      actual.setLeft(minRemove(actual.getLeft()));
    } else { // elimina el mínimo
      actual = actual.getRight();
    }
    return actual;
  }

  public boolean isEmpty() {
    return this.root == null;
  }

  //Recorridos
  public String postOrder(){
    if(this.root != null) return postOrder(this.root);
    return "*";
  }

  protected String postOrder(Node<T> actual){
    String res = "";
    if(actual.getLeft() != null) res += postOrder(actual.getLeft());
    if(actual.getRight() != null) res += postOrder(actual.getRight());
    return res + actual.getData().toString()+ "\n";
  }

  public String inOrder(){
    if(this.root != null) return inOrder(this.root);
    return "*";
  }

  protected String inOrder(Node<T> actual){
    String res = "";
    if(actual.getLeft() != null) res += inOrder(actual.getLeft());
    res += actual.getData().toString() + "\n";
    if(actual.getRight() != null) res += inOrder(actual.getRight());
    return res;
  }

  public String preOrder(){
    if(this.root != null) return preOrder(this.root);
    return "*";
  }

  protected String preOrder(Node<T> actual){
    String res = "";
    res += actual.getData().toString() + "\n";
    if(actual.getLeft() != null) res += preOrder(actual.getLeft());
    if(actual.getRight() != null) res += preOrder(actual.getRight());
    return res;
  }
}
