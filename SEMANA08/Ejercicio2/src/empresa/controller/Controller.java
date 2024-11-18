package empresa.controller;

import empresa.view.View;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import empresa.model.Model;

public class Controller {
    
    private View v;
    private Model m;

    public Controller(Model m, View v) {
        this.m = m;
        this.v = v;

        v.setController(this);

        Path ruta = Paths.get(System.getProperty("user.home"),"Desktop","facturas.tsv");
        try {
            m.cargarFacturas(ruta); // Ruta del archivo TSV
        } catch (Exception e) {
            System.out.println("Error al cargar las facturas: " + e.getMessage());
            return;
        }
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            v.showMainMenu();
            int opcion = v.getUserOption();

            switch (opcion) {
                case 1:
                    v.mostrarFacturas(m.getFacturas());
                    break;
                case 2:
                    double importeMinimo = v.leerImporteMinimo();
                    v.mostrarFacturas(m.filtrarPorImporteMinimo(importeMinimo));
                    break;
                case 3:
                    try {
                        m.exportarAHtml("facturas.html");
                        v.showMessage("Facturas exportadas a facturas.html");
                    } catch (Exception e) {
                        v.showMessage("Error al exportar a HTML: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        m.exportarACsv("facturas.csv");
                        v.showMessage("Facturas exportadas a facturas.csv");
                    } catch (Exception e) {
                        v.showMessage("Error al exportar a CSV: " + e.getMessage());
                    }
                    break;
                case 5:
                    v.showMessage("Saliendo...");
                    salir = true;
                    break;
                default:
                    break;
            }
        }
    }

}
