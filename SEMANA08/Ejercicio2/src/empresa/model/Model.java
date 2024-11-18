package empresa.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Model {
    private String delimiter = "\t";
    private List<Factura> facturas;

    public Model() {
        this.facturas = new ArrayList<>();
    }

    // Cargar facturas desde un archivo TSV
    public void cargarFacturas(Path rutaArchivo) throws Exception {
        List<String> lineas = Files.readAllLines(rutaArchivo);
        for (String linea : lineas) {
            Factura f = Factura.getFacturaFromDelimitedString(linea, delimiter);
            if (f != null) {
                facturas.add(f);
            }
        }
    }

    // Obtener todas las facturas
    public List<Factura> getFacturas() {
        return facturas;
    }

    // Filtrar facturas por importe mínimo
    public List<Factura> filtrarPorImporteMinimo(double importeMinimo) {
        return facturas.stream()
                .filter(f -> f.getImporteFinal() > importeMinimo)
                .collect(Collectors.toList());
    }

    // Exportar las facturas a un archivo HTML
    public void exportarAHtml(String rutaArchivo) throws IOException {
        StringBuilder html = new StringBuilder();
        html.append("<html><body><table border='1'>");
        html.append("<tr><th>Concepto</th><th>Importe Final</th><th>Cliente</th><th>Fecha</th></tr>");

        for (Factura factura : facturas) {
            html.append(String.format("<tr><td>%s</td><td>%.2f</td><td>%s</td><td>%s</td></tr>",
                    factura.getConcepto(), factura.getImporteFinal(), factura.getNombreCliente(), factura.getFecha()));
        }

        html.append("</table></body></html>");

        BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo));
        bw.write(html.toString());
        bw.close();
    }

    // Exportar las facturas a un archivo CSV
    public void exportarACsv(String rutaArchivo) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo));
        bw.write("Concepto,Importe Final,Cliente,Fecha\n");
        for (Factura factura : facturas) {
            bw.write(String.format("%s,%.2f,%s,%s\n",
                    factura.getConcepto(), factura.getImporteFinal(), factura.getNombreCliente(), factura.getFecha()));
        }
        bw.close();
    }
}
