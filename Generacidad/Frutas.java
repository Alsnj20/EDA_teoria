package Trabajo;

public abstract class Frutas {
  private String nombre;
  private String color;
  public Frutas(String nombre, String color){
    this.nombre = nombre;
  }
  public String getNombre(){
    return this.nombre;
  }
  public abstract String darColor();
  public String toString(){
    return "Fruta: " + this.nombre;
  }
}
