package TreeRBT;


public class TestRBT {
  public static void main(String[] args) {
    TreeRBT<Integer> rbt = new TreeRBT<Integer>();
    try{
      rbt.insert(10);
      rbt.insert(20);
      rbt.insert(30);
      rbt.insert(15);
      rbt.printTree();
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
}
