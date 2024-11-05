public class App {
    public static void main(String[] args) throws Exception {
        OperacionesCRUD biblioteca = new OperacionesCRUD();

        // Prueba de CREATE
        biblioteca.agregarLibro("1234", "El Quijote", "Miguel de Cervantes", 1605);
        biblioteca.agregarLibro("5678", "Orgullo y Prejuicio", "Jane Austen", 1813);

        // Prueba de READ
        biblioteca.mostrarLibros();

        // Prueba de UPDATE
        biblioteca.actualizarLibro("1234", "Don Quijote de la Mancha", "Miguel de Cervantes Saavedra", 1615);
        biblioteca.mostrarLibros();

        // Prueba de DELETE
        biblioteca.eliminarLibro("5678");
        biblioteca.mostrarLibros();
    }
}