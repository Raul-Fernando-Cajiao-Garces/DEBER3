import java.util.Scanner;

public class Menu {
    private GestorTareas gestor;
    private Scanner scanner;

    public Menu() {
        this.gestor = new GestorTareas();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n=== Sistema de Control de Tareas Académicas ===");
            System.out.println("1. Registrar tarea en una lista");
            System.out.println("2. Buscar una tarea por código");
            System.out.println("3. Ordenar las tareas por prioridad");
            System.out.println("4. Marcar una tarea como completada");
            System.out.println("5. Mostrar la última tarea completada");
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
                System.out.print("Ingrese el código de la tarea: ");
                String codigo = scanner.nextLine();
                System.out.print("Ingrese la descripción de la tarea: ");
                String descripcion = scanner.nextLine();
                System.out.print("Ingrese la prioridad (1=Alta, 5=Baja): ");
                int prioridad = Integer.parseInt(scanner.nextLine());
                Tarea tarea = new Tarea(codigo, descripcion, prioridad);
                gestor.registrarTarea(tarea);
                break;
            case 2:
                System.out.print("Ingrese el código a buscar: ");
                String codBusqueda = scanner.nextLine();
                gestor.buscarTareaPorCodigo(codBusqueda);
                break;
            case 3:
                gestor.ordenarPorPrioridad();
                break;
            case 4:
                System.out.print("Ingrese el código de la tarea a marcar como completada: ");
                String codCompletar = scanner.nextLine();
                gestor.marcarComoCompletada(codCompletar);
                break;
            case 5:
                gestor.mostrarUltimaTareaCompletada();
                break;
            case 6:
                System.out.println("Saliendo del control de tareas...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
