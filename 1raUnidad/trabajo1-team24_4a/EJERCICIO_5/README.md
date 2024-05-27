## 5. Diseñar la clase OperacionesArray que cuente con

### Un arreglo genérico de n posiciones
- A pesar de no poder crear arreglos genéricos directamente, se puede lograr un resultado similar (con algunos defectos) usando el siguiente método:
```
this arreglo = (T[]) new Object[capacidad];
```
- Al tener el requerimiento de mantener todos los elementos al inicio de arreglo, se pueden usar estrategias similares a un ArrayList, manteniendo en una variable cuenta la cantidad de elementos actuales.

### Un método insert()
- Con ayuda de cuenta, simplemente podemos añadir el nuevo elemento en [cuenta] e incrementar cuenta. Además de generar una excepción si el arreglo está lleno.

### Un método find()
- Una simple búsqueda lineal que se detiene en cuenta (ya que el resto de elementos son null). Se tiene que usar el método equals() puesto que los elementos son génericos.

### Un método remove()
- Usando find(), se encuentra el elemento y se remueve si existe. Además, hay que asegurarse de mover todos los elementos para que ocupen el espacio vacio.

### El método toString()
- Concatena los elementos del arreglo para que tengan una presentación de la forma [a, b, c, …], que facilita el trabajo de realizar pruebas.

### Clase Persona
- Una clase que almacena los atributos dados, tiene métodos accesores, toString() para ser usado en la impresión del arreglo y equals() para ser usado en el método de búsqueda. Por requerimiento, la búsqueda de personas se hace por nombre y edad, así que equals() solo compara estos 2 atributos.

### Clase Test
- Prueba la clase OperacionesArray con enteros, cadenas y personas, verificando (mediante toString()):
    - Un OperacionesArray vacio.
    - Un OperacionesArray con un elemento.
    - Un OperacionesArray lleno.
    - Encontrar un elemento que existe.
    - Encontrar un elemento que no existe.
    - Remover un elemento que existe.
    - Remover un elemento que no existe.
