package Refuerzo;

public class Heap<T extends Comparable<T>> {
  private T[] a;
  private int count;

  public Heap(int size) {
    a = (T[]) new Comparable[size];
  }

  // raiz: Math.floor(i/2)
  // hijo der 2*i+1;
  // hijo izq 2+i

  public void insert(T item) {
    if(count <= a.length){
    a[count] = item;
    for (int i = count; i > 0 && a[i].compareTo(a[i / 2]) < 0 ; i/= 2) {
      swap(i, i/2);
    }
    count++;
    }else{
      T[] aa = (T[]) new Comparable[count*2];
      for (int i = 0; i <= count; i++) {
        aa[i] = a[i];
      }
      this.a = aa;
    }
  }

  public void eliminar(T a[]) {
    T m = a[1];
    a[1] = a[count--];
    int j = 1;
    while (2 * j < count) {
      int k = 2 * j; // el hijo izquierdo
      if (k + 1 <= count && a[k + 1].compareTo(a[k]) > 0)
        k = k + 1; // el hijo derecho es el mayor
      if (a[j].compareTo(a[k]) > 0)
        break; // es mayor que ambos hijos
      T t = a[j];
      a[j] = a[k];
      a[k] = t;
      j = k; // lo intercambiamos con el mayor hijo
    }
  }

  private void swap(int i, int j) {
    T temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public void printHeap() {
    for (int i = 0; i < count; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Heap<Integer> heap = new Heap<>(20);
    heap.insert(16);
    heap.insert(2);
    heap.insert(8);
    heap.insert(7);
    heap.insert(9);
    heap.insert(3);
    heap.insert(14);
    heap.insert(10);
    heap.printHeap();
    heap.insert(15);
    heap.printHeap();
  }
}
