package Refuerzo;

public class TestBST {
  public static void main(String[] args) {
    BST<Integer> bst = new BST<>();
    bst.insert(5);
    bst.insert(3);
    bst.insert(2);
    bst.insert(4);
    bst.printTree();
    bst.remove(3);
    bst.remove(0);
    bst.printTree();
    System.out.println(bst.search(2));
    System.out.println(bst.search(0));    
  }
}
