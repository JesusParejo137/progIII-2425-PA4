import java.util.Arrays;

import com.coti.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Argumentos: " + Arrays.toString(args));

        if (args.length == 4) {
            double suma = Double.parseDouble(args[2]) + Double.parseDouble(args[3]);
            double tercerNumero = Esdia.readDouble("numero: \n");
            suma = suma + tercerNumero;
            System.out.println(suma);
        } else {
            System.out.println("No hay suficientes argumentos para la suma");
        }
        
    }
}
