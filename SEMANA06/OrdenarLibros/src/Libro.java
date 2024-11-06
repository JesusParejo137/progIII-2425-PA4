import java.util.Comparator;

public class Libro implements Comparable<Libro>{

    private String titulo;
    private String autor;
    private int anioPublicacion;
    private int numeroPaginas;

    public Libro(String titulo, String autor, int anioPublicacion, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.numeroPaginas = numeroPaginas;
    }

    // Establecemos un orden natural para el objeto Libro
    @Override
    public int compareTo(Libro otro) {
        return this.titulo.compareTo(otro.titulo); // Utilizamos el método compareTo() de la clase String
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + anioPublicacion + "), " + numeroPaginas + " páginas";
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }
}

// Comparador para ordenar por autor
class ComparadorPorAutor implements Comparator<Libro> {
    @Override
    public int compare(Libro l1, Libro l2) {
        return l1.getAutor().compareTo(l2.getAutor());
    }
}

// Comparador para ordenar por año de publicación
class ComparadorPorAño implements Comparator<Libro> {
    @Override
    public int compare(Libro l1, Libro l2) {
        return Integer.compare(l1.getAnioPublicacion(), l2.getAnioPublicacion());
    }
}

// Comparador para ordenar por número de páginas
class ComparadorPorPaginas implements Comparator<Libro> {
    @Override
    public int compare(Libro l1, Libro l2) {
        return Integer.compare(l1.getNumeroPaginas(), l2.getNumeroPaginas());
    }
}