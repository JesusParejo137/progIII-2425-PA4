package empresa.model;

public class Factura {
    private String concepto;
    private double descuento;
    private String fecha;
    private double importe;
    private String nif;
    private String nombreCliente;
    private String direccion;
    private double iva;

    public Factura(String concepto, double descuento, String fecha, double importe, String nif, String nombreCliente, String direccion, double iva) {
        this.concepto = concepto;
        this.descuento = descuento;
        this.fecha = fecha;
        this.importe = importe;
        this.nif = nif;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.iva = iva;
    }

    public double calcularImporteFinal() {
        return importe * (1 - descuento) * (1 + iva);
    }

    @Override
    public String toString() {
        return String.format("Concepto: %s, Importe Final: %.2f, Cliente: %s, Fecha: %s",
                concepto, calcularImporteFinal(), nombreCliente, fecha);
    }

    public double getImporteFinal() {
        return calcularImporteFinal();
    }

    public String getConcepto() {
        return concepto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public static Factura getFacturaFromDelimitedString(String linea, String delimiter) {
        String[] chunks = linea.split(delimiter);

        if (chunks.length != 8) {
            return null;
        } else {
            try {
                String concepto = chunks[0];
                double descuento = Double.parseDouble(chunks[1]);
                String fecha = chunks[2];
                double importe = Double.parseDouble(chunks[3]);
                String nif = chunks[4];
                String nombreCliente = chunks[5];
                String direccion = chunks[6];
                double iva = Double.parseDouble(chunks[7]);
                return new Factura(concepto, descuento, fecha, importe, nif, nombreCliente, direccion, iva);
            } catch (Exception e) {
                return null;
            }
        }
    }
}