package RBT;

import java.util.*;

import BST.ItemDuplicated;


public class TreeRBT<T extends Comparable<T>> {
  protected NodeRBT<T> root;

  public TreeRBT() {
    this.root = null;
  }

  public void insert(T x) throws ItemDuplicated {
    this.root = insertNode(x, this.root);
  }

  protected NodeRBT<T> insertNode(T x, NodeRBT<T> actual) throws ItemDuplicated {
    NodeRBT<T> res = actual;
    if (actual == null) {
      res = new NodeRBT<T>(x);
      res.setColor(1);
    } else {
      // buscamos el lugar para inserción
      int resC = actual.getData().compareTo(x);
      if (resC == 0)
        throw new ItemDuplicated(x + "esta duplicado");
      if (resC < 0)
        res.setRight((insertNode(x, actual.getRight())));
      else
        res.setLeft(insertNode(x, actual.getLeft()));
      res.updateHeight();
      res.updateColor();
      res.setColor(2);
    }
    return balance(res);
  }

  protected NodeRBT<T> balance(NodeRBT<T> node) {
    int nodeFE = node.getFE();
    if (nodeFE == -2) {
      int leftFE = node.getLeft().getFE();
      if (leftFE == -1 || leftFE == 0) {
        return rotateSR(node);
      } else if (leftFE == 1) {
        return rotateDR(node);
      }
    } else if (nodeFE == 2) {
      int rightFE = node.getRight().getFE();
      if (rightFE == 1 || rightFE == 0) {
        return rotateSL(node);
      } else if (rightFE == -1) {
        return rotateDL(node);
      }
    }
    return node;
  }

  public void remove(T data) {
    this.root = remove(this.root, data);
  }

  protected NodeRBT<T> remove(NodeRBT<T> node, T data) {
    if (node == null) {
      return null;
    }
    int res = node.getData().compareTo(data);
    if (res == 0) {
      if (node.getLeft() != null && node.getRight() != null) {
        NodeRBT<T> minNode = new NodeRBT<T>(null);
        node.setRight(minRemove(node.getRight(), minNode));
        node.setData(minNode.getData());
      } else {
        node = node.getRight() != null ? node.getRight() : node.getLeft();
      }
      return node;
    } else if (res < 0) {
      node.setRight(remove(node.getRight(), data));
    } else {
      node.setLeft(remove(node.getLeft(), data));
    }
    node.updateHeight();
    return balance(node);
  }
  

  protected NodeRBT<T> minRemove(NodeRBT<T> node, NodeRBT<T> minNode) {
    if (node.getLeft() != null) {
      node.setLeft(minRemove(node.getLeft(), minNode));
      return node;
    }
    minNode.setData(node.getData());
    return node.getRight();
  }

  // Rotaciones
  protected NodeRBT<T> rotateSR(NodeRBT<T> node) {
    NodeRBT<T> h = node.getLeft();
    node.setLeft(h.getRight());
    h.setRight(node);
    node.updateHeight();
    return h;
  }

  protected NodeRBT<T> rotateSL(NodeRBT<T> node) {
    NodeRBT<T> h = node.getRight();
    //h.setColor(node.getColor());
    node.setRight(h.getLeft());
    h.setLeft(node);
    node.updateHeight();
    return h;
  }

  protected NodeRBT<T> rotateDR(NodeRBT<T> node) {
    NodeRBT<T> h = node.getLeft();
    node.setLeft(rotateSL(h));
    return rotateSR(node);
  }

  protected NodeRBT<T> rotateDL(NodeRBT<T> node) {
    NodeRBT<T> h = node.getRight();
    node.setRight(rotateSR(h));
    return rotateSL(node);
  }

  public void printListTree() {
    List<NodeRBT<T>> nodeList = new ArrayList<>();
    Queue<NodeRBT<T>> queue = new LinkedList<>();
    if (this.root != null) {
      queue.add(root);
    }
    while (!queue.isEmpty()) {
      NodeRBT<T> node = queue.poll();
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
    for (NodeRBT<T> node : nodeList) {
      if (node != null) {
        System.out.println(node.printNode());
      } else {
        System.out.println("null");
      }
    }
  }

  public void printTree() {
    List<List<String>> lines = new ArrayList<>();
    List<NodeRBT<T>> level = new ArrayList<>();
    List<NodeRBT<T>> next = new ArrayList<>();

    level.add(root);
    int nn = 1;

    int widest = 0;

    while (nn != 0) {
      List<String> line = new ArrayList<>();

      nn = 0;

      for (NodeRBT<T> n : level) {
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

      List<NodeRBT<T>> tmp = level;
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
