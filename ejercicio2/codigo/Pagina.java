public class Pagina {
    private String url;
    private String titulo;

    public Pagina(String url, String titulo) {
        this.url = url;
        this.titulo = titulo;
    }

    public String getUrl() { return url; }
    public String getTitulo() { return titulo; }

    @Override
    public String toString() {
        return "Pagina{" +
                "url='" + url + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
