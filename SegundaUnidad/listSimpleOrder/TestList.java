package listSimpleOrder;

public class TestList {
  public static void main(String[] args) {
    OrderLinkedList<Integer> list = new OrderLinkedList<>();
    list.add(5);
    list.add(3);
    list.add(7);
    list.add(1);
    list.add(9);
    System.out.println(list.toString());
    System.out.println("Lista despues de eliminar");
    list.remove(5);
    list.remove(3);
    list.remove(7);
    list.remove(1);
    System.out.println(list.toString());
    System.out.println("Elemento 9 se encuentra en la posición: "+list.indexOf(9));
    System.out.println("Elemento 8 se encuentra en la posición: "+list.indexOf(8));
    System.out.println("Inicializando lista");
    list.initializeList();
    list.add(2);
    list.add(6);
    System.out.println(list.toString());
  }
}
