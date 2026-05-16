import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Inventario {
    private List<Producto> listaProductos;

    public Inventario() {
        this.listaProductos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
        System.out.println("Producto agregado exitosamente: " + producto.getNombre());
    }

    public void listarProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("--- Lista de Productos ---");
            for (Producto p : listaProductos) {
                System.out.println(p);
            }
        }
    }

    public void buscarProductoPorCodigo(String codigo) {
        boolean encontrado = false;
        for (Producto p : listaProductos) {
            if (p.getCodigo().equals(codigo)) {
                System.out.println("Producto encontrado: " + p);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto con código " + codigo + " no encontrado.");
        }
    }

    public void ordenarPorPrecio() {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos para ordenar.");
            return;
        }
        List<Producto> listaAuxiliar = new ArrayList<>(listaProductos);
        Collections.sort(listaAuxiliar, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return Double.compare(p1.getPrecio(), p2.getPrecio());
            }
        });

        System.out.println("--- Productos Ordenados por Precio (Menor a Mayor) ---");
        for (Producto p : listaAuxiliar) {
            System.out.println(p);
        }
    }

    public void mostrarStockBajo() {
        System.out.println("--- Productos con Stock Menor a 5 ---");
        boolean hayStockBajo = false;
        for (Producto p : listaProductos) {
            if (p.getStock() < 5) {
                System.out.println(p);
                hayStockBajo = true;
            }
        }
        if (!hayStockBajo) {
            System.out.println("No hay productos con stock menor a 5 unidades.");
        }
    }
}
