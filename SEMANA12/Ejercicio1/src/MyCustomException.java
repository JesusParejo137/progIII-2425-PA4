public class MyCustomException extends Exception{
    public MyCustomException(String msg) {
        super("Esto es una excepción en tiempo de compilación: " + msg);
    }
}