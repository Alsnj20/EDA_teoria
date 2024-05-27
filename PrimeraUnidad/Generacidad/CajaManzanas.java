package PrimeraUnidad.Generacidad;
import PrimeraUnidad.Generacidad.Manzana;

public class CajaManzanas extends Caja<Manzana>{
  public CajaManzanas(){
    super();
  }
  public int getSabor(){
    return this.dame().getSabor();
  }
}