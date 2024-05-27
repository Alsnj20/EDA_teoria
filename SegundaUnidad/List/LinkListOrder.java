package List;

import java.util.Comparator;

public class LinkListOrder<T extends Comparable<T>> extends LinkList1<T> {

  public LinkListOrder() {
    super();
  }

  public void insertFirstLast(T data) {
    Node<T> node = new Node<>(data);
    if (isEmpty()) {
      this.head = node;
    } else if (this.head.getNext() == null && this.head.getData().compareTo(node.getData()) > 0){
      node.setNext(this.head);
      this.head = node;
    } else {
      Node<T> aux = this.head;
      while (aux.getNext() != null && aux.getNext().getData().compareTo(node.getData()) < 0) {
        aux = aux.getNext();
      }
      node.setNext(aux.getNext());      
      aux.setNext(node);
    }
  }

  public String toString() {
    String str = "";
    Node<T> aux = this.head;
    while (aux != null) {
      str += aux.printNode();
      aux = aux.getNext();
    }
    return str;
  }
  /* Metodo auxiliar */
  public void ordenar(){
    
  }

  public int search(T data){
    int pos = 0;
    Node<T> aux = this.head;
    while(aux != null && aux.getData().compareTo(data) < 0){
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
      while(aux.getNext() != null && aux.getNext().getData().compareTo(data) < 0){
        aux = aux.getNext();
      }
      if(aux.getNext() != null && aux.getNext().getData().equals(data)){
        aux.setNext(aux.getNext().getNext());
      } 
    }
  }



  public static void main(String[] args) {
    LinkListOrder<Integer> list = new LinkListOrder<>();
    list.insertFirstLast(1);
    list.insertFirstLast(5);
    list.insertFirstLast(2);
    list.insertFirstLast(4);
    System.out.println(list.toString());
    /*Remove */
    System.out.println("Remove 3");
    list.remove(3);
    System.out.println("List: ");
    System.out.println(list.toString());
  }
}
