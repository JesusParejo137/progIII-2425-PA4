import java.util.Scanner;

public class Lector {
    public static Scanner scannerRef = new Scanner(System.in);

    public static String leerCadena() {
        return scannerRef.nextLine();
    }

    public static int leerEntero(String prompt) {
        int numero;
        
        while (true) {
            try {
                numero = Integer.parseInt(prompt);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ese no es un numero válido. Vuelve a intentarlo: ");
                prompt = leerCadena();
            }
        }
        return numero;
    }
    public static double leerDouble(String prompt) {
        double numero;
        
        while (true) {
            try {
                numero = Double.parseDouble(prompt);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ese no es un numero válido. Vuelve a intentarlo: ");
                prompt = leerCadena();
            }
        }
        return numero;
    }
    public static float leerFloat(String prompt) {
        float numero;
        
        while (true) {
            try {
                numero = Float.parseFloat(prompt);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ese no es un numero válido. Vuelve a intentarlo: ");
                prompt = leerCadena();
            }
        }
        return numero;
    }
}
