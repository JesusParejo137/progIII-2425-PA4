package Modelo;

public class Libro {
    Autor autor = new Autor();
    String titulo;
    int anioPublicacion;
    int numeroPaginas;
    double precio;

    public Libro(String nombreAutor, String apellido1, String apellido2, boolean premioPlaneta, String titulo, int anioPublicacion, int numeroPaginas, double precio) {
        this.autor.nombre = nombreAutor;
        this.autor.apellidos[0] = apellido1;
        this.autor.apellidos[1] = apellido2;
        this.autor.premioPlaneta = premioPlaneta;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.numeroPaginas = numeroPaginas;
        this.precio = precio;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public double getPrecio() {
        return precio;
    }

    public int calcularTiempoLectura(int ritmoLectura) {
        return numeroPaginas / ritmoLectura;
    }
}
