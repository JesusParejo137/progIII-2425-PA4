import java.util.Scanner;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scannerRef = new Scanner(System.in);

        System.out.println("Introduce 5 palabras y te las ordenaré alfabéticamente: ");
        String[] palabras = new String[5];
        for (int i = 0; i < palabras.length; i++) {
            while (true) {
                try {
                    palabras[i] = scannerRef.nextLine();
                    break;
                } catch (Exception e) {
                    scannerRef.next();
                    System.out.println("Error inesperado. Vuelve a intentarlo: ");
                }
            }
        }

        Arrays.sort(palabras);
        System.out.println(Arrays.toString(palabras));

        System.out.println("Introduce 5 números enteros y te los ordenaré: ");
        int[] numeros = new int[5];
        for (int i = 0; i < numeros.length; i++) {
            while (true) {
                try {
                    numeros[i] = scannerRef.nextInt();
                    break;
                } catch (Exception e) {
                    scannerRef.next();
                    System.out.println("Eso no es un número entero. Vuelve a intentarlo: ");
                }
            }
        }
        Arrays.sort(numeros);
        System.out.println(Arrays.toString(numeros));
    }
}
