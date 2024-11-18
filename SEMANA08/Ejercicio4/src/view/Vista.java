package view;
import java.util.List;
import java.util.Scanner;

import model.DatosDeAlumno;

public class Vista {
    private Scanner scanner;

    public Vista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Volver a crear la lista de alumnos");
        System.out.println("2. Mostrar tabla de alumnos");
        System.out.println("3. Exportar datos personales (CSV)");
        System.out.println("4. Exportar direcciones (CSV)");
        System.out.println("q. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public String leerOpcion() {
        return scanner.nextLine();
    }

    public void mostrarTabla(List<DatosDeAlumno> alumnos) {
        System.out.println("\nTabla de alumnos:");
        for (DatosDeAlumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrar() {
        scanner.close();
    }
}
