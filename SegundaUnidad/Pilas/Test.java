package Pilas;


public class Test {
  public static void main(String[] args) {
    Stack<Character> st = new Pila<>(0);
    try{
      st.push('a');
      st.push('b');
      st.push('c');
      System.out.println(st.toString());
      System.out.println(st.top());
      System.out.println(st.toString());
    }catch(Exception e){
      System.out.println(e.getMessage());
  }
}
}
