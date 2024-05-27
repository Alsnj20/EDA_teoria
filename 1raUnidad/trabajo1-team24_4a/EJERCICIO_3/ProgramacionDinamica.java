import java.util.ArrayList;
import java.util.HashMap;

public class ProgramacionDinamica {
  public static double[] monedas = {5, 2, 1, 0.5, 4};
  public static HashMap<Double, Integer> soluciones = new HashMap<>();
  public static void main(String[] args) {
    int test = darVuelto(Double.parseDouble(args[0]));
    System.out.println(test);
  }

  public static int darVuelto(double monto) {
    //Casos base
    if (monto < 0)
      return Integer.MAX_VALUE;
    if (monto == 0)
      return 0;
    if (soluciones.containsKey(monto))
      return soluciones.get(monto);

    ArrayList<Integer> otrasSoluciones = new ArrayList<>();

    for (double moneda : monedas)
      otrasSoluciones.add(darVuelto(monto - moneda));

    int solucion = min(otrasSoluciones) + 1;
    soluciones.put(monto, solucion);
    return solucion;
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
