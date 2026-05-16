import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GestionTurnos {
    private Queue<Paciente> colaPacientes;

    public GestionTurnos() {
        this.colaPacientes = new LinkedList<>();
    }

    public void registrarPaciente(Paciente paciente) {
        colaPacientes.offer(paciente);
        System.out.println("Paciente registrado con éxito: " + paciente.getNombre());
    }

    public void atenderSiguientePaciente() {
        Paciente pacienteAtendido = colaPacientes.poll();
        if (pacienteAtendido != null) {
            System.out.println("Atendiendo a: " + pacienteAtendido.getNombre() + " (Consulta: " + pacienteAtendido.getTipoConsulta() + ")");
        } else {
            System.out.println("No hay pacientes en espera.");
        }
    }

    public void mostrarPacientesEnEspera() {
        if (colaPacientes.isEmpty()) {
            System.out.println("No hay pacientes en espera.");
        } else {
            System.out.println("--- Pacientes en Espera ---");
            for (Paciente p : colaPacientes) {
                System.out.println(p);
            }
        }
    }

    public void buscarPacientePorCedula(String cedula) {
        boolean encontrado = false;
        for (Paciente p : colaPacientes) {
            if (p.getCedula().equals(cedula)) {
                System.out.println("Paciente encontrado: " + p);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Paciente con cédula " + cedula + " no encontrado en la cola de espera.");
        }
    }

    public void ordenarPacientesAlfabeticamente() {
        if (colaPacientes.isEmpty()) {
            System.out.println("No hay pacientes para ordenar.");
            return;
        }
        List<Paciente> listaAuxiliar = new ArrayList<>(colaPacientes);
        Collections.sort(listaAuxiliar, new Comparator<Paciente>() {
            @Override
            public int compare(Paciente p1, Paciente p2) {
                return p1.getNombre().compareToIgnoreCase(p2.getNombre());
            }
        });

        System.out.println("--- Pacientes Ordenados Alfabéticamente ---");
        for (Paciente p : listaAuxiliar) {
            System.out.println(p);
        }
    }
}
