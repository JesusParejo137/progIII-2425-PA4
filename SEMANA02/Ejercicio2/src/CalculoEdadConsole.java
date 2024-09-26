import java.time.LocalDate; //java.time es el paquete o package y LocalDate la clase
import java.io.Console; //java.io es el paquete o package y Console la clase

public class CalculoEdadConsole {
    public static void main(String[] args) throws Exception {
        Console consoleRef = System.console();
        int anioActual = LocalDate.now().getYear();
        System.out.println("Estamos en el año " + anioActual);
        String anioNacimiento = consoleRef.readLine("Escriba el año de su nacimiento: "); //Console solo puede tomar datos en forma String
        int edad = anioActual - Integer.parseInt((anioNacimiento)); //Por tanto tenemos que convertirlos a enteros para hacer una operación matemática
        System.out.println("Su edad es " + edad);
    }
}