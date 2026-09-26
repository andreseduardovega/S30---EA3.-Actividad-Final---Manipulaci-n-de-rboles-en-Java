import java.util.Scanner;

/**
 * Interfaz principal del sistema Tree-Stock.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArbolInventario inventario = new ArbolInventario();

        int opcion;

        do {
            mostrarMenu();

            opcion = leerEntero(scanner);

            switch (opcion) {

                case 1:
                    registrarProducto(scanner, inventario);
                    break;

                case 2:
                    System.out.println("\n=== INVENTARIO ORDENADO ===");
                    inventario.mostrarInventario();
                    break;

                case 3:
                    buscarProducto(scanner, inventario);
                    break;

                case 0:
                    System.out.println("Gracias por utilizar Tree-Stock.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    /**
     * Muestra las opciones disponibles del sistema.
     */
    private static void mostrarMenu() {

        System.out.println("\n=========================");
        System.out.println("       TREE-STOCK");
        System.out.println("=========================");
        System.out.println("1. Registrar Producto");
        System.out.println("2. Mostrar Inventario");
        System.out.println("3. Buscar Producto");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Registra un nuevo producto en el árbol.
     */
    private static void registrarProducto(
            Scanner scanner,
            ArbolInventario inventario) {

        System.out.print("Ingrese el ID del producto: ");
        int id = leerEntero(scanner);

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre del producto no puede estar vacío.");
            return;
        }

      
boolean registrado = inventario.insertar(id, nombre);

if (registrado) {
    System.out.println("Producto registrado correctamente.");
} else {
    System.out.println(
            "No se registró el producto: el ID " + id + " ya existe."
    );
}
    }

    /**
     * Busca un producto utilizando su ID.
     */
    private static void buscarProducto(
            Scanner scanner,
            ArbolInventario inventario) {

        System.out.print("Ingrese el ID que desea buscar: ");
        int id = leerEntero(scanner);

        Producto producto = inventario.buscar(id);

        if (producto != null) {
            System.out.println("Producto encontrado:");
            System.out.println(
                    "ID: " + producto.id +
                    " | Nombre: " + producto.nombre
            );
        } else {
            System.out.println(
                    "No existe un producto con el ID " + id + "."
            );
        }
    }

    /**
     * Lee un número entero y evita que una entrada no numérica
     * interrumpa el programa.
     */
    private static int leerEntero(Scanner scanner) {

        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            scanner.nextLine();
        }

        int numero = scanner.nextInt();
        scanner.nextLine();

        return numero;
    }
}