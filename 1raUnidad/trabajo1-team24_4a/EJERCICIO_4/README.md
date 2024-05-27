## 4. Lea atentamente el caso que se le propone y elabore la solución de los requermientos solicitados. 
#### a. Una instalación deportiva es un recinto delimitado donde se practica algún deporte en particular, interesa disponer de un método int getTipoDeDeporte(). 
#### b. Un edificio es una construcción cubierta que tiene una superficie determinada e interesa disponer de un método double getSuperficieEdificio(). 
#### c. Un polideportivo es al mismo tiempo una instalación deportiva y un edificio; interesa conocer la superficie que tiene, el deporte que se practica en él y el nombre que tiene. 
#### d. Un edificio de oficinas es un edificio; interesa conocer el número de oficinas que tiene y su superficie. 
#### e. Además, interesa conocer dónde se encuentran ubicados tanto los polideportivos como los edificiones de oficinas. Y esta ubicación consta de una calle, número, distrito y departamento correspondientemente

### Implementación del código
#### Clase Edificio: 
- Esta clase es abstracta, lo que significa que no se pueden crear instancias de ella directamente, sino que se utiliza como un modelo para otras clases.
- Tiene dos atributos protegidos: superficie y ubicación. Además, cuenta con un constructor que inicializa la superficie y la ubicación del edificio.
- Contiene un método abstracto getSuperficie() que debe ser implementado por las clases hijas.
- También proporciona métodos para obtener y establecer la ubicación del edificio.
#### Interfaz InstalacionDeportiva:
- Define un método getTipoDeDeporte() que debe ser implementado por cualquier clase que la implemente.
#### Clase EdificioOficinas:
- Esta clase extiende la clase Edificio y agrega un atributo específico numOficinas, que representa el número de oficinas en el edificio de oficinas.
- Tiene un constructor que inicializa la superficie, el número de oficinas y la ubicación del edificio.
- Implementa el método abstracto getSuperficie() devolviendo la superficie del edificio de oficinas.
#### Clase Polideportivo: 
- Esta clase extiende la clase Edificio e implementa la interfaz InstalacionDeportiva.
- Tiene tres atributos adicionales: tipoDeDeporte, nombre y ubicación. Su constructor inicializa la superficie, el tipo de deporte, el nombre y la ubicación del polideportivo.
- Implementa los métodos getSuperficie() y getTipoDeDeporte() requeridos por las clases padre e interfaz respectivamente.
- Proporciona un método adicional getNombre() para obtener el nombre del polideportivo.
#### Clase Ubicacion:
- Representa la ubicación de un edificio.
- Tiene cuatro atributos: calle, número, distrito y departamento.
- Su constructor inicializa estos atributos y proporciona métodos para obtener y establecer cada uno de ellos.

## ¿Su solución hace uso de polimorfismo?. Explique ¿cómo, dónde y por qué lo utiliza?:
Si, la solución hace uso de polimorfismo. Se puede ver en las clases que heredan de la case "Edificio" y en la implementación de la interfaz "InstalacionDeportiva".

- Por ejemplo, en la clase EdificioOficinas, se sobrescribe el método getSuperficie() para devolver la superficie del edificio de oficinas, mientras que en la clase Polideportivo, también se sobrescribe el mismo método para devolver la superficie del polideportivo. A pesar de que ambos métodos tienen el mismo nombre, el comportamiento es diferente en cada caso, lo que ilustra el polimorfismo:
- Además, el polimorfismo también se aplica al utilizar la interfaz InstalacionDeportiva. Por ejemplo, la clase Polideportivo implementa esta interfaz y proporciona su propia implementación del método getTipoDeDeporte(). Esto permite que diferentes tipos de instalaciones deportivas, como el polideportivo en este caso, puedan proporcionar información específica sobre el tipo de deporte que ofrecen:
- El polimorfismo aquí permite que las clases EdificioOficinas y Polideportivo compartan un mismo nombre de método con comportamientos distintos, lo que hace que el código sea más flexible y fácil de mantener.