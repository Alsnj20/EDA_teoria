package Refuerzo;

public class Test {
  public static void main(String[] args) {
    ListaSimple<Integer> lista = new ListaSimple<>();
    lista.add(2);
    lista.add(3);
    lista.add(1);
    lista.add(5);
    System.out.println(lista);
    lista.remove(0);
    lista.remove(2);
    System.out.println(lista);
    System.out.println(lista.search(2));
    System.out.println(lista.search(0));
  }
}
