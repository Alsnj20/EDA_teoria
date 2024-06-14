package EjercicioR1.listDouble;

import EjercicioR1.listSimple.Node;

public class NodeDouble<T> extends Node<T> {
  protected NodeDouble<T> back;

  public NodeDouble(T data) {
    super(data);
    this.back = null;
  }

  public NodeDouble(T data, NodeDouble<T> next, NodeDouble<T> back) {
    super(data, next);
    this.back = back;
  }

  public NodeDouble<T> getNext(){
    return (NodeDouble<T>) super.getNext();
  }

  public NodeDouble<T> getBack() {
    return this.back;
  }

  public void setBack(NodeDouble<T> back) {
    this.back = back;
  }

  public String printNode(){
    return "{back:"+getBack()+", value:"+getData()+", next:"+getNext()+"}";  
  }

  public static void main(String[] args) {
    NodeDouble<Integer> node1 = new NodeDouble<Integer>(1);
    NodeDouble<Integer> node2 = new NodeDouble<Integer>(2);
    NodeDouble<Integer> node3 = new NodeDouble<Integer>(3);
    node1.setNext(node2);
    node2.setNext(node3);
    node3.setBack(node2);
    node2.setBack(node1);
    System.out.println(node1.printNode());
    System.out.println(node2.printNode());
    System.out.println(node3.printNode());
  }
}