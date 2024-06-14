package EjercicioR1.Tienda;
import java.util.ArrayList;
import java.util.Scanner;

import EjercicioR1.Tienda.listDoubleCircular.LinkedDoubleCircularList;

public class Store{
  LinkedDoubleCircularList<Producto> dictProduct;

  public Store(){
    dictProduct = new LinkedDoubleCircularList<>();
  }

  /*Methods*/

  public void comprarProducto(Producto p){
    int n = dictProduct.indexOf(p);
    if(n == -1){
      dictProduct.add(p);
      System.out.println("Producto comprado: "+p);
    }else{
      dictProduct.get(n).increaseStock();
      System.out.println("Producto comprado: "+p);
    }
  }

  public void venderProducto(Producto p){
    int n = dictProduct.indexOf(p);
    if(n != -1){
      if(p.getStock() == p.getStockMin()){
        p.setEsSuficiente(false);
      }else{
        p.decreaseStock();
      }
      System.out.println("Producto vendido: "+p);
    }
  }

  public void darBajaProducto(Producto p){
    int n = dictProduct.indexOf(p);
    if(n != -1){
      if(p.getStock() == p.getStockMin()){
        System.out.println("Producto dado de baja: "+p);
        dictProduct.remove(p);
      }
    }
  }

  public void generarReportes(){
    System.out.println("-----------Generar Reportes-----------");
    System.out.println("1.Reporte de productos por estado");
    System.out.println("2.Reporte de los productos mas vendidos");
    Scanner sc = new Scanner(System.in);
    int option = sc.nextInt();
    switch (option) {
      case 1:
        break;
      case 2:
        break;
      default:
        System.out.println("Ingrese una opcion valida");
        break;
    } 
  }

  protected void verProductosEstado(){
    ArrayList<Producto> suficiente = new ArrayList<>();
    ArrayList<Producto> insuficiente = new ArrayList<>();
    for (int i = 0; i < dictProduct.length(); i++) {
      Producto p = dictProduct.get(i);
      if(p.esSuficiente()){
        suficiente.add(p);
      }else{
        insuficiente.add(p);
      }
    }
    System.out.println("-------Producto-Estado-------");
    System.out.println("Suficiente");
    print(suficiente);
    System.out.println("Insuficiente");
    print(insuficiente);
  }

  protected void print(ArrayList<Producto> arr){
    for(Producto p: arr){
      System.out.println(p);
    }
  }

  public static void main(String[] args) {
    Store store = new Store();
    Producto p1 = new Producto("1", "Producto 1", 10, 5);
    Producto p2 = new Producto("2", "Producto 2", 10, 5);
    Producto p3 = new Producto("3", "Producto 3", 10, 5);
    Producto p4 = new Producto("4", "Producto 4", 10, 5);
    Producto p5 = new Producto("5", "Producto 5", 10, 5);
    store.comprarProducto(p1);
    store.comprarProducto(p2);
    store.comprarProducto(p3);
    store.comprarProducto(p4);
    store.comprarProducto(p5);
    store.venderProducto(p1);
    store.venderProducto(p2);
    store.venderProducto(p3);
    store.venderProducto(p4);
    store.venderProducto(p5);
    store.verProductosEstado();
  }
}