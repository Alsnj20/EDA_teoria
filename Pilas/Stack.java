package Pilas;

public interface Stack<T> {
  void push(T data);
  T pop() throws Exception;
  T top() throws Exception; 
  boolean isEmpty(); 
}
