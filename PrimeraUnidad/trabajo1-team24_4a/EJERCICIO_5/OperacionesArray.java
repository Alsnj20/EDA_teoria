package EJERCICIO_5;

public class OperacionesArray<T> {
    private T[] arreglo;
    private int capacidad;
    private int cuenta;

    public OperacionesArray(int capacidad) {
        this.capacidad = capacidad;
        this.arreglo = (T[]) new Object[capacidad];
        this.cuenta = 0;
    }

    public void insert(T elemento) throws Exception {
        if (cuenta < capacidad) {
            arreglo[cuenta] = elemento;
            cuenta++;
        } else {
            throw new Exception("Arreglo lleno.");
        }
    }

    public int find(T elemento) {
        for (int i = 0; i < cuenta; i++) {
            if (arreglo[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public void remove(T elemento) {
        int indice = find(elemento);
        if (indice != -1) {
            for (int i = indice; i < cuenta - 1; i++) {
                arreglo[i] = arreglo[i + 1];
            }
            arreglo[cuenta - 1] = null;
            cuenta--;
        }
    }

    public String toString() {
        String lista = "[";
        for (int i = 0; i < cuenta - 1; i++) { 
            lista += arreglo[i] + ", ";
        }
        if (cuenta > 0) {
            lista += arreglo[cuenta - 1];
        }
        lista += "]";
        return lista;
    }
}
