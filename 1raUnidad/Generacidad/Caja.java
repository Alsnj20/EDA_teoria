package Trabajo;

public class Caja<TypeData extends Comparable<TypeData>> {
  private TypeData dato;
  public Caja(){
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
  public static <TypeData extends Comparable<TypeData>> TypeData ponEnCaja(TypeData item, Caja<TypeData> caja){
    return caja.dame();
  }
  public static <TypeData extends  Comparable<TypeData>> void ponEnCaja2(TypeData item, Caja<TypeData> caja){
    caja.pon(item);
  }
  public static void main(String[] args) {
    Caja<Platano> cajaPl= new Caja<Platano>();
    Platano p = new Platano(10, "Platano", "Amarillo");
    cajaPl.pon(p);
    Caja<Kiwi> cajaKi= new Caja<Kiwi>();
    Kiwi k = new Kiwi(10, "Kiwi", "Verde");
    cajaKi.pon(k);
    Caja<String> c = new Caja<String>();
    Caja<Frutas> frutas = new Caja<Frutas>();
    Frutas f = new Fruta("Fruta", "Rojo");
    Frutas f2 = new Platano(3, "banana", "verde");
    frutas.pon(f);
    
    Caja<Kiwi> cajaR= new Caja<Kiwi>();
  }
}
