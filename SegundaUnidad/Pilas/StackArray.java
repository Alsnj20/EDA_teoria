package SegundaUnidad.Pilas;

public class StackArray<T> implements Stack<T>{
  private int tope;
  private int size;
  private T[] pila;

  public StackArray(int size){
    this.size = size;
    pila = (T[]) new Object[size];
    this.tope = -1;
  }

  public void push(T data) {
    if(!isFull()){
      this.pila[++tope] = data;
    }else{
      T[] pila2 = (T[]) new Object[this.size * 2];
      for (int i = 0; i < this.size; i++) {
        pila2[i] = this.pila[i];
      }
      this.pila = pila2;
    }
  }

  public T pop() throws ExceptionIsEmpty {
    if(!isEmpty()){
      T data = this.pila[this.tope];
      this.pila[this.tope] = null;
      this.tope--;
      return data;
    }
    return null;
  }

  public T top() throws ExceptionIsEmpty {
    if(!isEmpty()){
      return this.pila[this.tope];
    }
    return null;
  }

  public boolean isEmpty() {
    return (this.tope == -1);
  }

  public boolean isFull() {
    return (this.tope == this.pila.length - 1);
  }

  public String toString(){
    String str = "";
    for (int i = this.tope; i >= 0; i--) {
      if (this.pila[i] != null) {
        str += this.pila[i] + "\n";
      }
    }
    return str;
  }

  public static void main(String[] args) {
    StackArray<Integer> pila = new StackArray<>(5);
    try {
      pila.push(1);
      pila.push(2);
      pila.push(3);
      pila.push(4);
      pila.push(5);
      pila.push(6);
      System.out.println(pila.toString());
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
}


