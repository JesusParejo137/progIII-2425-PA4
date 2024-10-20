import com.coti.tools.Esdia;

import Modelo.Almacen;
import Modelo.Libro;
import Modelo.Autor;

public class App {
    public static void main(String[] args) throws Exception {
        Almacen almacenRef = null;
        int opcion;
        do {
            mostrarMenu();
            opcion = Esdia.readInt(" ", 1, 5);
            switch (opcion) {
                case 1:
                    int tamanio = Esdia.readInt("Introduce el tamaño del almacén que quieres crear: ", 0, 100);
                    almacenRef = new Almacen(tamanio);
                    System.out.println("Almacén creado con éxito.");
                    break;
                case 2:
                    if (almacenRef != null) {
                        System.out.print("Ingrese el ritmo de lectura (páginas por minuto): ");
                        int ritmo = Esdia.readInt("");
                        almacenRef.setRitmoLectura(ritmo);
                    } else {
                        System.out.println("Primero debe crear un almacén.");
                    }
                    break;
                case 3:
                    if (almacenRef != null) {
                        aniadirLibro(almacenRef);
                    } else {
                        System.out.println("Primero debes crear un almacén.");
                    }
                    break;
                case 4:
                    if (almacenRef != null) {
                        almacenRef.mostrarLibros();
                    } else {
                        System.out.println("Primero debe crear un almacén.");
                    }
                    break;
                case 5:
                    System.out.println("Hasta la próxima!");
                    break;
                default:
                    break;
            }
        } while (opcion != 5);
    }

    public static void mostrarMenu() {
        int totalLength = 46;
        String lineaSeparacion = "|" + "-".repeat(totalLength) + "|";
        String inicial = String.format("| %-" + (totalLength-2) + "s |", "MIS LIBROS");
        String[] opciones = new String[5];
        opciones[0] = new String("Nuevo almacén de libros");
        opciones[1] = new String("Establecer ritmo de lectura (páginas por minuto)");
        opciones[2] = new String("Añadir nuevo libro al almacén");
        opciones[3] = new String("Mostrar información actual de libros");
        opciones[4] = new String("Salir (se borrará toda la información)");
        
        System.out.println(lineaSeparacion);
        System.out.printf(inicial + "\n");
        System.out.println(lineaSeparacion);
        for (int i = 0; i < opciones.length; i++) {
            System.out.println("   " + (i+1) + ". " + opciones[i]);
        }
        System.out.println(lineaSeparacion + "\n");
        System.out.println("Seleccione una opción (1-4)");
    }

    public static void aniadirLibro(Almacen almacenRef) {
        System.out.println("Introduce los datos pedidos para el nuevo libro que quieres añadir: ");
        String titulo = Esdia.readString("Título: ");
        String nombreCompleto = Esdia.readString("Nombre y apellidos del autor: ");
        int anioPublicacion = Esdia.readInt("Año de publicacion: ");
        boolean premioPlaneta = Esdia.yesOrNo("¿" + nombreCompleto + "ha recibido el Premio Planeta?");
        int numeroPaginas = Esdia.readInt("Número de páginas: ");
        double precio = Esdia.readDouble("Precio: ");

        String[] nombreSeparado = nombreCompleto.split(" ");
        Libro nuevoLibro = new Libro(nombreSeparado[0], nombreSeparado[1], nombreSeparado[2], premioPlaneta, titulo, anioPublicacion, numeroPaginas, precio);
        almacenRef.agregarLibro(nuevoLibro);
    }
}