package EJERCICIO_6;

public class Test {
  public static void main(String[] args) {
    ArrayListNumber arrayListNumber = new ArrayListNumber();
    arrayListNumber.meter("rojo", 5);
    arrayListNumber.meter("azul", 10);
    arrayListNumber.meter("verde", 3);
    arrayListNumber.meter("rojo", 8);
    arrayListNumber.meter("azul", 1);
    arrayListNumber.meter("verde", 7);
    arrayListNumber.meter("rojo", 2);
    arrayListNumber.meter("azul", 9);
    arrayListNumber.meter("verde", 6);
    arrayListNumber.meter("azul", 4);
    /*elemento 11 */
    arrayListNumber.meter("verde", 11);
    System.out.println("-----Lista de Cajas Rojas----");
    arrayListNumber.recorre("rojo");
    System.out.println("----Cajas por defecto----");
    System.out.println(arrayListNumber);
    System.out.println("----Cajas Ordenadas----");
    arrayListNumber.ordenar();
    System.out.println(arrayListNumber);
    System.out.println("----Color de la caja con menos elementos----");
    System.out.println(arrayListNumber.mayor());  
  }
}
