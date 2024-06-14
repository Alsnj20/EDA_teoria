package EjercicioR1.Tienda;

public class Producto {
  private String code;
  private String description;
  private int stock;
  private int stockMin;
  private double price;
  private boolean esSuficiente;

  public Producto(String cod, String des, int stock, int stockMin, double price, boolean existe){
    this.code = cod;
    this.description = des;
    this.stock = stock;
    this.stockMin = stockMin;
    this.price = price;
    this.esSuficiente = existe;
  }
  

  public Producto(){
    this("", "", 0, 0, 0.0, true);
  }

  public Producto(String cod, String des, int stock, int stockMin){
    this(cod, des, stock, stockMin, 0.0, true);
  }
  /*Getters and Setters */
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

  /*COMPRANDO*/
  public void increaseStock(){
    this.stock++;
  }

  public boolean equals(Producto p){
    return this.code == p.code;
  }

  /*VENDIENDO*/
  public void decreaseStock(){
    this.stock--;
    if(this.stock == this.stockMin){
      esSuficiente = false;
    }
  }
  
  public String toString(){
    return "P:"+this.code+",D:"+this.description+",S:"+this.stock+",SM:"+this.stockMin;
  }
}
