package EjercicioR1.Tienda;

public class Producto implements Comparable<Producto> {
  private String code;
  private String description;
  private int stock;
  private int stockMin;
  private double price;
  private boolean esSuficiente;
  private int totalVentas;
  // Vender

  public Producto(String cod, String des, int stock, int stockMin, double price, boolean existe) {
    this.code = cod;
    this.description = des;
    this.stock = stock;
    this.stockMin = stockMin;
    this.price = price;
    this.esSuficiente = existe;
    this.totalVentas = 0;
  }

  public Producto() {
    this("", "", 0, 0, 0.0, true);
  }

  public Producto(String cod, String des, int stock, int stockMin) {
    this(cod, des, stock, stockMin, 0.0, true);
  }

  /* Getters and Setters */
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public int getStockMin() {
    return stockMin;
  }

  public void setStockMin(int stockMin) {
    this.stockMin = stockMin;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public boolean esSuficiente() {
    return esSuficiente;
  }

  public void setEsSuficiente(boolean esSuficiente) {
    this.esSuficiente = esSuficiente;
  }

  /* COMPRANDO */
  public void increaseStock(int cantidad) {
    this.stock += cantidad;
  }

  public boolean equals(Producto p) {
    return this.code == p.code;
  }

  /* VENDIENDO */
  public void venderProductos(int cantidad) {
    System.out.println("Stock:" + this.stock + ", Min" + this.stockMin);
    if (this.stock - cantidad <= this.stockMin) {
      System.out.println("No se puede vender: Stock:" + this.stock + ", Min" + this.stockMin);
      esSuficiente = false;
    } else {
      this.stock -= cantidad;
      this.totalVentas += cantidad;
    }
  }

  public int getTotalVentas() {
    return this.totalVentas;
  }

  public String toString() {
    return "P:" + this.code + ",D:" + this.description + ",ST:" + this.stock + ",SM:" + this.stockMin + "total:"
        + this.totalVentas;
  }

  public int compareTo(Producto otro) {
    return this.getTotalVentas() - otro.getTotalVentas();
  }
}
