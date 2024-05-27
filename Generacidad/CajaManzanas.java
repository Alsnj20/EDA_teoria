package Trabajo;

public class CajaManzanas extends Caja<Manzana>{
  public CajaManzanas(){
    super();
  }
  public int getSabor(){
    return this.dame().getSabor();
  }
}