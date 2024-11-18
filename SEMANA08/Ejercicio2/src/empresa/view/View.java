package empresa.view;

import java.util.List;
import java.util.Scanner;

import empresa.controller.Controller;
import empresa.model.Factura;

public class View {

    private Scanner scannerRef;

    private Controller c;

    public View() {
        this.scannerRef = new Scanner(System.in);
    }

    public void setController(Controller c){
        this.c = c;
    }
    
    public void showMainMenu() {
        System.out.println("--- MENU ---");
        System.out.println("1. Mostrar el listado total");
        System.out.println("2. Filtrar facturas por importe mínimo");
        System.out.println("3. Exportar facturas como .html");
        System.out.println("4. Exportar facturas como .csv");
        System.out.println("5. Salir");
    }

    public int getUserOption() {
        System.out.println("Eliga una opción: ");
        return scannerRef.nextInt();
    }

    public double leerImporteMinimo() {
        System.out.println("Introduce el imoprte mínimo: ");
        return scannerRef.nextDouble();
    }

    public void mostrarFacturas(List<Factura> facturas) {
        for (Factura factura : facturas) {
            System.out.println(factura);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
