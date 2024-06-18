package ZEjercicioR1.Tienda;

import java.util.*;

public class StoreUI {
    private final int ANCHO = 75;
    private Store tienda;
    private Scanner sc;

    public StoreUI() {
        this.tienda = new Store();
        this.sc = new Scanner(System.in);
        Producto p1 = new Producto("1", "Producto 1", 3, 1);
        Producto p2 = new Producto("2", "Producto 2", 10, 5);
        tienda.crearProducto(p1);
        tienda.crearProducto(p2);
    }

    public void mostrarMenu() {
        menuPrincipal();

    }

    private void menuPrincipal() {
        String menu = centrar(" Tienda ", '-')
                + espacio(4)
                + centrar("1. Comprar productos", ' ')
                + centrar("2. Vender productos", ' ')
                + centrar("3. Generar reportes", ' ')
                + centrar("4. Salir", ' ')
                + espacio(4)
                + centrar("", '-');
        System.out.println(menu);

        int opcion = scanOpcion("Selección: ", 1, 4);
        switch (opcion) {
            case 1:
                menuComprar();
                break;
            case 2:
                menuVender();
                break;
            case 3:
                menuReportes();
                break;
        }
    }

    private void menuComprar() {
        ArrayList<Producto> productos = this.tienda.productosArrayList();
        int size = productos.size();
        String menu = centrar(" Comprar un producto ", '-')
                + espacio(1)
                + listaProductos(productos)
                + centrar((size + 1) + ". Nuevo producto", ' ')
                + centrar((size + 2) + ". Salir", ' ')
                + espacio(1)
                + centrar("", '-');
        System.out.println(menu);

        int opcion = scanOpcion("Selección: ", 1, size + 2);
        if (opcion <= size + 1) {
            int cantidad;
            Producto prod;
            if (opcion == size + 1) {
                String code = scanTexto("Código: ");
                String description = scanTexto("Descripción: ");
                int stock = scanNumero("Stock: ");
                int stockMin = scanNumero("Stock mínimo: ");
                double price = scanDecimal("Precio: ");
                prod = new Producto(code, description, stock, stockMin, price);
                this.tienda.crearProducto(prod);
                cantidad = stock;
            } else {
                prod = productos.get(opcion - 1);
                cantidad = scanNumero("Cantidad: ");
                this.tienda.comprarProducto(prod, cantidad);
            }
            String res = centrar("", '-');
            res += centrar("Se compraron " + cantidad + " unidades de " + prod + "!", ' ');
            res += centrar("", '-');
            System.out.println(res);
        }

        menuPrincipal();
    }

    private void menuVender() {
        ArrayList<Producto> productos = this.tienda.productosArrayList();
        int size = productos.size();
        String menu = centrar(" Vender un producto ", '-')
                + espacio(1)
                + listaProductos(productos)
                + centrar((size + 1) + ". Salir", ' ')
                + espacio(1)
                + centrar("", '-');
        System.out.println(menu);

        int opcion = scanOpcion("Selección: ", 1, size + 1);
        if (opcion <= size) {
            Producto prod = productos.get(opcion - 1);
            int cantidad = scanNumero("Cantidad: ");
            String res = centrar("", '-');
            try {
                this.tienda.venderProducto(prod, cantidad);
                res += centrar("Se vendieron " + cantidad + " unidades de " + prod + "!", ' ');
            } catch (MinStock e) {
                res += centrar(e.getMessage(), ' ');
            }
            res += centrar("", '-');
            System.out.println(res);
        }

        menuPrincipal();
    }

    private void menuReportes() {
        String menu = centrar(" Generar reportes ", '-')
                + espacio(1)
                + centrar("1. Reporte de productos por estado", ' ')
                + centrar("2. Reporte de productos más vendidos", ' ')
                + centrar("3. Salir", ' ')
                + espacio(1)
                + centrar("", '-');
        System.out.println(menu);

        int opcion = scanOpcion("Selección: ", 1, 3);
        switch (opcion) {
            case 1:
                reportePorEstado();
                break;
            case 2:
                reporteMasVendidos();
                break;
        }

        menuPrincipal();
    }

