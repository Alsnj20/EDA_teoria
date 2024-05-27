package EJERCICIO_2;

public class Menor {
    public static int menor(int[] arr, int ini, int fin, int k) {
        if (ini == fin)
            return arr[ini];

        int pivIdx = (int) (Math.random() * (fin - ini + 1) + ini);
        pivIdx = particion(arr, ini, fin, pivIdx);
        if (k - 1 == pivIdx)
            return arr[pivIdx];
        if (k - 1 < pivIdx)
            return menor(arr, ini, pivIdx - 1, k);
        return menor(arr, pivIdx + 1, fin, k);
    }

    private static int particion(int[] arr, int ini, int fin, int pivIdx) {
        int piv = arr[pivIdx];
        int i = ini;
        for (int j = ini; j < fin; j++) {
            if (arr[j] < piv) {
                intercambiar(arr, i, j);
                i++;
            }
        }
        intercambiar(arr, i, fin);
        return i;
    }

    private static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
