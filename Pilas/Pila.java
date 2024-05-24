package Pilas;
import List.*;
//LIFO
public class Pila<T> implements Stack<T>{

  private int tope;
  private int size;
  private T[] pilaArray;

  public Pila(int size){
    this.size = size;
    this.pilaArray = (T[]) new Object[size];
    this.tope = -1;
  }

  public void push(T data){
    if(!isFull()){
      /*tope++;
      pilaArray[tope] = data;*/
      pilaArray[++tope] = data;
    }else{
      T[] pilaArray2 = (T[]) new Object[this.size*2];
      this.pilaArray = pilaArray2;    
    }
  }

  public T pop(){
    return null;
  }
  public T top(){
    if(isEmpty())
    return this.pilaArray[this.tope];
  }
  public boolean isEmpty(){
    return this.tope == -1;
  }

  public boolean isFull(){
    return this.tope == this.pilaArray.length-1;
  }

  public String toString(){
    String str = "";
    for (int i = this.tope; i >= 0; i--) {
      if(this.pilaArray[i] != null){
        str += this.pilaArray[i] + "\n";
      }
    }
    return str;
  }


  
}
