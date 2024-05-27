package PrimeraUnidad.Generacidad;


public class Kiwi extends Frutas{
  private int sabor;
  public Kiwi(int sabor, String nombre, String color){
    super(nombre, color);
    this.sabor = sabor;
  }
  public String darColor(){
    return "Verde";
  }
}
