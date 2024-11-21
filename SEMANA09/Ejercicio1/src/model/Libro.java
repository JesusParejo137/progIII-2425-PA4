package model;

public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private int paginas;
    private double precio;

    // Constructor sin parámetros
    public Libro() {
        this.titulo = "";
        this.autor = "";
        this.anioPublicacion = 0;
        this.paginas = 0;
        this.precio = 0.0;
    }

    // Getters y setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //
    //@Override
    //public String toString(){
    //    return "Libro[titulo=" + this.titulo + ", autor=" + this.autor + ", año de publicación=" + anioPublicacion + ", número de páginas=" + paginas + ", precio=" + this.precio + "]";
    // }

    @Override
    public String toString(){
        
    }
    
}