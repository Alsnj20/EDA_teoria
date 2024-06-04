package Cola;

import Pilas.ExceptionIsEmpty;

public class QueueArray<T> implements Queue<T> {
  private T[] queue;
  private int front;
  private int back;
  private int count;

  public QueueArray(int size) {
    this.queue = (T[]) new Object[size];
    this.front = 0;
    this.back = -1;
  }

  // Agregar un elemento al final
  public void enqueue(T data) {
    if (isFull()) {
      int size = this.queue.length;
      T[] queue2 = (T[]) new Object[size * 2];
      for (int i = 0; i < size; i++) {
        queue2[i] = this.queue[(front + i) % this.queue.length];
      }
      this.queue = queue2;
      this.front = 0;
      this.back = size - 1;
    }
    back = (back + 1) % queue.length;
    queue[back] = data;
    count++;
  }

  // Quitamos el primer elemento en entrar
  public T dequeue() throws ExceptionIsEmpty {
    if (!isEmpty()) {
      T data = queue[front];
      front = (front + 1) % queue.length;
      count--;
      return data;
    } else {
      throw new ExceptionIsEmpty("Queue is empty");
    }
  }

  // Primer elemento en entrar
  public T front() throws ExceptionIsEmpty {
    if (!isEmpty()) {
      return queue[front];
    } else {
      throw new ExceptionIsEmpty("Queue is empty");
    }
  }

  // Ultimo elemento en entrar
  public T back() throws ExceptionIsEmpty {
    if (!isEmpty()) {
      return queue[back];
    } else {
      throw new ExceptionIsEmpty("Queue is empty");
    }
  }

  public boolean isEmpty() {
    return (count == 0);
  }

  public boolean isFull() {
    return (count == this.queue.length);
  }

  public String toString() {
    String result = "";
    for (int i = 0; i <= back-front; i++) {
      result += queue[(front + i) % this.queue.length] + " ";
    }
    return result;
  }

  public static void main(String[] args) {
    QueueArray<Integer> queue = new QueueArray<>(2);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    System.out.println(queue.toString());
    try {
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.toString());
      System.out.println(queue.front());
      System.out.println(queue.back());
      System.out.println(queue.toString());
    } catch (ExceptionIsEmpty e) {
      System.out.println(e.getMessage());
    }
  }
}
