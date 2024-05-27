package EJERCICIO_5;

public class Test {
    public static void main(String[] args) {
        System.out.println("Pruebas con Integer");
        probarInteger();
        System.out.println("Pruebas con String");
        probarString();
        System.out.println("Pruebas con Persona");
        probarPersona();
    }

    private static void probarInteger() {
        OperacionesArray<Integer> arreglo = new OperacionesArray<>(5);
        try {
            // Metodo insert
            System.out.println(arreglo.toString());
            arreglo.insert(1);
            System.out.println(arreglo.toString());
            arreglo.insert(6);
            arreglo.insert(4);
            arreglo.insert(8);
            arreglo.insert(3);
            System.out.println(arreglo.toString());
            // Metodo find
            System.out.println(arreglo.find(8));
            System.out.println(arreglo.find(5));
            // Metodo remove
            arreglo.remove(4);
            arreglo.remove(10);
            System.out.println(arreglo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void probarString() {
        OperacionesArray<String> arreglo = new OperacionesArray<>(5);
        try {
            // Metodo insert
            System.out.println(arreglo.toString());
            arreglo.insert("a");
            System.out.println(arreglo.toString());
            arreglo.insert("e");
            arreglo.insert("i");
            arreglo.insert("o");
            arreglo.insert("u");
            System.out.println(arreglo.toString());
            // Metodo find
            System.out.println(arreglo.find("i"));
            System.out.println(arreglo.find("k"));
            // Metodo remove
            arreglo.remove("a");
            arreglo.remove("p");
            System.out.println(arreglo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void probarPersona() {
        OperacionesArray<Persona> arreglo = new OperacionesArray<>(5);
        try {
            // Metodo insert
            System.out.println(arreglo.toString());
            arreglo.insert(new Persona("Marcos", "M", 27));
            System.out.println(arreglo.toString());
            arreglo.insert(new Persona("Maria", "F", 32));
            arreglo.insert(new Persona("Juan", "M", 41));
            arreglo.insert(new Persona("Ana", "F", 33));
            arreglo.insert(new Persona("Luis", "M", 24));
            System.out.println(arreglo.toString());
            // Metodo find
            System.out.println(arreglo.find(new Persona("Luis", "M", 24)));
            System.out.println(arreglo.find(new Persona("Maria", "F", 31)));
            // Metodo remove
            arreglo.remove(new Persona("Ana", "F", 33));
            arreglo.remove(new Persona("Rufina", "F", 29));
            System.out.println(arreglo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
