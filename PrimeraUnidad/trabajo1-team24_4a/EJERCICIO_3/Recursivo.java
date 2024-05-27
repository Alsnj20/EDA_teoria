import java.util.ArrayList;

public class Recursivo {
  public static double[] monedas = {5, 2, 1, 0.5};
  public static void main(String[] args) {
    int test = darVuelto(Double.parseDouble(args[0]));
    System.out.println(test);
  }

  public static int darVuelto(double monto) {
    if (monto < 0) {
      return Integer.MAX_VALUE;
    }
    if (monto == 0)
      return 0;

    ArrayList<Integer> otrasSoluciones = new ArrayList<>();

    for (double moneda : monedas)
      otrasSoluciones.add(darVuelto(monto - moneda));

    return min(otrasSoluciones) + 1;

  }

  public static int min(ArrayList<Integer> arr) {
    int min = Integer.MAX_VALUE;

    for (Integer num : arr) {
      if (num < min)
        min = num;
    }
    System.out.println("Minimo encontrado: " + min);
    return min;
  }
}
