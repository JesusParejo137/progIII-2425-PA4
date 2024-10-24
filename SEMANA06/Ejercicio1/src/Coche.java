public class Coche {
    private String modelo;
    private String color;
    private int anio;

    //Método constructor pasando parámetros
    public Coche(String modelo, String color, int anio) {
        this.modelo = modelo;
        this.color = color;
        this.anio = anio;
    }

    //Getters y setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString(){
        return "Modelo: " + modelo + ", Color: " + color + ", Año: " + anio;
    }

    //Override hashCode
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + anio;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coche other = (Coche) obj;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (anio != other.anio)
            return false;
        return true;
    }
}