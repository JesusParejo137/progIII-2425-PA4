public class Coche {
    
    private int id;
    private String marca;
    private int anio;
    private boolean disponible;

    public Coche(int id, String marca, int anio) {
        this.id = id;
        this.marca = marca;
        this.anio = anio;
        this.disponible = true;
    } 

    public int getId() {
        return this.id;
    }
    public String getMarca() {
        return this.marca;
    }
    public int getAnio() {
        return this.anio;
    }
    public boolean getDisponible() {
        return this.disponible;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Coche [ID = " + id + ", marca = " + marca + ", año = " + anio + ", disponibilidad = " + disponible + "]";
    }
}   
