package Interfaces;

import Pilas.ExceptionIsEmpty;

//LIFO
public interface Stack<T> {
  void push(T data);
  T pop() throws ExceptionIsEmpty;
  T top() throws ExceptionIsEmpty; 
  boolean isEmpty(); 
}
