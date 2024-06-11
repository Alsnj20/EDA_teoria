package AVL;

public class TestAVL {
  public static void main(String[] args) {
    AVL<Integer> avl = new AVL<>();
    try {
      avl.insert(10);
      avl.insert(5);
      avl.insert(15);
      avl.insert(3);
      avl.printTree();
      avl.insert(12);
      avl.printTree();
      avl.insert(17);
      avl.printTree();
      System.out.println("Eliminando el 3");
      avl.remove(3);
      avl.printTree();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
