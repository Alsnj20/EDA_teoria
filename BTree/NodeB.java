import java.util.ArrayList;

public class NodeB<T extends Comparable<T>> {
  protected ArrayList<T> keys;
  protected ArrayList<NodeB<T>> childs;
  protected int count;

  public NodeB(int count){
    this.keys = new ArrayList<>(count);
    this.childs = new ArrayList<>(count);
    this.count = count;
    for (int i = 0; i < count; i++) {
      this.keys.add(null);
      this.childs.add(null);    
    }
  }

  public boolean nodeFull(int orden){
    return count == orden - 1;
  }

  public int getMinKeys(int orden){
    return (int) Math.ceil(orden/2*1.0) - 1;
  }

  // Es un nodo hoja
  public boolean nodeEmpty(){
    for (int i = 0; i < this.keys.size(); i++) {
      if(this.keys.get(i) != null){
        return false;
      }
    }
    return true;
  }

  // Buscando por niveles
  public boolean searchNode(T data, int[] pos){
    for (int i = 0; i < this.keys.size(); i++) {
      if(this.keys.get(i) != null){
        if(this.keys.get(i).compareTo(data) == 0){
          pos[0] = i;
          return true;
        }else if(this.keys.get(i).compareTo(data) > 0){
          pos[0] = i;
          return false;
        }
      }
    }
    pos[0] = this.keys.size();
    return false;
  }

  public String toString() {
    return "NodeB{" + "keys=" + keys + ", count=" + count + '}';
  }
}
