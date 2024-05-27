package PrimeraUnidad.Generacidad;
public class CajaObject {
  private Object dato;
  public CajaObject(){
    super();
  }
  public Object dame(){
    return dato;
  }
  public void pon(Object obj){
    dato = obj;
  }
  public static void main(String[] args) {
    CajaObject c = new CajaObject();
    c.pon("Hola");
    Integer n = (Integer) c.dame(); // Error en tiempo de ejecución (ClassCastException
    String s = (String) c.dame();
    System.out.println(s);
  }
}
