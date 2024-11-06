import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Libro> biblioteca = new ArrayList<>();
        biblioteca.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, 471));
        biblioteca.add(new Libro("El Aleph", "Jorge Luis Borges", 1949, 157));
        biblioteca.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605, 863));
        biblioteca.add(new Libro("Rayuela", "Julio Cortázar", 1963, 600));
        biblioteca.add(new Libro("1984", "George Orwell", 1949, 328));

        System.out.println("Orden natural (por título):");
        Collections.sort(biblioteca);
        for (Libro libro : biblioteca) {
            System.out.println(libro);
        }

        System.out.println("\nOrden por autor:");
        Collections.sort(biblioteca, new ComparadorPorAutor());
        for (Libro libro : biblioteca) {
            System.out.println(libro);
        }

        System.out.println("\nOrden por año de publicación:");
        Collections.sort(biblioteca, new ComparadorPorAño());
        for (Libro libro : biblioteca) {
            System.out.println(libro);
        }

        System.out.println("\nOrden por número de páginas:");
        Collections.sort(biblioteca, new ComparadorPorPaginas());
        for (Libro libro : biblioteca) {
            System.out.println(libro);
        }
    }
}
