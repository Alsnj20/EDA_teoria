package EJERCICIO_6;

import java.util.ArrayList;

public class ArrayListNumber {
  private ArrayList<Caja<Integer>> array;

  public ArrayListNumber() {
    array = new ArrayList<>();
  }

  public void meter(String color, int n) {
    if (array.size() < 10) {
      Caja<Integer> caja = new Caja<>(color);
      caja.pon(n);
      array.add(caja);
    }else{
      System.out.println("Error: Capacidad Limitada, no hay espacio");
    }

  }

  public void recorre(String color) {
    for (Caja<Integer> caja : array) {
      if (caja.obtenerColor().equals(color)) {
        System.out.println(caja);
      }
    }
  }

  /* Inserción ascendente(menor a mayor) */
  
  public void ordenar() {
    for (int i = 1; i < array.size(); i++) {
      Caja<Integer> item = array.get(i);
      int j = i - 1;
      while (j >= 0 && array.get(j).dame() > item.dame()) {
        array.set(j + 1, array.get(j));
        j--;
      }
      array.set(j + 1, item);
    }
  }

  /* Color de la caja con elemento menor */
  public String mayor() {
    ordenar();
    return array.get(0).obtenerColor();
  }

  public String toString(){
    String data = "";
    for (Caja<Integer> caja : array) {
      data += caja+"\n";
    }
    return data;
  }
}
