package EJERCICIO_2;

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            test();
            System.out.println();
        }
    }

    private static void test() {
        int n = 10;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int k = (int) (Math.random() * n) + 1;
        System.out.println("K: " + k);
        int menor = Menor.menor(arr, 0, n - 1, k);
        System.out.println("Menor: " + menor);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
