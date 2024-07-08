import Exceptions.ItemNotFound;
public class BTree<T extends Comparable<T>> {
  private NodeB<T> root;
  private int orden;

  private boolean up;
  private NodeB<T> nDes;


  public BTree(int orden){
    this.orden = orden;
    this.root = null;
  }

  public boolean isEmpty(){
    return this.root == null;
  }


  public boolean search(T data) throws ItemNotFound{
    return searchNode(this.root, data);
  }

  private boolean searchNode(NodeB<T> actual, T data) throws ItemNotFound{
    int pos[] = new int[1];
    boolean flag;
    if(actual == null){
      throw new ItemNotFound("El elemento "+data+" no esta");
    }else{
      flag = actual.searchNode(data, pos);
      if(flag){
        System.out.println("Item "+data+" encontrado en la posicion "+pos[0]);
        return true;
      }else{
        return searchNode(actual.childs.get(pos[0]), data);
      }
    }
  }

  




  
}
