import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class OperacionesCRUD {
    private HashMap<String, Libro> biblioteca = new HashMap<>();

    //Método Create
    public void agregarLibro(String isbn, String titulo, String autor, int anioPublicacion) {
        if (biblioteca.containsKey(isbn)) {
            System.out.println("La biblioteca ya contiene un libro con ISBN: " + isbn);
        } else {
            Libro nuevLibro = new Libro(titulo, autor, anioPublicacion);
            biblioteca.put(isbn, nuevLibro);
            System.out.println("Libro agregado: " + nuevLibro);
        }
    }

    //Método Read
    public void mostrarLibros() {
        if (biblioteca.isEmpty()) {
            System.out.println("La biblioteca no tiene libros registrados");
            return;
        }
        System.out.println("Lista de libros en la biblioteca:");
        for (Map.Entry<String, Libro> entry : biblioteca.entrySet()) {
            String isbn = entry.getKey();
            Libro libro = entry.getValue();
            System.out.println(String.format("ISBN: %9s - %s", isbn, libro.toString()));
        }
    }

    //Método Update
    public void actualizarLibro(String isbn, String nuevoTitulo, String nuevoAutor, int nuevoAnioPublicacion) {
        if (biblioteca.containsKey(isbn)) {
            Libro libroModificado = new Libro(nuevoTitulo, nuevoAutor, nuevoAnioPublicacion);
            biblioteca.put(isbn, libroModificado);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    //Método Delete
    public void eliminarLibro(String isbn) {
        if (biblioteca.containsKey(isbn)) {
            biblioteca.remove(isbn);
            System.out.println("Libro eliminado.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }
}
