package model;

public class Persona {

    private String nombre;
    private String apellido1;
    private String apellido2;

    public Persona(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    // Factory Method
    public static Persona createPersonaFromString(String delimitedString, String delimiter) throws MyCustomException {

        String[] trozos = delimitedString.split(delimiter);

        // Espero que salgan 3 trozos
        /* Así lo hacíamos antes:
        if (trozos.length != 3) {
            return null;
        }
        */
        // Ahora en lugar de devolver un null, lanzamos una excepción
        if (trozos.length != 3) {
            throw new MyCustomException("Número de campos incorrecto");
        } else {
            return new Persona(trozos[0], trozos[1], trozos[2]);
        }
    }

    
}
