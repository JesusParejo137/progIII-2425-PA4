public class Persona {
    private String nombre;
    private String telefono;
    private double peso;

    public Persona(String nombre, String telefono, double peso) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getPeso() {
        return peso;
    }

    public String[] toRow() {
        return new String[]{nombre, telefono, String.valueOf(peso)};
    }

    public static String[] getHeader() {
        return new String[]{"Nombre", "Teléfono", "Peso"};
    }

    @Override
    public String toString() {
        return nombre + "\t" + telefono + "\t" + peso;
    }
}