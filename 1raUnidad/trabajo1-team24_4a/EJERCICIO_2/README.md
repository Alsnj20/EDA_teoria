## 2. Un algoritmo “divide y vencerás” que permita calcular el k-ésimo menor elemento de un arreglo de n elementos sin tener que ordenar el vector previamente.

### Proceso:
- El algoritmo de partición de Lomuto es de gran ayuda ya que permite obtener la posición del pivote resultado, de tal manera que si este fuera igual a k - 1, haría del pivote el k-ésimo menor elemento.
- Aprovechando la estrategia de Quickselect, elegiremos el pivote inicial al azar, para (con algo de suerte) evitar seleccionar un mal pivote.
```
int pivIdx = (int) (Math.random() * (fin - ini + 1) + ini);
pivIdx = particion(arr, ini, fin, pivIdx);
if (k - 1 == pivIdx)
    return arr[pivIdx];
```
- Caso contrario, se aplica la partición de nuevo después de reducir el arreglo al segmento en el que se encuentra el elemento.
```
if (k - 1 < pivIdx)
    return menor(arr, ini, pivIdx - 1, k);
return menor(arr, pivIdx + 1, fin, k);
```