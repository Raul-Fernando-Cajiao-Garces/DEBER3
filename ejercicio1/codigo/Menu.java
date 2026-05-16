import java.util.Scanner;

public class Menu {
    private GestionTurnos gestionTurnos;
    private Scanner scanner;

    public Menu() {
        this.gestionTurnos = new GestionTurnos();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n=== Sistema de Gestión de Turnos Clínica ===");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Atender al siguiente paciente");
            System.out.println("3. Mostrar todos los pacientes en espera");
            System.out.println("4. Buscar un paciente por cédula");
            System.out.println("5. Ordenar los pacientes en espera alfabéticamente por nombre");
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
                System.out.print("Ingrese la cédula del paciente: ");
                String cedula = scanner.nextLine();
                System.out.print("Ingrese el nombre del paciente: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el tipo de consulta: ");
                String tipoConsulta = scanner.nextLine();
                Paciente paciente = new Paciente(cedula, nombre, tipoConsulta);
                gestionTurnos.registrarPaciente(paciente);
                break;
            case 2:
                gestionTurnos.atenderSiguientePaciente();
                break;
            case 3:
                gestionTurnos.mostrarPacientesEnEspera();
                break;
            case 4:
                System.out.print("Ingrese la cédula a buscar: ");
                String cedBusqueda = scanner.nextLine();
                gestionTurnos.buscarPacientePorCedula(cedBusqueda);
                break;
            case 5:
                gestionTurnos.ordenarPacientesAlfabeticamente();
                break;
            case 6:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
