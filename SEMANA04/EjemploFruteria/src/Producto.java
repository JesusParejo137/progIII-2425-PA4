public class Producto {

    private String nombre;
    private double precioKgSinIva;
    private double cantidad;

    private final double iva = 0.21;

    //Constructor de un Producto
    public Producto (String nombre, double precioKgSinIva) {
        this.nombre = nombre;
        this.precioKgSinIva = precioKgSinIva;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecioKgSinIva() {
        return precioKgSinIva;
    }
    public void setPrecioKgSinIva(double preciokg) {
        this.precioKgSinIva = preciokg;
    }
    public double getCantidad() {
        return cantidad;
    }
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    public double getIva() {
        return iva;
    }

    //Precio con IVA
    public double getPrecioTotal() {
        return (cantidad * (getPrecioKgSinIva() + iva));
    }
}