package BST;

import java.util.ArrayList;
import java.util.List;

public class BSTree<T extends Comparable<T>> {
  private Node<T> root;

  // Constructores de un BST vacio
  public BSTree() {
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
      // buscamos el lugar para inserción
      int resC = actual.getData().compareTo(x);
      if (resC == 0)
        throw new ItemDuplicated(x + "esta duplicado");
      if (resC < 0)
        res.setRight((insertNode(x, actual.getRight())));
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
      /*res.setData(minRecover(actual.getRight()).getData());
      res.setRight(minRemove(actual.getRight()));*/
      T min = minRemove2();
      res.setData(min);
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
    if (actual.getLeft() != null) {
      actual.setLeft(minRemove(actual.getLeft()));
    } else {
      actual = actual.getRight();
    }
    return actual;
  }

  public T minRecover() {
    Node<T> res = minRecover(this.root);
    return res.getData();
  }

  // Devuelve el nodo con el valor minimo del arbol
  protected Node<T> minRecover(Node<T> actual) {
    if (actual.getLeft() != null)
      return minRecover(actual.getLeft());
    return actual;
  }

  public boolean isEmpty() {
    return this.root == null;
  }

  // Reciclado de código
  public T minRemove2() {
    Node<T> minNode = new Node<T>(null);
    this.root = minRemove(this.root, minNode);
    return minNode.getData();
  }

  protected Node<T> minRemove(Node<T> actual, Node<T> minNode) {
    if (actual.getLeft() != null) {
      actual.setLeft(minRemove(actual.getLeft(), minNode));
    } else {
      minNode.setData(actual.getData());
      actual = actual.getRight();
    }
    return actual;
  }

  // Recorridos
  public String postOrder() {
    if (this.root != null)
      return postOrder(this.root);
    return "*";
  }

  protected String postOrder(Node<T> actual) {
    String res = "";
    if (actual.getLeft() != null)
      res += postOrder(actual.getLeft());
    if (actual.getRight() != null)
      res += postOrder(actual.getRight());
    return res + actual.getData().toString() +" ";
  }

  public String inOrder() {
    if (this.root != null)
      return inOrder(this.root);
    return "*";
  }

  protected String inOrder(Node<T> actual) {
    String res = "";
    if (actual.getLeft() != null)
      res += inOrder(actual.getLeft());
    res += actual.getData().toString()+" ";
    if (actual.getRight() != null)
      res += inOrder(actual.getRight());
    return res;
  }

  public String preOrder() {
    if (this.root != null)
      return preOrder(this.root);
    return "*";
  }

  protected String preOrder(Node<T> actual) {
    String res = "";
    res += actual.getData().toString() +" ";
    if (actual.getLeft() != null)
      res += preOrder(actual.getLeft());
    if (actual.getRight() != null)
      res += preOrder(actual.getRight());
    return res;
  }

  /*
   * public String printTree(Node<T> actual, int level) {
   * String res = "";
   * if (actual != null) {
   * res += printTree(actual.getRight(), level + 1);
   * for (int i = 0; i < level; i++)
   * res += "   ";
   * res += actual+"\n";
   * res += printTree(actual.getLeft(), level + 1);
   * }
   * System.out.println(res);
   * return res;
   * }
   */

  /*public void printTree() {
    printTree(this.root, 0);
  }*/

  public void printTree() {
    List<List<String>> lines = new ArrayList<>();
    List<Node<T>> level = new ArrayList<>();
    List<Node<T>> next = new ArrayList<>();

    level.add(root);
    int nn = 1;

    int widest = 0;

    while (nn != 0) {
      List<String> line = new ArrayList<>();

      nn = 0;

      for (Node<T> n : level) {
        if (n == null) {
          line.add(null);

          next.add(null);
          next.add(null);
        } else {
          String aa = n.getData().toString();
          line.add(aa);
          if (aa.length() > widest)
            widest = aa.length();

          next.add(n.getLeft());
          next.add(n.getRight());

          if (n.getLeft() != null)
            nn++;
          if (n.getRight() != null)
            nn++;
        }
      }

      if (widest % 2 == 1)
        widest++;

      lines.add(line);

      List<Node<T>> tmp = level;
      level = next;
      next = tmp;
      next.clear();
    }

    int perPiece = lines.get(lines.size() - 1).size() * (widest + 4);
    for (int i = 0; i < lines.size(); i++) {
      List<String> line = lines.get(i);
      int hpw = (int) Math.floor(perPiece / 2f) - 1;

      if (i > 0) {
        for (int j = 0; j < line.size(); j++) {

          // split node
          char c = ' ';
          if (j % 2 == 1) {
            if (line.get(j - 1) != null) {
              c = (line.get(j) != null) ? '┴' : '┘';
            } else {
              if (j < line.size() && line.get(j) != null)
                c = '└';
            }
          }
          System.out.print(c);

          // lines and spaces
          if (line.get(j) == null) {
            for (int k = 0; k < perPiece - 1; k++) {
              System.out.print(" ");
            }
          } else {

            for (int k = 0; k < hpw; k++) {
              System.out.print(j % 2 == 0 ? " " : "─");
            }
            System.out.print(j % 2 == 0 ? "┌" : "┐");
            for (int k = 0; k < hpw; k++) {
              System.out.print(j % 2 == 0 ? "─" : " ");
            }
          }
        }
        System.out.println();
      }

      // print line of numbers
      for (int j = 0; j < line.size(); j++) {

        String f = line.get(j);
        if (f == null)
          f = "";
        int gap1 = (int) Math.ceil(perPiece / 2f - f.length() / 2f);
        int gap2 = (int) Math.floor(perPiece / 2f - f.length() / 2f);

        // a number
        for (int k = 0; k < gap1; k++) {
          System.out.print(" ");
        }
        System.out.print(f);
        for (int k = 0; k < gap2; k++) {
          System.out.print(" ");
        }
      }
      System.out.println();

      perPiece /= 2;
    }
  }

  public static void main(String[] args) {
    BSTree<Integer> arbol = new BSTree<Integer>();
    try {
      arbol.insert(18);
      arbol.insert(10);
      arbol.insert(20);
      arbol.insert(5);
      arbol.insert(13);
      System.out.println("Recorrido en preorden");
      System.out.println(arbol.preOrder());
      System.out.println("Recorrido en inorden");
      System.out.println(arbol.inOrder());
      System.out.println("Recorrido en postorden");
      System.out.println(arbol.postOrder());
      System.out.println("Arbol");
      arbol.printTree();
      System.out.println("Eliminando el 5");
      arbol.remove(5);
      System.out.println("Arbol");
      arbol.printTree();
      System.out.println("Eliminando el 15");
      arbol.remove(15);
      System.out.println("Arbol");
      arbol.printTree();
      System.out.println("Eliminando el 10");
      arbol.remove(10);
      System.out.println("Arbol");
      arbol.printTree();
      System.out.println("Eliminando el 1");
      arbol.remove(1);
      System.out.println("Arbol");
      arbol.printTree();
      System.out.println("Eliminando el 18");
      arbol.remove(18);
      System.out.println("Arbol");
      arbol.printTree();
      System.out.println("Eliminando el 13");
      arbol.remove(13);
      System.out.println("Arbol");
      arbol.printTree();
      System.out.println("Eliminando el 11");
      arbol.remove(11);
      System.out.println("Arbol");
      arbol.printTree();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
