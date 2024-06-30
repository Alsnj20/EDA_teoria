package TreeBST;

import java.util.ArrayList;
import java.util.List;

import Exceptions.ItemDuplicated;
import Exceptions.ItemNotFound;
import Cola.QueueLink;

public class BSTree<T extends Comparable<T>> {
  private NodeBST<T> root;

  // Constructores de un BST vacio
  public BSTree() {
    this.root = null;
  }

  public void insert(T x) throws ItemDuplicated {
    this.root = insertNode(x, this.root);
  }

  protected NodeBST<T> insertNode(T x, NodeBST<T> actual) throws ItemDuplicated {
    NodeBST<T> res = actual;
    if (actual == null) {
      res = new NodeBST<T>(x);
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
    NodeBST<T> res = searchNode(x, root);
    if (res == null)
      throw new ItemNotFound("El dato " + x + "no esta");
    return res.getData();
  }

  protected NodeBST<T> searchNode(T x, NodeBST<T> n) {
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

  protected NodeBST<T> removeNode(T x, NodeBST<T> actual) throws ItemNotFound {
    NodeBST<T> res = actual;
    if (actual == null)
      throw new ItemNotFound(x + "no esta");
    int resC = actual.getData().compareTo(x);
    if (resC < 0)
      res.setRight(removeNode(x, actual.getRight()));
    else if (resC > 0)
      res.setLeft(removeNode(x, actual.getLeft()));
    else if (actual.getLeft() != null && actual.getRight() != null) {// dos hijos
      /*
       * res.setData(minRecover(actual.getRight()).getData());
       * res.setRight(minRemove(actual.getRight()));
       */
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
  protected NodeBST<T> minRemove(NodeBST<T> actual) {
    if (actual.getLeft() != null) {
      actual.setLeft(minRemove(actual.getLeft()));
    } else {
      actual = actual.getRight();
    }
    return actual;
  }

  public T minRecover() {
    NodeBST<T> res = minRecover(this.root);
    return res.getData();
  }

  // Devuelve el nodo con el valor minimo del arbol
  protected NodeBST<T> minRecover(NodeBST<T> actual) {
    if (actual.getLeft() != null)
      return minRecover(actual.getLeft());
    return actual;
  }

  public boolean isEmpty() {
    return this.root == null;
  }

  // Reciclado de código
  public T minRemove2() {
    NodeBST<T> minNode = new NodeBST<T>(null);
    this.root = minRemove(this.root, minNode);
    return minNode.getData();
  }

  protected NodeBST<T> minRemove(NodeBST<T> actual, NodeBST<T> minNode) {
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

  protected String postOrder(NodeBST<T> actual) {
    String res = "";
    if (actual.getLeft() != null)
      res += postOrder(actual.getLeft());
    if (actual.getRight() != null)
      res += postOrder(actual.getRight());
    return res + actual.getData().toString() + " ";
  }

  public String inOrder() {
    if (this.root != null)
      return inOrder(this.root);
    return "*";
  }

  protected String inOrder(NodeBST<T> actual) {
    String res = "";
    if (actual.getLeft() != null)
      res += inOrder(actual.getLeft());
    res += actual.getData().toString() + " ";
    if (actual.getRight() != null)
      res += inOrder(actual.getRight());
    return res;
  }

  /*
   * public String preOrder() {
   * if (this.root != null)
   * return preOrder(this.root);
   * return "*";
   * }
   */

  protected void preOrder(NodeBST<T> actual, ArrayList<T> list) {
    list.add(actual.getData());
    if (actual.getLeft() != null)
      preOrder(actual.getLeft(), list);
    if (actual.getRight() != null)
      preOrder(actual.getRight(), list);
  }

  public ArrayList<T> toArrayList() {
    ArrayList<T> arr = new ArrayList<>();
    if (!isEmpty()) {
      preOrder(root, arr);
    }
    return arr;
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

  /*
   * public void printTree() {
   * printTree(this.root, 0);
   * }
   */

  public void printTree() {
    List<List<String>> lines = new ArrayList<>();
    List<NodeBST<T>> level = new ArrayList<>();
    List<NodeBST<T>> next = new ArrayList<>();

    level.add(root);
    int nn = 1;

    int widest = 0;

    while (nn != 0) {
      List<String> line = new ArrayList<>();

      nn = 0;

      for (NodeBST<T> n : level) {
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

      List<NodeBST<T>> tmp = level;
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

  public double calcularEMC() {
    if (this.root == null)
      return 0;
    QueueLink<NodeBST<T>> queue = new QueueLink<>();
    queue.enqueue(this.root);
    ;

    int totalNodos = 0;
    int totalComparaciones = 0;
    int nivel = 0;
    System.out.println("Altura inicial" + queue.size());

    while (!queue.isEmpty()) {
      int nivelSize = queue.size();
      nivel++;
      System.out.println("Nivel: "+nivel);
      for (int i = 0; i < nivelSize; i++) {
        try {
          System.out.println(queue);
          NodeBST<T> temp = queue.dequeue();
          totalNodos++;
          totalComparaciones += nivel;

          if (temp.getLeft() != null)
            queue.enqueue(temp.getLeft());
          if (temp.getRight() != null)
            queue.enqueue(temp.getRight());
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
    }
    return (double) totalComparaciones / totalNodos;
  }
}
