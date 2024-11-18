package model;
import java.util.Random;

class Direccion {
    private String calle;
    private int numero;
    private int piso;
    private String letra;

    public Direccion(String calle, int numero, int piso, String letra) {
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.letra = letra;
    }

    public static Direccion generarAleatoria() {
        String[] calles = {"Gran Via", "Calle Mayor", "Avenida del Sol", "Calle Luna"};
        Random rand = new Random();
        String calle = calles[rand.nextInt(calles.length)];
        int numero = rand.nextInt(100) + 1;
        int piso = rand.nextInt(10) + 1;
        char letra = (char) (rand.nextInt(26) + 'A');
        return new Direccion(calle, numero, piso, String.valueOf(letra));
    }

    @Override
    public String toString() {
        return calle + ", " + numero + ", Piso " + piso + ", Letra " + letra;
    }
}