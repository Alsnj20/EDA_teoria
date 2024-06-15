package EjercicioR1.Tienda.listDoubleCircular;

public class TestDoubleCircular {
  public static void main(String[] args) {
    LinkedDoubleCircularList<Integer> listDC = new LinkedDoubleCircularList<>();
    listDC.add(2);
    listDC.add(3);
    listDC.add(4);
    listDC.add(5);
    listDC.add(6);
    listDC.printStartEnd();
    System.out.println(listDC);
    listDC.remove(2);
    System.out.println("Print");
    System.out.println(listDC);
    listDC.remove(6);
    System.out.println(listDC);
    System.out.println(listDC.indexOf(5));
    System.out.println(listDC.indexOf(0));
    
  }
}
