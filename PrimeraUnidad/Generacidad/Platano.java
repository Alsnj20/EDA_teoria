package PrimeraUnidad.Generacidad;


public class Platano extends Frutas{
  private int sabor;
  public Platano(int sabor, String nombre, String color){
    super(nombre, color);
    this.sabor = sabor;
  }
  public int getSabor(){
    return this.sabor;
  }
  public String darColor(){
    return "Amarillo";
  }
  public String toString(){
    return "Platano de sabor: " + this.sabor;
  }
  
}
