## 6. Realice lo siguiente

#### a. Modifique la clase Caja vista en clase, de modo que cada caja tenga un color determinado el mismo que es definido al momento de su creación.
#### b. Utilizando la clase ArrayList, escribe una clase ArrayListNumber que realice lo siguiente por medio de la implementación de los siguientes métodos genéricos:
#### c. Un método meter() que guarde en el arrayList 10 objetos de la clase Caja (modificada en el punto 1) cuyo contenido solo puedan ser números enteros. El valor que guardarán la caja es un parámetro del método.
#### d.Un método recorre() que muestre el contenido de las cajas de un determinado color que tiene el arrayList. El color se envía al método en su invocacoón.
#### e.Un método ordenar() que implemente el método de ordenamiento de inserción de modo que ordene el contenido de las cajas del arrayList de forma ascendente.
#### f.Un método mayor() que devuelva el color de la caja que tenga el menor elemento del conjunto de objetos almacenados en las cajas del arrayList.
#### g. Escriba la clase Test en donde realice las pruebas de los métodos de la clase ArrayListNumber.

### Implementación del código
#### Estructura de Datos Genérica (Clase Caja):
- La Clase Caja está diseñada como una estructura de datos genérica que puede contener cualquier tipo de dato que especificamos en “TypeData”, se hizo uso de la encapsulación a través de los atributos privados y métodos públicos y uso del metodo toString() para tener información del objeto.
```
public class Caja<TypeData> {
  private TypeData dato;
  ...
}
```
- Requerimientos:
    - Dos atributos(Un genérico y un String).
    - Constructor inicializado con el atributo color (String).
    - Getter y setters: Para color (darColor y obtenerColor) y dato genérico (pon y dame);
    - toString: Retorna información del Objeto

- Pruebas: Se realizaron pruebas unitarias para verificar el funcionamiento de estos métodos.
Uso correcto de la clase Caja en el main:
```
Caja<Integer> cajaDoubles = new Caja("Rosado");
Caja<Double> cajaDoubles = new Caja("Azul");
```
#### Clase ArrayListNumber:
- Almacena cajas de enteros (Caja<Integer>), contiene métodos para agregar, seleccionar por color, ordenarles, etc.
- Contiene un único atributo que es un arrayList de Cajas y cada Caja almacena un entero.

```
private ArrayList<Caja<Integer>> array = new ArrayList<>();
```

- Métodos
    - meter(): Permite que se guarden 10 objetos en un arrayList, esto a través de una condición que si no se cumple lanzará un mensaje que contenga “Capacidad Limitada”. Además el parámetro recibe un color y el dato que se almacena dentro de la caja y de forma interna este crea la caja usando los datos del parámetro.
    - recorre(): Lleva como parámetro un String que se identifica como el color de la caja, itera y muestra aquellas cajas que sean del mismo color.
    - ordenar(): Utiliza el método de ordenamiento de inserción para ordenar las caja de forma ascendente de acuerdo al contenido.
    - mayor(): Rehúsa el método ordenar y nos retorna el color de la caja que contenga el menor elemento almacenado en la caja.
    - toString(): Retorna la información de todos los objetos almacenados hasta ese momento.
