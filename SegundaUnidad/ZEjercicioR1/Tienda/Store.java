package ZEjercicioR1.Tienda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Exceptions.ItemDuplicated;
import Exceptions.ItemNotFound;
import TreeDict.DictionaryBST;
import TreeDict.EntryDict;
import listDoubleCircular.LinkedDoubleCircularList;

public class Store {
  DictionaryBST<String, Producto> dictProduct;
  LinkedDoubleCircularList<Producto> ventas;

  public Store() {
    dictProduct = new DictionaryBST<>();
    ventas = new LinkedDoubleCircularList<>();
  }

  /* Methods */

  public void comprarProducto(Producto p, int cant) {
    try {
      Producto existe = dictProduct.search(p.getCode());
      existe.increaseStock(cant);
    } catch (ItemNotFound e) {
      System.out.println(e.getMessage());
    }
  }

  public void crearProducto(Producto p) {
    this.dictProduct.insert(p.getCode(), p);
  }

  public void venderProducto(Producto p, int cant) throws MinStock {
    try {
      Producto existe = dictProduct.search(p.getCode());
      existe.venderProductos(cant);
      ventas.add(p);
    } catch (ItemNotFound e) {
      System.out.println(e.getMessage());
    }
  }

  public void darBajaProducto(Producto p) {
    try {
      Producto existe = dictProduct.search(p.getCode());
      if (existe.getStock() <= existe.getStockMin()) {
        dictProduct.remove(existe.getCode());
      } else {
        System.out.println("No se puede no stock minimo");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void printProductos() {
    this.dictProduct.printDict();
  }

  public ArrayList<Producto> productosArrayList() {
    ArrayList<EntryDict<String, Producto>> pares = this.dictProduct.toArrayList();
    ArrayList<Producto> productos = new ArrayList<>();
    for (EntryDict<String, Producto> par : pares) {
      productos.add(par.getValue());
    }
    return productos;
  }

  public void printVentas() {
    System.out.println(this.ventas);
  }

  public void generarReportes() {
    System.out.println("-----------Generar Reportes-----------");
    System.out.println("1.Reporte de productos por estado");
    System.out.println("2.Reporte de los productos mas vendidos");
    Scanner sc = new Scanner(System.in);
    int option = sc.nextInt();
    sc.close();
    switch (option) {
      case 1:
        verProductosEstado();
        break;
      case 2:
        productosMasVendidos();
        break;
      default:
        System.out.println("Ingrese una opcion valida");
        break;
    }
  }

  protected void verProductosEstado() {
    ArrayList<EntryDict<String, Producto>> list = this.dictProduct.toArrayList();
    ArrayList<Producto> suficiente = new ArrayList<>();
    ArrayList<Producto> insuficiente = new ArrayList<>();
    for (EntryDict<String, Producto> par : list) {
      Producto p = par.getValue();
      if (p.esSuficiente()) {
        suficiente.add(p);
      } else {
        insuficiente.add(p);
      }
    }
    System.out.println("-------Producto-Estado-------");
    System.out.println("Suficiente");
    print(suficiente);
    System.out.println("Insuficiente");
    print(insuficiente);
  }

  protected void print(ArrayList<Producto> arr) {
    for (Producto producto : arr) {
      System.out.println(producto);
    }
  }

  public void productosMasVendidos() {
    ArrayList<EntryDict<String, Producto>> list = this.dictProduct.toArrayList();
    Producto[] productos = new Producto[list.size()];
    for (int i = 0; i < productos.length; i++) {
      productos[i] = list.get(i).getValue();
    }
    Arrays.sort(productos);
    for (int i = productos.length * 2 / 3; i < productos.length; i++) {
      System.out.println(productos[i]);
    }
  }
}