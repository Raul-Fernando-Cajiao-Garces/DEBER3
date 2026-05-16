public class Paciente {
    private String cedula;
    private String nombre;
    private String tipoConsulta;

    public Paciente(String cedula, String nombre, String tipoConsulta) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.tipoConsulta = tipoConsulta;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipoConsulta='" + tipoConsulta + '\'' +
                '}';
    }
}
