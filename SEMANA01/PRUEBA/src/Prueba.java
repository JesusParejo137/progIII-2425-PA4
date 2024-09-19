import java.util.Scanner;
public class Prueba {
    /*
     * Este código solicitará al usuario dos números enteros e imprimirá la suma
     */
    public static void main(String[] args) throws Exception {
        // Referencia a la clase Scanner
        Scanner scanRef = new Scanner(System.in);

        System.out.println("Escriba un número entero: ");
        int primerNumero = scanRef.nextInt();

        System.out.println("Escriba otro número entero: ");
        int segundoNumero = scanRef.nextInt();

        int suma = primerNumero + segundoNumero;

        System.out.printf("La suma es %d", suma);

        scanRef.close();
    }
}
