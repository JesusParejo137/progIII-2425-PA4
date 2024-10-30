public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;

    //Método constructor
    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString() {
        return "Libro{ Título='" + titulo + "', autor='" + autor + "', año de publicación=" + anioPublicacion + "}";
    }
}
