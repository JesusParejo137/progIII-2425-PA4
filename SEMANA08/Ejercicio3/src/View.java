import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("1. Cargar archivo TSV");
        System.out.println("2. Mostrar datos en forma tabular");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public void mostrarDatos(List<Persona> personas) {
        String[] header = Persona.getHeader();
        System.out.printf("%-15s %-15s %-10s%n", header[0], header[1], header[2]);
        for (Persona p : personas) {
            System.out.printf("%-15s %-15s %-10.2f%n", p.getNombre(), p.getTelefono(), p.getPeso());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String pedirRutaArchivo() {
        System.out.print("Ingrese el nombre del archivo TSV en el escritorio: ");
        String nombreArchivo = scanner.next();
        String rutaCompleta = System.getProperty("user.home") + "/Desktop/" + nombreArchivo;
        System.out.println("Ruta completa del archivo: " + rutaCompleta);  // Verifica la ruta
        return rutaCompleta;
    }

    public boolean confirmarSalida() {
        System.out.print("¿Está seguro de que quiere salir? (s/n): ");
        String respuesta = scanner.next();
        return respuesta.equalsIgnoreCase("s");
    }
}