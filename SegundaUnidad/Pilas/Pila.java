package Pilas;

//LIFO
public class Pila<T>implements Stack<T> {

  private int tope;
  private int size;
  private T[] pilaArray;

  public Pila(int size) {
    this.size = size;
    this.pilaArray = (T[]) new Object[size];
    this.tope = 0;
  }

  public void push(T data){
    if (!isFull()) {
      this.pilaArray[tope] = data;
      this.tope++;
    } else {
      T[] pilaArray2 = (T[]) new Object[this.size * 2];
      this.pilaArray = pilaArray2;
    }
  }

  public T pop() {
    if (!isEmpty()) {
      T data = this.pilaArray[this.tope];
      this.pilaArray[this.tope] = null;
      this.tope--;
      return data;
    }
    return null;
  }

  public T top() {
    if (isEmpty()) {
      return (T) this.pilaArray[this.tope];
    }
    return null;
  }

  public boolean isEmpty() {
    return this.tope == 0;
  }

  public boolean isFull() {
    return this.tope == this.pilaArray.length - 1;
  }

  public String toString() {
    String str = "";
    for (int i = this.tope; i >= 0; i--) {
      if (this.pilaArray[i] != null) {
        str += this.pilaArray[i] + "\n";
      }
    }
    return str;
  }

}
