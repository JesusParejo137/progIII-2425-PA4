import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scannerRef = new Scanner(System.in);

        System.out.println("Soy una máquina capaz de leer todos los tipos de datos numéricos, elige una opción para que la lea:");
        System.out.println("(a) Entero");
        System.out.println("(b) Double");
        System.out.println("(c) Float");
        char opcion;
        while (true) {
            try {
                opcion = scannerRef.nextLine().charAt(0);
                validarOpcion(opcion);
                break;
            } catch (IllegalArgumentException iae) {
                System.out.printf("%s Vueve a intentarlo.\n", iae.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado. Vuelve a intentarlo");
            }
        }
        
        switch (opcion) {
            case 'a':
                System.out.println("Escriba un número entero: ");
                Lector.leerEntero(scannerRef.nextLine());
                break;
            case 'b':
                System.out.println("Escriba un número entero: ");
                Lector.leerDouble(scannerRef.nextLine());
                break;
            case 'c':
                System.out.println("Escriba un número entero: ");
                Lector.leerFloat(scannerRef.nextLine());
                break;
            default:
                break;
        }
    }
    public static void validarOpcion(char o) {
        if (o == 'a' || o == 'b' || o == 'c') {
            System.out.println("Opción válida");
        } else {
            throw new IllegalArgumentException("Error: La opción debe ser a, b ó c.");
        }
    }
}