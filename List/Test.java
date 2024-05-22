package List;

public class Test {
  public static void main(String[] args) {
    ListIt<Integer> list = new LinkList<Integer>();
    list.insertFirst(1);
    System.out.println(list.toString());
    list.insertFirst(2);
    System.out.println(list.toString());
    list.insertFirst(3);
    list.insertLast(5);
    System.out.println(list.toString());
    System.out.println("Eliminado");
    list.remove(1);
    System.out.println(list.toString());
  }
}
