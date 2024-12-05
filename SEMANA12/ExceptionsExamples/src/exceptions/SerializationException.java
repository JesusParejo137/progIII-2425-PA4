package exceptions;

/**
 *
 * 
 * DEBES PROBAR A CAMBIAR DE QUÉ CLASE HEREDA ESTA EXCEPCION CUSTOM
 * 
 * - PRUEBA CON RuntimeException
 * - PRUEB CON Exception
 * 
 * Identifica las diferencias entre heredar de una y de otra.
 * 
 * ¿Cuando fuerza el compilador a manejar la excepción?
 * 
 * 
 * @author Loza
 */
public class SerializationException extends Exception{

    public SerializationException() {
    }

    public SerializationException(String message) {
        super(message);
    }

    public SerializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerializationException(Throwable cause) {
        super(cause);
    }

    public SerializationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
