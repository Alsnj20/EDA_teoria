package Cola;

public interface Queue<T> extends Exeption{
  void enqueue(T data);
  //Void o T, devuelve lo que esta sacando
  T dequeue() throws ExceptionIsEmpty;
  //
  T front() throws Exception;
  T back() throws Exception;
  boolean isEmpty();
}
