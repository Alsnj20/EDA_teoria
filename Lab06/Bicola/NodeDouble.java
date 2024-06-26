package Bicola;
import ListLinked.Node;

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
}