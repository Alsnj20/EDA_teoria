package AVL;

import java.util.*;

import BST.ItemDuplicated;
import BST.ItemNotFound;

public class AVL<T extends Comparable<T>> {
  protected NodeAVL<T> root;

  public AVL() {
    this.root = null;
  }

  public void insert(T x) throws ItemDuplicated {
    this.root = insertNode(x, this.root);
  }

  protected NodeAVL<T> insertNode(T x, NodeAVL<T> actual) throws ItemDuplicated {
    NodeAVL<T> res = actual;
    if (actual == null) {
      res = new NodeAVL<T>(x);
    } else {
      // buscamos el lugar para inserción
      int resC = actual.getData().compareTo(x);
      if (resC == 0)
        throw new ItemDuplicated(x + "esta duplicado");
      if (resC < 0)
        res.setRight((insertNode(x, actual.getRight())));
      else
        res.setLeft(insertNode(x, actual.getLeft()));

      // actualizamos el FE
      res.updateFE();
    }
    return balanceInsert(res);
  }

  protected NodeAVL<T> balanceInsert(NodeAVL<T> node) {
    if (node.getFE() == -2) {
      if (node.getLeft().getFE() == -1) {
        return rotateSR(node);
      } else {
        return rotateDR(node);
      }
    } else if (node.getFE() == 2) {
      if (node.getRight().getFE() == 1) {
        return rotateSL(node);
      } else {
        return rotateDL(node);
      }
    }
    return node;
  }

  public void remove(T x) throws ItemNotFound {
    this.root = removeNode(x, this.root);
  }

  public NodeAVL<T> removeNode(T x, NodeAVL<T> actual) throws ItemNotFound {
    NodeAVL<T> res = actual;
    if (actual == null) {
      throw new ItemNotFound(x + "no esta");
    } else {
      int resC = actual.getData().compareTo(x);
      if (resC < 0) {
        res.setRight(removeNode(x, actual.getRight()));
      } else if (resC > 0) {
        res.setLeft(removeNode(x, actual.getLeft()));
      } else if (actual.getLeft() != null && actual.getRight() != null) {// dos hijos
        actual.setData(minRemove2());
        res = actual;
      } else { // 1 hijo o ninguno
        res = (actual.getLeft() != null) ? actual.getLeft() : actual.getRight();
      }
      res.updateFE();
      /*return balanceRemove(res);*/
      return res;
    }
  }

  public NodeAVL<T> balanceRemove(NodeAVL<T> node) {
    if (node.getFE() == -2) {
      int feLeft = node.getLeft().getFE();
      if (feLeft == 1 || feLeft == 0) {
        return rotateSR(node);
      } else {
        return rotateDR(node);
      }
    } else if (node.getFE() == 2) {
      int feRight = node.getRight().getFE();
      if (feRight == -1 || feRight == 0) {
        return rotateSL(node);
      } else {
        return rotateDL(node);
      }
    }
    return node;
  }

  //Reciclado de código
  public T minRemove2() {
    NodeAVL<T> minNode = new NodeAVL<T>(null);
    this.root = minRemove(this.root, minNode);
    return minNode.getData();
  }

  protected NodeAVL<T> minRemove(NodeAVL<T> actual, NodeAVL<T> minNode) {
    if (actual.getLeft() != null) {
      actual.setLeft(minRemove(actual.getLeft(), minNode));
    } else {
      minNode.setData(actual.getData());
      actual = actual.getRight();
    }
    return actual;
  }

  // Rotaciones
  protected NodeAVL<T> rotateSR(NodeAVL<T> node) {
    NodeAVL<T> h = node.getLeft();
    node.setLeft(h.getRight());
    h.setRight(node);
    node.updateFE();
    h.updateFE();
    return h;
  }

  protected NodeAVL<T> rotateSL(NodeAVL<T> node) {
    NodeAVL<T> h = node.getRight();
    node.setRight(h.getLeft());
    h.setLeft(node);
    node.updateFE();
    h.updateFE();
    return h;
  }

  protected NodeAVL<T> rotateDR(NodeAVL<T> node) {
    NodeAVL<T> h = node.getLeft();
    node.setLeft(rotateSL(h));
    return rotateSR(node);
  }

  protected NodeAVL<T> rotateDL(NodeAVL<T> node) {
    NodeAVL<T> h = node.getRight();
    node.setRight(rotateSR(h));
    return rotateSL(node);
  }

  public void printTree() {
    List<List<String>> lines = new ArrayList<>();
    List<NodeAVL<T>> level = new ArrayList<>();
    List<NodeAVL<T>> next = new ArrayList<>();

    level.add(root);
    int nn = 1;

    int widest = 0;

    while (nn != 0) {
      List<String> line = new ArrayList<>();

      nn = 0;

      for (NodeAVL<T> n : level) {
        if (n == null) {
          line.add(null);

          next.add(null);
          next.add(null);
        } else {
          // print Data
          String aa = n.toString();
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

      List<NodeAVL<T>> tmp = level;
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
}
