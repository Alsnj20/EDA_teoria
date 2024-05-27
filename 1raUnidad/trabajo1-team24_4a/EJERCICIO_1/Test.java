package EJERCICIO_1;

public class Test {
  public static void main(String[] args) {

    System.out.println("Mediana para un Arreglo Ordenado");
    /* Arreglo Ordenado longitud par */
    int[] arrayOrdenadoPar = { 1, 2, 3, 4, 5, 6 };
    System.out.println("Longitud par: " + Mediana.foundMediana(arrayOrdenadoPar));

    /* Arreglo Ordenado longitud impar */
    int[] arrayOrdenadoImpar = { 1, 2, 3, 4, 5, 6, 7 };
    System.out.println("Longitud impar: " + Mediana.foundMediana(arrayOrdenadoImpar));

    System.out.println("Mediana para un Arreglo Desordenado");
    /* Arreglo Desordenado longitud par */
    int[] arrayDesordenadoPar = { 1, 5, 7, 2, 3, 6 };
    System.out.println("Longitud par: " + Mediana.foundMediana(arrayDesordenadoPar));

    /* Arreglo Desordenado longitud impar */
    int[] arrayDesordenadoImpar = { 1, 5, 7, 2, 3, 9, 6 };
    System.out.println("Longitud impar: " + Mediana.foundMediana(arrayDesordenadoImpar));
  }
}
