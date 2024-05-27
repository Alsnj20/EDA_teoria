package EJERCICIO_5;

public class Persona {
    private String nombre;
    private String sexo;
    private int edad;

    public Persona(String nombre, String sexo, int edad) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public String toString() {
        return nombre + " " + sexo + " " + edad;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Persona) {
            Persona otra = (Persona) obj;
            return nombre.equals(otra.getNombre()) && edad == otra.getEdad();
        }
        return false;
    }

}
