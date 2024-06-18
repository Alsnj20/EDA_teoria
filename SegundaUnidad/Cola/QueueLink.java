package Cola;
import Interfaces.Queue;
import Utilidades.Node;
import Pilas.ExceptionIsEmpty;

public class QueueLink<T> implements Queue<T>{
  private Node<T> first;
  private Node<T> last;

  public QueueLink(){
    this.first = this.last = null;
  }

  public void enqueue(T data){
    Node<T> node = new Node<>(data);
    if(isEmpty()){
      this.first = node;
    }else{
      this.last.setNext(node);
    }
    this.last = node;
  }

  public T dequeue() throws ExceptionIsEmpty{
    if(isEmpty()){
      throw new ExceptionIsEmpty("Queue is empty");
    }
    this.first = this.first.getNext();
    if(this.first == null){
      this.last = null;
    }
    T data = this.first.getData();
    this.first = this.first.getNext();
    return data;
  }

  public T front() throws ExceptionIsEmpty{
    if(isEmpty()){
      throw new ExceptionIsEmpty("Queue is empty");
    }
    return this.first.getData();
  }

  public T back() throws ExceptionIsEmpty{
    if(isEmpty()){
      throw new ExceptionIsEmpty("Queue is empty");
    }
    return this.last.getData();
  }

  public boolean isEmpty(){
    return this.first == null;
  }

  public String toString(){
    String result = "";
    Node<T> aux = this.first;
    while(aux != null){
      result += aux.printNode();
      aux = aux.getNext();
    }
    return result;
  }

  public static void main(String[] args) {
    Queue<Character> q = new QueueLink<>();
    try{
      q.enqueue('a');
      q.enqueue('b');
      q.enqueue('c');
      System.out.println(q.toString());
      System.out.println(q.front());
      System.out.println(q.back());
      System.out.println(q.toString());
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
  
}
