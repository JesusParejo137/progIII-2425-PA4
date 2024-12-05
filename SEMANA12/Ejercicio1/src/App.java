import com.coti.tools.Esdia;

public class App {
    public static void main(String[] args) {
        int edad = Esdia.readInt("Introduzca su edad: ");

        try {
            comprobarEdad(edad);
        } catch (MyCustomException | MyCustomRuntimeException e) {
            e.printStackTrace();
        }

    }

    public static void comprobarEdad(int num) throws MyCustomRuntimeException, MyCustomException {

        if(num < 0) {
            throw new MyCustomException("Error fatal. Edad inválida");
        } else {
            if (num < 18) {
                throw new MyCustomRuntimeException("Error. Es menor de edad");
            }
            System.out.println("Es mayor de edad");
        }
    }
}
