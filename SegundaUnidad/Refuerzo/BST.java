package Refuerzo;

import java.util.ArrayList;
import java.util.List;

import TreeBST.NodeBST;

public class BST<T extends Comparable<T>> {
  NodeBST<T> root;

  public BST() {
    root = null;
  }

  public void insert(T data){
    System.out.println("Root: "+this.root);
    this.root = insertNode(this.root, data);
    System.out.println("Root: "+this.root);
  }

  public NodeBST<T> insertNode(NodeBST<T> actual, T data){
    NodeBST<T> res = actual;
    if(actual == null){
      res = new NodeBST<T>(data);
      System.out.println(res.printNode());
    }else{
      int resc = actual.getData().compareTo(data);
      if(resc == 0){
        System.out.println("Elemento duplicado");
      }else if(resc > 0){
        res.setLeft(insertNode(actual.getLeft(), data));
      }else{
        res.setRight(insertNode(actual.getRight(), data));
      }
    }
    return res;
  }

  public  T search (T x){
    NodeBST<T> res = searchNode(this.root, x);
    System.out.println(res.printNode());
    return res == null? null:res.getData();
  }

  public NodeBST<T> searchNode(NodeBST<T> actual, T x){
    if(actual == null){
      System.out.println("No esta");
      return null;
    }else{
      int resC = actual.getData().compareTo(x);
      if(resC > 0){
        return (searchNode(actual.getLeft(), x));
      }else if( resC < 0){
        return searchNode(actual.getRight(), x);
      }else{
        System.out.println(actual.printNode());
        return actual;
      }
    }
  }

  public void remove(T x){
    this.root = removeNode(this.root, x);
  }

  public NodeBST<T> removeNode(NodeBST<T> actual, T x){
    NodeBST<T> res = actual;
    if(actual == null){
      System.out.println("No se encontro el elemento: "+x);
    }else{
      int resC = actual.getData().compareTo(x);
      if(resC > 0){
        res.setLeft(removeNode(actual.getLeft(), x));
      }else if(resC < 0){
        res.setRight(removeNode(actual.getRight(), x));
      }else{//si lo encontro
        if(actual.getLeft() != null && actual.getRight() != null){
          T min = minRemove();
          res.setData(min);
        }else{
          res = (actual.getLeft() != null)?actual.getLeft():actual.getRight();
        }
      }
    }
    return res;
  }

  public T minRemove(){
    NodeBST<T> minNode = new NodeBST<>(null);
    this.root = minRemoveDelete(this.root, minNode);
    return minNode.getData();
  }

  public NodeBST<T> minRemoveDelete(NodeBST<T> actual, NodeBST<T> minNode){
    if(actual.getLeft() != null){
      actual.setLeft(minRemoveDelete(actual.getLeft(), minNode));
    }else{
      minNode.setData(actual.getData());
      actual = actual.getRight();
    }
    return actual;
  }

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
}
