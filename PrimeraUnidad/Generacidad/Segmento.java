package PrimeraUnidad.Generacidad;


public class Segmento {
  public static void main(String[] args) {
    System.out.println();
  }

  public static int mediana(int[] segmento, int inicio, int fin){
    int longi = fin - inicio + 1;
    if(longi == 1){
      return segmento[inicio];
    }else if(longi == 2){
      return (segmento[inicio] + segmento[fin])/2;
    }else{
      int mid = (inicio + fin)/2;
      int mid1 = mediana(segmento, inicio, mid);
      int mid2 = mediana(segmento, mid+1, fin);
      return (mid1 + mid2)/2;
    }
  }
}
