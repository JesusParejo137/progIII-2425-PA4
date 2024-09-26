import com.coti.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hola, estoy utilizando la Biblioteca11");
        int pruebaInt = Esdia.readInt("Escriba un número entero: ",18,35 );
        System.out.println(pruebaInt);
        String pruebaString = Esdia.readString("Escriba una palabra: ");
        System.out.println(pruebaString);
    }
}
