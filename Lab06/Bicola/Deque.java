package Lab06.Bicola;
public class Deque<T extends Comparable<T>> implements TDADeque<T>{
  private NodeDouble<T> last;
  private NodeDouble<T> first;
  private int count;
  public Deque(){
    first = null;
    last = null;
  }

  public void agregarFrente(T x){
    NodeDouble<T> newNode = new NodeDouble<T>(x);
    if (this.first == null){
      this.first = newNode;
      this.last = newNode;
    }else{
      newNode.setNext(this.first);
      this.first.setBack(newNode);
      this.first = newNode;
    }
    this.count++;
  }

  public void agregarFinal(T x){
    NodeDouble<T> newNode = new NodeDouble<T>(x);
    if (this.last == null){
      this.first = newNode;
      this.last = newNode;
    }else{
      newNode.setBack(this.last);
      this.last.setNext(newNode);
      this.last = newNode;
    }
    this.count++;
  }

  public T removerFrente(){
    NodeDouble<T> temp = this.first;
    this.first = this.first.getNext();
    this.count--;
    return temp.getData();
  }

  public T removerFinal(){
    NodeDouble<T> temp = this.last;
    this.last = this.last.getBack();
    this.count--;
    return temp.getData();
  }

  public boolean estaVacia(){
    return this.first == null && this.last == null && this.count == 0; 
  }

  public int tamano(){
    return count;
  }
}