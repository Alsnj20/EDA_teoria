package EJERCICIO_6;

public class Caja<TypeData> {
  private TypeData dato;
  private String color;
  
  public Caja(String c) {
    this.color = c;
  }
  public String obtenerColor() {
    return color;
  }

  public void darColor(String color) {
    this.color = color;
  }

  public void pon(TypeData x) {
    this.dato = x;
  }

  public TypeData dame() {
    return this.dato;
  }

  public String toString(){
    return "Contenido: "+dato+" |Color: "+color;
  }
  public static void main(String[] args) {
    Caja<Integer> cajaEnteros = new Caja("Rosado");
    cajaEnteros.pon(10);
    System.out.println(cajaEnteros);
    Caja<String> cajaString = new Caja("Azul");
    cajaString.pon("hola");
    System.out.println(cajaString);
    Caja<Double> cajaDoubles = new Caja("Azul");
    cajaDoubles.pon(5.6);
    System.out.println(cajaDoubles);
  }
}