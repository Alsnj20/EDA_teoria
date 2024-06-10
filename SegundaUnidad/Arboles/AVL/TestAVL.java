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
      avl.insert(4);
      avl.printTree();
      avl.printListTree();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
