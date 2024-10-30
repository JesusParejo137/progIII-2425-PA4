public class App {
    public static void main(String[] args) throws Exception {
        OperacionesCRUD biblioteca = new OperacionesCRUD();

        // Prueba de CREATE
        biblioteca.agregarLibro("978-3-16-148410-0", "El Quijote", "Miguel de Cervantes", 1605);
        biblioteca.agregarLibro("978-0-13-468599-1", "Java: The Complete Reference", "Herbert Schildt", 2018);

        // Prueba de READ
        biblioteca.mostrarLibros();

        // Prueba de UPDATE
        biblioteca.actualizarLibro("978-3-16-148410-0", "Don Quijote de la Mancha", "Miguel de Cervantes Saavedra", 1615);
        biblioteca.mostrarLibros();

        // Prueba de DELETE
        biblioteca.eliminarLibro("978-0-13-468599-1");
        biblioteca.mostrarLibros();
    }
}
