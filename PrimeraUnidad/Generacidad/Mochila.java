package PrimeraUnidad.Generacidad;

public class Mochila {
  public static void main(String[] args) {
    int[] pesos = {60, 100, 120, 40};
    int[] valores = {10, 40, 100, 20};
    int capacidad = 50;
    int nElementos = pesos.length;
    System.out.println(mochila(pesos, valores, capacidad, nElementos));
  }
  public static int mochila(int[] pesos, int[] valores, int capacidad, int nElementos){
    int[][] dp = new int[nElementos+1][capacidad+1];
    for(int i = 0; i <= nElementos; i++){
      for(int j = 0; j <= capacidad; j++){
        if(i == 0 || j == 0){
          dp[i][j] = 0;
        }else if(pesos[i-1] <= j){
          dp[i][j] = Math.max(valores[i-1] + dp[i-1][j-pesos[i-1]], dp[i-1][j]);
        }else{
          dp[i][j] = dp[i-1][j];
        }
      }
    }
    return dp[nElementos][capacidad];
  }

}

