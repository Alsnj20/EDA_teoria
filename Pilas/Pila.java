package Pilas;
import List.*;
//LIFO
public class Pila<T> implements Stack<T>{

  private int tope = -1;
  private int size;
  private T[] pila;

  public Pila(int size){
    this.size = size;
    pila = (T[]) new Object[size];
  }

  public void push(T data){
    if(tope < size-1){
      tope++;
      pila[tope] = data;
    }
  }

  public T pop(){
    return null;
  }
  public T top(){
    return null;
  }
  public boolean isEmpty(){
    return true;
  }

  public String toString(){
    return "";
  }


  
}
