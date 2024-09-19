import java.util.Scanner;
public class App {
    /*
     * Este código solicitará al usuario tres números enteros e imprimirá el mayor
     */
    public static void main(String[] args) throws Exception {
        // Referencia a la clase Scanner
        Scanner scanRef = new Scanner(System.in);
        int mayor;

        System.out.println("Escriba un número entero: ");
        int primerNumero = scanRef.nextInt();

        System.out.println("Escriba otro número entero: ");
        int segundoNumero = scanRef.nextInt();

        System.out.println("Escriba otro número entero: ");
        int tercerNumero = scanRef.nextInt();

        if (primerNumero<segundoNumero) {
            mayor = segundoNumero;
        }
        else{
            mayor = primerNumero;
        }

        if (mayor<tercerNumero) {
            mayor = tercerNumero;
        }

        System.out.printf("El mayor número es %d", mayor);

        scanRef.close();
    }
}
