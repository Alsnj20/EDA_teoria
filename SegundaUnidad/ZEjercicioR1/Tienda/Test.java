package ZEjercicioR1.Tienda;

public class Test {
  public static void main(String[] args) {
    Store store = new Store();
    Producto p1 = new Producto("1", "Producto 1", 3, 1);
    Producto p2 = new Producto("2", "Producto 2", 10, 5);
    Producto p3 = new Producto("3", "Producto 3", 10, 5);
    Producto p4 = new Producto("4", "Producto 4", 10, 5);
    Producto p5 = new Producto("5", "Producto 5", 10, 5);

    // hola :3

    store.comprarProducto(p1, 2);
    System.out.println(p1);
    store.comprarProducto(p2, 5);
    store.comprarProducto(p3, 6);
    store.comprarProducto(p4, 7);
    store.comprarProducto(p5, 1);
    store.printProductos();
    System.out.println("--------------Vender---------");
    try {
      store.venderProducto(p1, 3);
      store.venderProducto(p2, 4);
      store.venderProducto(p5, 2);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.println("---------------Productos-----------");
    store.printProductos();
    System.out.println("-------------Ventas-----------");
    store.printVentas();
    store.verProductosEstado();
    System.out.println("------------Mas Vendidos--------");
    store.productosMasVendidos();
  }
}
