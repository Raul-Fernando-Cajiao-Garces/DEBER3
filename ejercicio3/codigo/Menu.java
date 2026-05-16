import java.util.Scanner;

public class Menu {
    private Inventario inventario;
    private Scanner scanner;

    public Menu() {
        this.inventario = new Inventario();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n=== Sistema de Inventario de Productos ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar todos los productos");
            System.out.println("3. Buscar un producto por código");
            System.out.println("4. Ordenar productos por precio de menor a mayor");
            System.out.println("5. Mostrar los productos con stock menor a 5 unidades");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                ejecutarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
            }
        } while (opcion != 6);
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.print("Ingrese el código del producto: ");
                String codigo = scanner.nextLine();
                System.out.print("Ingrese el nombre del producto: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el precio: ");
                double precio = Double.parseDouble(scanner.nextLine());
                System.out.print("Ingrese el stock: ");
                int stock = Integer.parseInt(scanner.nextLine());
                Producto producto = new Producto(codigo, nombre, precio, stock);
                inventario.agregarProducto(producto);
                break;
            case 2:
                inventario.listarProductos();
                break;
            case 3:
                System.out.print("Ingrese el código a buscar: ");
                String codBusqueda = scanner.nextLine();
                inventario.buscarProductoPorCodigo(codBusqueda);
                break;
            case 4:
                inventario.ordenarPorPrecio();
                break;
            case 5:
                inventario.mostrarStockBajo();
                break;
            case 6:
                System.out.println("Saliendo del inventario...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
