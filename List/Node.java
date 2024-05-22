package List;

public class Node<T>{
  private T data;
  private Node<T> next;
  public Node(T data){
    this(data, null);
  }
  public Node(T data, Node<T> next){
    this.data = data;
    this.next = next;
  }
  /* Setter and Getter */
  public void setData(T data){
    this.data = data;
  }
  public void setNext(Node<T> next){
    this.next = next;
  }
  public T getData(){
    return data;
  }
  public Node<T> getNext(){
    return next;
  }

  public String toString(){
    return this.data.toString();
  }
  public String printNode(){
    return "{value:"+this.data.toString()+", enlace:"+this.next+"}";  
  }
  public static void main(String[] args) {
    Node<Integer> node = new Node<Integer>(1);
    System.out.println(node.printNode());
    Node<Integer> node2 = new Node<Integer>(2, node);
    //node2.setNext(node);
    System.out.println(node2.printNode());
    Node<Integer> node3 = new Node<Integer>(3,node2);
    System.out.println(node3.printNode());
  }
}