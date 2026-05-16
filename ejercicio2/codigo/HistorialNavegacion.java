import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class HistorialNavegacion {
    private Stack<Pagina> pilaPaginas;

    public HistorialNavegacion() {
        this.pilaPaginas = new Stack<>();
    }

    public void visitarNuevaPagina(Pagina pagina) {
        pilaPaginas.push(pagina);
        System.out.println("Página visitada: " + pagina.getTitulo() + " (" + pagina.getUrl() + ")");
    }

    public void volverPaginaAnterior() {
        if (pilaPaginas.isEmpty()) {
            System.out.println("No hay historial de navegación.");
        } else {
            Pagina paginaActual = pilaPaginas.pop();
            System.out.println("Saliendo de la página: " + paginaActual.getTitulo());
            if (!pilaPaginas.isEmpty()) {
                Pagina paginaAnterior = pilaPaginas.peek();
                System.out.println("Volviendo a: " + paginaAnterior.getTitulo());
            } else {
                System.out.println("El historial está vacío ahora.");
            }
        }
    }

    public void mostrarHistorialActual() {
        if (pilaPaginas.isEmpty()) {
            System.out.println("El historial está vacío.");
        } else {
            System.out.println("--- Historial de Navegación ---");
            for (int i = pilaPaginas.size() - 1; i >= 0; i--) {
                System.out.println(pilaPaginas.get(i));
            }
        }
    }

    public void buscarPagina(String url) {
        boolean encontrada = false;
        for (Pagina p : pilaPaginas) {
            if (p.getUrl().equals(url)) {
                System.out.println("Página encontrada en el historial: " + p);
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("La página con URL " + url + " no fue visitada.");
        }
    }

    public void ordenarPaginasAlfabeticamente() {
        if (pilaPaginas.isEmpty()) {
            System.out.println("No hay historial para ordenar.");
            return;
        }
        List<Pagina> listaAuxiliar = new ArrayList<>(pilaPaginas);
        Collections.sort(listaAuxiliar, new Comparator<Pagina>() {
            @Override
            public int compare(Pagina p1, Pagina p2) {
                return p1.getTitulo().compareToIgnoreCase(p2.getTitulo());
            }
        });

        System.out.println("--- Reporte de Páginas Visitadas (Alfabético) ---");
        for (Pagina p : listaAuxiliar) {
            System.out.println(p);
        }
    }
}
