import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scannerRef = new Scanner(System.in);

        System.out.println("Soy una máquina capaz de leer todos los tipos de datos numéricos, elige una opción para que la lea:");
        System.out.println("(a) Entero");
        System.out.println("(b) Double");
        System.out.println("(c) Float");
        
        try {
            char opcion = scannerRef.nextLine().charAt(0);
            validarOpcion(opcion);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado");
        } finally {
            scannerRef.close();
        }
        
    }
    public static void validarOpcion(char o) {
        if (o == 'a' || o == 'b' || o == 'c') {
            System.out.println("Opción válida");
        } else {
            throw new IllegalArgumentException("Error: La opción debe ser a, b ó c");
        }
    }
}