import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Concesionario concesionario = new Concesionario();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); //Limpiar el \n que se queda después de escribir un int
                    System.out.println("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.println("Año de fabricación: ");
                    int anio = scanner.nextInt();
                    concesionario.agregarCoche(id, marca, anio);
                    break;
                
                case 2:
                    concesionario.mostrarCoches();
                    break;

                case 3:
                    System.out.println("ID del coche a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nueva marca: ");
                    String nuevaMarca = scanner.nextLine();
                    System.out.println("Nuevo año de fabricación: ");
                    int nuevoAnio = scanner.nextInt();
                    System.out.println("Disponibilidad: ");
                    boolean nuevoDisponible = scanner.nextBoolean();
                    concesionario.modificarCoche(idActualizar, nuevaMarca, nuevoAnio, nuevoDisponible);
                    break;
                case 4:
                    System.out.println("ID del coche a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    concesionario.eliminarCoche(idEliminar);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }
    public static void mostrarMenu() {
        System.out.println("\n--- Menú Concesionario ---");
        System.out.println("1. Agregar un coche");
        System.out.println("2. Mostrar todos los coches");
        System.out.println("3. Actualizar un coche");
        System.out.println("4. Eliminar un coche");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
