package PrimeraUnidad.Generacidad;


public class Manzana {
  private int sabor;
  public Manzana(int sabor){
  this.sabor = sabor; }
  public int getSabor(){
  return this.sabor; }
  
  public String toString(){
  return "Manzana de sabor: " + this.sabor;
  }
}