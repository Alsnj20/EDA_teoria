package Cola;

import Pilas.*;

public interface Queue<T>{
  void enqueue(T data);
  //Void o T, devuelve lo que esta sacando
  T dequeue() throws ExceptionIsEmpty;
  //
  T front() throws Exception;
  T back() throws Exception;
  boolean isEmpty();
}
