## 1. Diseñe e implemente un algoritmo “divide y vencerás” que permita encontrar la mediana de un arreglo de n elementos sin tener que ordenar el vector previamente.

### Mediana:
- Es aquel elemento o elementos que se encuentran en el medio de una lista de datos ordenados.
### Clase Mediana:
Lógica propuesta para hallar la mediana a través de la técnica divide y vencerás. A continuación se muestran los métodos implementados.
- foundMediana: Verifica si la longitud es par o impar del arreglo, haciendo llamadas recursivas al método found value.
- foundValue: Este método como tal encontra el valor de la mediana, usando el algoritmo de búsqueda de mediana similar a la técnica de partición (Quickselect), implementado en el método partir. Luego, determina en cuál de los dos subarreglos se encuentra la mediana y repite el proceso de forma recursiva.
- partir: Divide como tal al arreglo en dos partes, de acuerdo al pivote con los elementos menores a la izquierda y mayores a la derecha.
- swap: Método para evitar reutilizar código hace el intercambio de dos valores.
