package datos;

public class Persona {
    private String nombre = "sin nombre";
    private double peso = 0.0;
    private double talla = 0.0;

    //Constructor sin parámetros
    public Persona() {
        this.nombre = "Nombre por defecto";
        this.peso = 70;
        this.talla = 1.70;
    }

    //Getters y Setters
    public Persona(String paramNombre) {
        this.nombre = paramNombre;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPeso() {
        return peso;
    }
    public double getTalla() {
        return talla;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setTalla(double talla) {
        this.talla = talla;
    }

    //Método que devuelve el índice del más pesado del array
    public static int masPesado(Persona[] personas) {
        int j = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i].getPeso() >= personas[j].getPeso()) {
                j = i;
            }
        }
        return j;
    }

    //Método que devuelve el índice del más alto del array
    public static int masAlto(Persona[] personas) {
        int j = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i].getTalla() >= personas[j].getTalla()) {
                j = i;
            }
        }
        return j;
    }

    //Método que devuelve el IMC de la persona
    public double calcularIMC(){
        return (peso/(talla*talla));
    }
}