package Pilas;

import Interfaces.Stack;
import Utilidades.Node;

public class StackList<T> implements Stack<T> {
  private Node<T> tope;

  public StackList() {
    this.tope = null;
  }

  public void push(T data) {
    Node<T> aux = new Node<T>(data);
    aux.setNext(this.tope);
    this.tope = aux;
  }

  public T pop() throws ExceptionIsEmpty {
    if (!isEmpty()) {
      T data = this.tope.getData();
      this.tope = this.tope.getNext(); // tope == null;
      return data;
    }
    return null;
  }

  public T top() throws ExceptionIsEmpty {
    return (!isEmpty()) ? this.tope.getData() : null;
  }

  public boolean isEmpty() {
    return (this.tope == null);
  }

  // this method is not used, because the stack is never full
  /*
   * public boolean isFull(){
   * return this.tope.getNext() == null;
   * }
   */

  public String toString() {
    String str = "";
    Node<T> aux = this.tope;
    while (aux != null) {
      str += aux.printNode();
      aux = aux.getNext();
    }
    return str;
  }

  public static void main(String[] args) {
    Stack<Character> st = new StackList<>();
    try {
      st.push('a');
      st.push('b');
      st.push('c');
      System.out.println(st.toString());
      System.out.println("Top: ");
      System.out.println(st.top());
      System.out.println(st.toString());
      System.out.println("Pop: ");
      System.out.println(st.pop());
      System.out.println(st.toString());
    } catch (ExceptionIsEmpty e) {
      System.out.println(e.getMessage());
    }
  }
}
