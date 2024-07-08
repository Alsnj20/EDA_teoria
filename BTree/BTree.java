import Exceptions.ItemNotFound;
import ListLinked.Node;

public class BTree<T extends Comparable<T>> {
  private NodeB<T> root;
  private int orden;

  private boolean up;
  private NodeB<T> nDes;

  public BTree(int orden) {
    this.orden = orden;
    this.root = null;
  }

  public boolean isEmpty() {
    return this.root == null;
  }

  public void insert(T data) throws ItemNotFound {
    this.up = false;
    T mediana;
    NodeB<T> node;
    mediana = push(this.root, data);

    // Estamos arriba
    if (this.up) {
      node = new NodeB<>(this.orden);
      node.count = 1;
      node.keys.set(0, mediana);
      node.childs.set(0, this.root);
      node.childs.set(1, this.nDes);
      this.root = node;
    }
  }

  private T push(NodeB<T> actual, T data) throws ItemNotFound {
    int pos[] = new int[1];
    T mediana;
    if (actual == null) {
      this.up = true;
      this.nDes = null;
      return data;
    } else {
      boolean flag;
      flag = actual.searchNode(data, pos);
      if (flag) {
        this.up = false;
        throw new ItemNotFound("Item duplicado");
      }
      mediana = push(actual.childs.get(pos[0]), data);
      if (this.up) {
        if (actual.nodeFull(this.orden - 1)) {
          mediana = dividedNode(actual, mediana, pos[0]);
        } else {
          this.up = false;
          putNode(actual, mediana, nDes, pos[0]);
        }
      }
      return mediana;
    }
  }

  private void putNode(NodeB<T> actual, T data, NodeB<T> des, int k) {
    for (int i = actual.count - 1; i >= k; i--) {
      actual.keys.set(i + 1, actual.keys.get(i));
      actual.childs.set(i + 2, actual.childs.get(i + 1));
    }
    actual.keys.set(k, data);
    actual.childs.set(k + 1, des);
    actual.count++;
  }

  private T dividedNode(NodeB<T> actual, T data, int k) {
    NodeB<T> aux = this.nDes;
    int posMdna = (k <= this.orden / 2) ? this.orden / 2 : this.orden / 2 + 1;
    this.nDes = new NodeB<>(this.orden);
    for (int i = posMdna; i < this.orden - 1; i++) {
      this.nDes.keys.set(i - posMdna, actual.keys.get(i));
      this.nDes.childs.set(i - posMdna + 1, actual.childs.get(i + 1));
    }
    this.nDes.count = (this.orden - 1) - posMdna;
    actual.count = posMdna;

    if (k <= this.orden / 2) {
      putNode(actual, data, aux, k);
    } else {
      putNode(this.nDes, data, aux, k - posMdna);
    }

    T median = actual.keys.get(actual.count - 1);
    this.nDes.childs.set(0, actual.childs.get(actual.count));
    actual.count--;
    return median;
  }

  public boolean search(T data) throws ItemNotFound {
    return searchNode(this.root, data);
  }

  private boolean searchNode(NodeB<T> actual, T data) throws ItemNotFound {
    int pos[] = new int[1];
    boolean flag;
    if (actual == null) {
      throw new ItemNotFound("El elemento " + data + " no esta");
    } else {
      flag = actual.searchNode(data, pos);
      if (flag) {
        System.out.println("Item " + data + " encontrado en la posicion " + pos[0]);
        return true;
      } else {
        return searchNode(actual.childs.get(pos[0]), data);
      }
    }
  }

  public String toString() {
    String str = "";
    if (isEmpty()) {
      str += "BTree is empty";
    } else {
      str += writeTree(this.root);
    }
    return str;
  }

  private String writeTree(NodeB<T> actual) {
    int i;
    String s = "";
    if (actual != null) {
      s += actual.toString() + "\n";
      for (i = 0; i <= actual.count; i++)
        s += writeTree(actual.childs.get(i));
    }
    return s;
  }
}
