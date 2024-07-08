package Refuerzo;

public class ArrayList<T> {
  T[] arr;
  private int size;

  @SuppressWarnings("unchecked")
  public ArrayList(int size) {
      arr = (T[]) new Object[size];
      this.size = 0;
  }

  @SuppressWarnings("unchecked")
  public void add(T data) {
      if (this.isFull()) {
          int size = arr.length;
          T[] arr = (T[]) (new Object[size * 2]);
          System.arraycopy(this.arr, 0, arr, 0, size);
          this.arr = arr;
      }
      arr[this.size++] = data;
  }

  public T get(int idx) {
      if (idx < 0 || idx >= this.size)
          throw new IndexOutOfBoundsException();
      return arr[idx];
  }

  public void set(int idx, T data) {
      if (idx < 0 || idx >= this.size)
          throw new IndexOutOfBoundsException();
      arr[idx] = data;
  }

  public int size() {
      return this.size;
  }

  public void removeLast(){
    if(size <= 0){
      System.out.println("Esta vacio");
    }else{
      arr[size--] = null;
    }
  }

  public boolean isFull() {
      return this.size == this.arr.length;
  }

  @Override
  public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("[");
      sb.append(this.arr[0]);
      for (int i = 1; i < this.size; i++) {
          sb.append(",");
          sb.append(this.arr[i]);
      }
      sb.append("]");
      return sb.toString();
  }
}

