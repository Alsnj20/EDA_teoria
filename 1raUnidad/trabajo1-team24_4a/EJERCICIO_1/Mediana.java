package EJERCICIO_1;

public class Mediana {
  public static void main(String[] args) {
    System.out.println("Arreglo Inicial");
    int[] arrayDesordenadoPar = { 1, 5,13,5,17,20, 7, 2, 3, 6, 20, 30, 50, 80, 12, 13};
    print(arrayDesordenadoPar);
    System.out.println("Mediana: " + Mediana.foundMediana(arrayDesordenadoPar));
    System.out.println("Arreglo Final");
    print(arrayDesordenadoPar);
    System.out.println("------------------------");
    System.out.println("Arreglo Inicial");
    int[] arrayDesordenadoPar1 = { 1, 5,13,5,17,20, 7, 2, 3,8,10};
    print(arrayDesordenadoPar);
    System.out.println("Mediana: " + Mediana.foundMediana(arrayDesordenadoPar1));
    System.out.println("Arreglo Final");
    print(arrayDesordenadoPar);
    System.out.println("------------------------");
    System.out.println("Arreglo Inicial");
    int[] arrayDesordenadoPar2 = { 1, 5,13,5,17,20, 7, 2, 3, 6, 20, 30, 4, 80, 12, 13, 100};
    print(arrayDesordenadoPar);
    System.out.println("Mediana: " + Mediana.foundMediana(arrayDesordenadoPar2));
    System.out.println("Arreglo Final");
    print(arrayDesordenadoPar);
  }
  public static double foundMediana(int[] array){
    int n = array.length;
    if(n % 2 == 0){
      int mediana1 = foundValue(array, 0, n-1, n/2);
      int mediana2 = foundValue(array, 0, n-1, n/2+1);
      return (mediana1 + mediana2) / 2.0;
    }else{
      return foundValue(array, 0, n-1, n/2+1);
    }
  }

  public static int foundValue(int[] array, int start, int end, int puntero){
    if(start == end){
      return array[start];
    }
    
    int pivotIndex = partir(array, start, end);
    int longitud = pivotIndex - start + 1;
    if(puntero == longitud){
      return array[pivotIndex];
    }
    else if(puntero < longitud){
      return foundValue(array, start, pivotIndex - 1, puntero);
    }else{
      return foundValue(array, pivotIndex + 1, end, puntero - longitud);
    }
  }

  public static int partir(int[] array, int start, int end){
    int puntero = array[end];
    int i = start;
    for(int j = start; j < end; j++){
      if(array[j] < puntero){
        swap(array, i, j);
        i++;
      }
    }
    swap(array, i, end);
    return i;
  }
  public static void swap(int[]array, int i, int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }


  public static void print(int[] array){
    System.out.print("[");
    for (int i : array) {
      System.out.print(i+", ");
    }
    System.out.println("]");
  }
}
