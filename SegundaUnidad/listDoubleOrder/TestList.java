package listDoubleOrder;

public class TestList {
  public static void main(String[] args) {
    LinkedDoubleList<Integer> list = new LinkedDoubleList<>();
    list.add(1);
    list.add(-1);
    list.add(2);
    list.add(-2);
    System.out.println("Lista Cantidad: "+list.length());
    System.out.println(list.toString());
    System.out.println("Eliminar 1");
    list.remove(-1);
    System.out.println("Lista Cantidad: "+list.length());
    System.out.println(list.toString());
    System.out.println("El 2 se encuentra en la lista :"+list.contains(2));
    System.out.println("El 2 esta posicion de la lista :"+list.indexOf(2));
    System.out.println("El 3 se encuentra en la lista :"+list.indexOf(3));
    System.out.println("Inicializar lista otra vez");
    list.initializeList();
    list.add(3);
    list.add(-3);
    System.out.println(list.toString());
  }
}
