package model;
import java.util.List;
import java.util.Random;

class DatosPersonales {
    private String nombre;
    private String apellidos;
    private int edad;
    private String nif;

    public DatosPersonales(String nombre, String apellidos, int edad, String nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.nif = nif;
    }

    public static DatosPersonales generarAleatorio(List<String> nifExistentes) {
        String[] nombres = {"Luis", "Ana", "Carlos", "Marta", "Pedro"};
        String[] apellidos = {"Gomez", "Perez", "Lopez", "Martinez", "Sanchez"};
        Random rand = new Random();
        String nombre = nombres[rand.nextInt(nombres.length)];
        String apellido = apellidos[rand.nextInt(apellidos.length)];
        int edad = rand.nextInt(50) + 18;
        String nif;

        // Generar NIF único
        do {
            nif = "N" + (rand.nextInt(90000) + 10000);
        } while (nifExistentes.contains(nif));

        nifExistentes.add(nif);
        return new DatosPersonales(nombre, apellido, edad, nif);
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + ", Edad: " + edad + ", NIF: " + nif;
    }
}