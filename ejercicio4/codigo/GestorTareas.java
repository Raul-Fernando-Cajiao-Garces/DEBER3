import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class GestorTareas {
    private List<Tarea> listaTareas;
    private Stack<Tarea> tareasCompletadas;

    public GestorTareas() {
        this.listaTareas = new ArrayList<>();
        this.tareasCompletadas = new Stack<>();
    }

    public void registrarTarea(Tarea tarea) {
        listaTareas.add(tarea);
        System.out.println("Tarea registrada con éxito: " + tarea.getDescripcion());
    }

    public void buscarTareaPorCodigo(String codigo) {
        boolean encontrada = false;
        for (Tarea t : listaTareas) {
            if (t.getCodigo().equals(codigo)) {
                System.out.println("Tarea encontrada: " + t);
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("Tarea con código " + codigo + " no encontrada.");
        }
    }

    public void ordenarPorPrioridad() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas para ordenar.");
            return;
        }
        List<Tarea> listaAuxiliar = new ArrayList<>(listaTareas);
        Collections.sort(listaAuxiliar, new Comparator<Tarea>() {
            @Override
            public int compare(Tarea t1, Tarea t2) {
                // Ordenar por prioridad (menor número = mayor prioridad)
                return Integer.compare(t1.getPrioridad(), t2.getPrioridad());
            }
        });

        System.out.println("--- Tareas Ordenadas por Prioridad ---");
        for (Tarea t : listaAuxiliar) {
            System.out.println(t);
        }
    }

    public void marcarComoCompletada(String codigo) {
        for (Tarea t : listaTareas) {
            if (t.getCodigo().equals(codigo) && !t.isCompletada()) {
                t.setCompletada(true);
                tareasCompletadas.push(t);
                System.out.println("Tarea marcada como completada y movida a la pila: " + t.getDescripcion());
                return;
            }
        }
        System.out.println("Tarea no encontrada o ya estaba completada.");
    }

    public void mostrarUltimaTareaCompletada() {
        if (tareasCompletadas.isEmpty()) {
            System.out.println("No hay tareas completadas en la pila.");
        } else {
            System.out.println("Última tarea completada: " + tareasCompletadas.peek());
        }
    }
}
