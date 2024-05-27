## 3. Dada una empresa expendedora de golosinas requiere dar un mejor servicio a sus clientes en el sentido de que, cada vez que sea necesario dar vuelto por alguna compra se le proporcione la menor cantidad posible de monedas.

### Solución recursiva: 
- Después de ver que un enfoque Greedy no soluciona nuestro problema, analicemos la naturaleza del problema de la siguiente manera: "¿Cuál es el más pequeño número de monedas necesarias para x monto?".
Los valores dependerán de los valores de las monedas que tenemos, en nuestro primer caso {5, 2, 1, 0.5} las soluciones serían: 

    - vuelto(0) = 0
    - vuelto(1) = 1
    - vuelto(2) = 1
    - vuelto(3) = 2
    - vuelto(4) = 2
    - vuelto(5) = 3
    - vuelto(6) = 3

- Cada problema puede ser resuelto a partir de sus valores más pequeños, por ejemplo, si queremos llegar a 6, nuestro último paso pudo haber sido elegir una moneda de 5, de 2, 1 o 0.5, entonces la solución óptima  para ese paso anterior es: 
min(vuelto(6 - 5), vuelto(6 - 2), vuelto(6 - 1), vuelto(6 - 0.5))

- Por lo tanto nuestra solución óptima para el caso original es el mismo + 1:
vuelto(6) = min(vuelto(6 - 5), vuelto(6 - 2), vuelto(6 - 1), vuelto(6 - 0.5)) + 1

#### Generalizando: 
- vuelto(x) = min( vuelto(x - c1), vuelto(x - c2), vuelto(x - c3), vuelto(x - c4) … ) + 1
- Observamos que nuestro caso base es 0, por que no necesitamos monedas para dar un vuelto 0.
```
public static int darVuelto(double monto) {
    //Casos base
    if (monto < 0)
      return Integer.MAX_VALUE;
    if (monto == 0)
      return 0;

    ArrayList<Integer> otrasSoluciones = new ArrayList<>();

    for (double moneda : monedas)
      otrasSoluciones.add(darVuelto(monto - moneda));

    return min(otrasSoluciones) + 1;
    //Metodo auxiliar min, que encuentra el menor elemento de un Array
  }
```

### Solución con enfoque en Programación Dinámica: 
- A simple vista, podemos ver que con un enfoque de recursividad con fuerza bruta, hacemos muchos cálculos repetidos una y otra vez.
- Para eliminar estos cálculos innecesarios, manejaremos un HashMap que guardará la mejor solución para un monto x determinado:
```
  public static int darVuelto(double monto) {
    //Casos base
    if (monto < 0)
      return Integer.MAX_VALUE;
    if (monto == 0)
      return 0;
    //Consultamos si ya hemos calculado ese valor
    if (soluciones.containsKey(monto))
      return soluciones.get(monto);

    ArrayList<Integer> otrasSoluciones = new ArrayList<>();

    for (double moneda : monedas)
      otrasSoluciones.add(darVuelto(monto - moneda));

    int solucion = min(otrasSoluciones) + 1;
    soluciones.put(monto, solucion);
    return solucion;
  }
```