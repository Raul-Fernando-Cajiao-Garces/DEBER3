public class Tarea {
    private String codigo;
    private String descripcion;
    private int prioridad; // 1 (alta) a 5 (baja)
    private boolean completada;

    public Tarea(String codigo, String descripcion, int prioridad) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false; // Por defecto no está completada
    }

    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public int getPrioridad() { return prioridad; }
    public boolean isCompletada() { return completada; }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", prioridad=" + prioridad +
                ", completada=" + (completada ? "Sí" : "No") +
                '}';
    }
}
