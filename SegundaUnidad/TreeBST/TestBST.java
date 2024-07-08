package TreeBST;

public class TestBST {
  public static void main(String[] args) {
    BSTree<Integer> arbol = new BSTree<Integer>();
    try {
      arbol.insert(18);
      arbol.insert(10);
      arbol.insert(20);
      arbol.insert(5);
      arbol.insert(13);
      arbol.insert(7);
      arbol.insert(19);
      /*System.out.println("Recorrido en preorden");
      //System.out.println(arbol.preOrder());
      System.out.println("Recorrido en inorden");
      System.out.println(arbol.inOrder());
      System.out.println("Recorrido en postorden");
      System.out.println(arbol.postOrder());
      System.out.println("Arbol");
      arbol.printTree();
      System.out.println("Eliminando el 5");
      arbol.remove(5);
      System.out.println("Arbol");
      arbol.printTree();
      System.out.println("Eliminando el 15");
      arbol.remove(15);
      System.out.println("Arbol");
      arbol.printTree();
      System.out.println("Eliminando el 10");
      arbol.remove(10);
      System.out.println("Arbol");
      arbol.printTree();
      System.out.println("Eliminando el 1");
      arbol.remove(1);
      System.out.println("Arbol");
      arbol.printTree();
      System.out.println("Eliminando el 18");
      arbol.remove(18);
      System.out.println("Arbol");
      arbol.printTree();
      System.out.println("Eliminando el 13");
      arbol.remove(13);
      System.out.println("Arbol");
      arbol.printTree();
      System.out.println("Eliminando el 11");
      arbol.remove(11);*/
      System.out.println("Arbol");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally{
      arbol.printTree();
      //System.out.println(arbol.calcularEMC());
      System.out.println("Nodos Internos");
      System.out.println(arbol.countNodes());
    }
  }
}