    private void reportePorEstado() {
        String reporte = centrar(" Productos por estado ", '-')
                + espacio(1)
                + listaEstadoProductos()
                + espacio(1)
                + centrar("", '-');
        System.out.println(reporte);
    }

    private String listaEstadoProductos() {
        ArrayList<Producto> productos = this.tienda.productosArrayList();
        ArrayList<Producto> suficiente = new ArrayList<>();
        ArrayList<Producto> insuficiente = new ArrayList<>();

        for (Producto p : productos) {
            if (p.esSuficiente()) {
                suficiente.add(p);
            } else {
                insuficiente.add(p);
            }
        }

        String lista = centrar("Suficiente", ' ');
        for (Producto p : suficiente) {
            lista += centrar(p.toString(), ' ');
        }
        lista += centrar("Insuficiente", ' ');
        for (Producto p : insuficiente) {
            lista += centrar(p.toString(), ' ');
        }
        return lista;
    }

    private void reporteMasVendidos() {
        String reporte = centrar(" Productos más vendidos ", '-')
                + espacio(1)
                + listaMasVendidos()
                + espacio(1)
                + centrar("", '-');
        System.out.println(reporte);
    }

    private String listaMasVendidos() {
        ArrayList<Producto> list = this.tienda.productosArrayList();
        Producto[] productos = new Producto[list.size()];
        for (int i = 0; i < productos.length; i++) {
            productos[i] = list.get(i);
        }
        Arrays.sort(productos);

        String lista = "";
        for (int i = productos.length - 1; i >= productos.length * 2 / 3; i--) {
            lista += centrar((productos.length - i) + ". " + productos[i], ' ');
        }
        return lista;
    }

    private String listaProductos(ArrayList<Producto> productos) {
        String res = "";
        for (int i = 0; i < productos.size(); i++) {
            res += centrar((i + 1) + ". " + productos.get(i), ' ');
        }
        return res;
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private int scanOpcion(String msg, int min, int max) {
        while (true) {
            int option = scanNumero(msg);
            if (option < min || option > max) {
                System.out.println("Fuera de rango");
                continue;
            }
            return option;
        }
    }

    private int scanNumero(String msg) {
        String str;
        while (true) {
            System.out.print(msg);
            str = sc.nextLine();
            if (!isInteger(str)) {
                System.out.println("Entrada no valida");
                continue;
            }
            return Integer.parseInt(str);
        }
    }

    private double scanDecimal(String msg) {
        String str;
        while (true) {
            System.out.print(msg);
            str = sc.nextLine();
            if (!isDouble(str)) {
                System.out.println("Entrada no valida");
                continue;
            }
            return Double.parseDouble(str);
        }
    }

    private String scanTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    private String centrar(String str, char relleno) {
        if (str.length() + 2 > ANCHO) {
            System.out.println("adv: texto muy ancho");
        }

        String res = "|";
        String offset = "";
        for (int i = 0; i < (ANCHO - (2 + str.length())) / 2; i++) {
            offset += relleno;
        }
        return res + offset + str + offset + (str.length() % 2 == 1 ? "" : relleno) + res + "\n";
    }

    private String espacio(int lineas) {
        String linea = "|";
        for (int j = 0; j < ANCHO - 2; j++) {
            linea += " ";
        }
        linea += "|";

        String res = linea;
        for (int i = 1; i < lineas - 2; i++) {
            res += "\n" + linea;
        }
        return res + "\n";
    }

    public void cerrar() {
        sc.close();
    }

    public static void main(String[] args) {
        StoreUI tienda = new StoreUI();
        tienda.mostrarMenu();
        tienda.cerrar();
    }

}