package Bicola;
public class Test {
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
