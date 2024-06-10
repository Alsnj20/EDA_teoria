package AVL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BST.ItemDuplicated;
import BST.Node;

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
      // actualizamos el factor de equilibrio
      res.setFE(res.getFE() + (resC < 0 ? 1 : -1));
      // balanceamos el arbol}
      System.out.println("RES: " + res);
      System.out.println("RES.FE: " + res.getFE());
      balance(res);
    }
    return res;
  }

  public void printListTree() {
    List<NodeAVL<T>> nodeList = new ArrayList<>();
    Queue<NodeAVL<T>> queue = new LinkedList<>();
    if (this.root != null) {
      queue.add(root);
    }
    while (!queue.isEmpty()) {
      NodeAVL<T> node = queue.poll();
      nodeList.add(node);
      if (node.getLeft() != null) {
        queue.add(node.getLeft());
      }
      if (node.getRight() != null) {
        queue.add(node.getRight());
      }
    }

    // Formatte
    System.out.println("Nodes in list format:");
    for (NodeAVL<T> node : nodeList) {
      if (node != null) {
        System.out.println(node.printNode());
      } else {
        System.out.println("null");
      }
    }
  }

  protected void balance(NodeAVL<T> node) {
    if (node.getFE() == -2) {
      if (node.getLeft().getFE() == 1) {
        node = rotateSR(node);
      } else {
        node = rotateDR(node);
      }
    } else if (node.getFE() == 2) {
      if (node.getRight().getFE() == -1) {
        node = rotateSL(node);
      } else {
        node = rotateDL(node);
      }
    }
  }

  public void remove(T data) {
    this.root = remove(this.root, data);
  }

  protected NodeAVL<T> remove(NodeAVL<T> node, T data) {
    if (node == null) {
      return null;
    }
    int res = node.getData().compareTo(data);
    if (res == 0) {
      if (node.getLeft() == null && node.getRight() == null) {
        return null;
      }
      if (node.getLeft() == null) {
        return node.getRight();
      }
      if (node.getRight() == null) {
        return node.getLeft();
      }
      T min = null; // findMin(node.getRight());
      node.setData(min);
      node.setRight(remove(node.getRight(), min));
    } else if (res < 0) {
      node.setRight(remove(node.getRight(), data));
    } else {
      node.setLeft(remove(node.getLeft(), data));
    }
    return node;
  }

  protected NodeAVL<T> rotateSR(NodeAVL<T> node) {
    NodeAVL<T> h = node.getLeft();
    node.setLeft(h.getRight());
    node = h;
    return node;
  }

  protected NodeAVL<T> rotateSL(NodeAVL<T> node) {
    NodeAVL<T> h = node.getRight();
    node.setRight(h.getLeft());
    node = h;
    return node;
  }

  protected NodeAVL<T> rotateDR(NodeAVL<T> node) {
    NodeAVL<T> h = node.getLeft();
    node.setLeft(rotateSL(h));
    node = rotateSR(node);
    return node;

  }

  protected NodeAVL<T> rotateDL(NodeAVL<T> node) {
    NodeAVL<T> h = node.getRight();
    node.setRight(rotateSR(h));
    node = rotateSL(node);
    return node;
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
