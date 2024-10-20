package Modelo;

public class Autor {
    String nombre;
    String[] apellidos = new String[2];
    boolean premioPlaneta;

    public String getNombreCompleto() {
        return nombre + " " + apellidos[0] + " " + apellidos[1];
    }

    public boolean isPremioPlaneta() {
        return premioPlaneta;
    }
}
