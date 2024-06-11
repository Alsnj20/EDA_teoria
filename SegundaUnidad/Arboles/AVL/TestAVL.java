package AVL;

public class TestAVL {
  public static void main(String[] args) {
    System.out.println("AVL Tree");
    TreeAVL<Integer> avl = new TreeAVL<>();
    try {
      avl.insert(10);
      avl.insert(15);
      avl.insert(3);
      avl.insert(4);
      avl.insert(7);
      avl.printTree();
      System.out.println("removemos");
      System.out.println("Remove 15");
      avl.remove(15);
      avl.printTree();
      System.out.println("Remove 3");
      avl.remove(3);
      avl.printTree();
      System.out.println("Remove 4");
      avl.remove(4);
      avl.printTree();
      System.out.println("Remove 7");
      avl.remove(7);
      avl.printTree();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}

