package Trabajo;

/* Clases genericas */

public class CajaGenerica<TypeData> {
  private TypeData dato;
  public CajaGenerica(){
    super();
  }
  public TypeData dame(){
    return dato;
  }
  public void pon(TypeData obj){
    dato = obj;
  }
  /* Metodos genericos*/
  public <T> void imprime(T obj){
    System.out.println(obj);
  }
  /* Metodos genericos enteros */
  public static <TypeData> TypeData ponEnCaja(TypeData item, CajaGenerica<TypeData> caja){
    return caja.dame();
  }
  public static <TypeData> void ponEnCaja2(TypeData item, CajaGenerica<TypeData> caja){
    caja.pon(item);
  }
  public static void main(String[] args) {
    CajaGenerica<String> c = new CajaGenerica<String>();
    c.pon("Hola");
    String s = c.dame();
    System.out.println(s);
  }
}


