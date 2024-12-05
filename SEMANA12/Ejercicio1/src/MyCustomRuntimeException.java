public class MyCustomRuntimeException extends RuntimeException{
    public MyCustomRuntimeException(String msg) {
        super("Esto es una excepción en tiempo de ejecución: " + msg);
    }
}
