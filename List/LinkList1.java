package List;

public class LinkList1<T> implements ListIt<T>{
  protected Node<T> head;

  public LinkList1(){
    this.head = null;
  }

  public void insertFirst(T data){
    if(isEmpty()){
      this.head = new Node<T>(data);
    }else{
      Node<T> aux = new Node<T>(data);
      aux.setNext(this.head);
      this.head = aux;
    }
  }

  public void insertLast(T data){
    Node<T> node = new Node<>(data);
    if(isEmpty()){
      System.out.println("Cabeza");
      insertFirst(data);
    }else{
      Node<T> aux = this.head;
      while(aux.getNext() != null){
        aux = aux.getNext();
      }
      aux.setNext(node);
    }
  }
  public int search(T data){
    int pos = 0;
    Node<T> aux = this.head;
    while(aux != null && !aux.getData().equals(data)){
      pos++;
      aux = aux.getNext();
    }
    return (aux == null) ? -1 : pos;
  }

  public void remove(T data){
    if(isEmpty()){
      return;
    }else if(this.head.getData().equals(data)){
      this.head = this.head.getNext();
    }else{
      Node<T> aux = this.head;
      while(aux.getNext() != null && !aux.getNext().getData().equals(data)){
        aux = aux.getNext();
      }
      aux.setNext(aux.getNext().getNext());   
    }
  }
  public boolean isEmpty(){
    return this.head == null;
  }

  public String toString(){
    String str = "";
    Node<T> aux = this.head;
    while(aux != null){
      str += aux.printNode();
      aux = aux.getNext();
    }
    return str;
  }

  public Node<T> getHead(){
    return this.head;
  }
  public static void main(String[] args) {
    ListIt<Integer> list = new LinkList1<Integer>();
    list.insertFirst(1);
    System.out.println(list.toString());
    list.insertFirst(2);
    System.out.println(list.toString());
    list.insertFirst(3);
    System.out.println(list.toString());
    System.out.println("Insertando al final");
    list.insertLast(4);
    list.insertLast(6);
    System.out.println("Listado");
    System.out.println(list.toString());
    System.out.println("Buscando 4");
    System.out.println(list.search(4));
    System.out.println("Eliminando 4");
    list.remove(4);
    System.out.println(list.toString());
  }
}
