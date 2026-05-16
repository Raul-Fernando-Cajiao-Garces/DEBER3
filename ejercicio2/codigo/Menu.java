import java.util.Scanner;

public class Menu {
    private HistorialNavegacion historial;
    private Scanner scanner;

    public Menu() {
        this.historial = new HistorialNavegacion();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n=== Sistema de Historial de Navegación ===");
            System.out.println("1. Visitar una nueva página");
            System.out.println("2. Volver a la página anterior");
            System.out.println("3. Mostrar el historial actual");
            System.out.println("4. Buscar si una página fue visitada");
            System.out.println("5. Ordenar alfabéticamente las páginas visitadas");
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
                System.out.print("Ingrese la URL de la página: ");
                String url = scanner.nextLine();
                System.out.print("Ingrese el título de la página: ");
                String titulo = scanner.nextLine();
                Pagina pagina = new Pagina(url, titulo);
                historial.visitarNuevaPagina(pagina);
                break;
            case 2:
                historial.volverPaginaAnterior();
                break;
            case 3:
                historial.mostrarHistorialActual();
                break;
            case 4:
                System.out.print("Ingrese la URL a buscar: ");
                String urlBusqueda = scanner.nextLine();
                historial.buscarPagina(urlBusqueda);
                break;
            case 5:
                historial.ordenarPaginasAlfabeticamente();
                break;
            case 6:
                System.out.println("Saliendo del historial...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
