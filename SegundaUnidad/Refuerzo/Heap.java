package Refuerzo;

public class Heap<T extends Comparable<T>> {
  private ArrayList<T> arr;
  private T[] a;

  public Heap(int size) {
    arr = new ArrayList<>(size);
    a = (T[]) new Comparable[size];
    arr.add(null);
  }

  public void push(T data) {
    arr.add(data);
    int i = arr.size() - 1;
    while (i > 1 && arr.get(i).compareTo(arr.get(i / 2)) > 0) {
      swap(i, i / 2);
      i /= 2;
    }
  }

  public void pop() {
    if (arr.size() <= 1) {
      System.out.println("Esta vacio");
    }
    T max = arr.get(1);
    int size = arr.size() - 1;
    arr.set(1, arr.get(size));
    arr.removeLast();
    size--;
    int i = 1;

    while (2 * i <= size) {
      int child = 2 * i;
      if (child + 1 <= size && arr.get(child + 1).compareTo(arr.get(child)) > 0) {
        child += 1;
      }
      if (arr.get(i).compareTo(arr.get(child)) > 0)
        break;
      swap(i, child);
      i = child;
    }
  }

  public void swap(int i, int j) {
    T tempo = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, tempo);
  }

  public String toString() {
    return arr.toString();
  }

  public static void main(String[] args) {
    Heap<Integer> heapmax = new Heap<>(20);
    heapmax.push(14);
    heapmax.push(13);
    heapmax.push(16);
    heapmax.push(12);
    System.out.println(heapmax);
    heapmax.pop();
    heapmax.pop();
    System.out.println(heapmax);
  }
}
