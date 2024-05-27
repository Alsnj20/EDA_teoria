public class Test {
    public static void main(String[] args) {
        Ubicacion ubicacion1 = new Ubicacion("Calle 1", "123", "Distrito A", "Departamento X");
        Ubicacion ubicacion2 = new Ubicacion("Avenida 2", "456", "Distrito B", "Departamento Y");

        Object[] contenedor = new Object[10];

        contenedor[0] = new Polideportivo(1000, "Fútbol", "Polideportivo A", ubicacion1);
        contenedor[1] = new Polideportivo(1500, "Baloncesto", "Polideportivo B", ubicacion2);
        contenedor[2] = new EdificioOficinas(2000, 50, ubicacion1);

        show(contenedor);
    }

    public static void show(Object[] contenedor) {
        for (Object obj : contenedor) {
            if (obj instanceof Polideportivo) {
                Polideportivo poli = (Polideportivo) obj;
                System.out.println("Nombre: " + poli.getNombre());
                System.out.println("Superficie: " + poli.getSuperficie());
                System.out.println("Deporte: " + poli.getTipoDeDeporte());
                System.out.println("Ubicacion: " + poli.getUbicacion().toString());
            } else if (obj instanceof EdificioOficinas) {
                EdificioOficinas edif = (EdificioOficinas) obj;
                System.out.println("Superficie: " + edif.getSuperficie());
                System.out.println("Número de oficinas: " + edif.getNumOficinas());
                System.out.println("Ubicacion: " + edif.getUbicacion().toString());
            }
        }
    }
}
