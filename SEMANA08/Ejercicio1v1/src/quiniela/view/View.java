package quiniela.view;

import com.coti.tools.Esdia;

import quiniela.model.QuinielaModel;
import quiniela.controller.Controller;

public class View {
    
    Controller c;

    public void setController(Controller c) {
        this.c = c;
    }

    public int[][] getTablaPartidos() {
        Quiniela quiniela = new Quiniela();
        System.out.println("Introduzca los equipos que juegan en cada partido de la quiniela:");
        for (int i = 0; i < partidos.length; i++) {
            System.out.printf("Partido %d:\n", i+1);
            for (int j = 0; j < partidos[i].length; j++) {
                partidos[i][j] = Esdia.readInt("Equipo " + (j+1) + ":");
            }
        }
        return partidos;
    }
    
    public int[][] getTablaResultados() {
        int[][] ventas = new int[5][2];
        System.out.println("Introduzca las ventas de los dos productos para cada uno de los almacenes:");
        for (int i = 0; i < ventas.length; i++) {
            System.out.printf("Almacen %d:\n", i+1);
            for (int j = 0; j < ventas[i].length; j++) {
                ventas[i][j] = Esdia.readInt("Producto " + (j+1) + ", unidades vendidas: ");
            }
        }
        return ventas;
    }

    public void mostrarQuiniela() {
        int totalLength = 49;
        String lineaSeparacion = "|" + "-".repeat(totalLength-2) + "|";
        System.out.println(lineaSeparacion);
        System.out.println("|" + " ".repeat((totalLength-5-5)/2) + "QUINIELA" + " ".repeat((totalLength-5-4)/2) + "|");
        System.out.println(lineaSeparacion);

        for (Partido partido : partidos) {
            //Imprimir cada línea del array
            System.out.println(partido.lineaPartidoQuiniela());
        }

        System.out.println(lineaSeparacion);
    }

    public void showMainMenu() {
        System.out.println("--- MENÚ ---");
        System.out.println("1. Leer tabla de partidos");
        System.out.println("2. Leer tabla de resultados");
        System.out.println("3. Mostrar quiniela");
        System.out.println("4. Salir");
    }

    public int getUserOption() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserOption'");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
