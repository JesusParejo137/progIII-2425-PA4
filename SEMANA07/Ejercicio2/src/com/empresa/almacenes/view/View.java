package com.empresa.almacenes.view;

import com.coti.tools.Esdia;
import com.empresa.almacenes.controller.Controller;

public class View {

    Controller c;

    public void setController(Controller c) {
        this.c = c;
    }

    public void showMainMenu() {
        System.out.println("--- MENÚ ---");
        System.out.println("1. Leer tabla de ventas");
        System.out.println("2. Leer tabla de precios");
        System.out.println("3. Calcular ingresos totales");
        System.out.println("4. Mostrar resultados");
        System.out.println("5. Salir");
    }
    public int getUserOption() {
        return Esdia.readInt("Elija una opción: ", 1, 5);
    }

    public int[][] getTablaVentas() {
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

    public double[] getTablaPrecios() {
        double[] precios = new double[2];
        System.out.println("Introduzca los precios de los dos productos:");
        for (int i = 0; i < precios.length; i++) {
            precios[i] = Esdia.readDouble("Producto " + (i+1) + ", precio/unidad: ");
        }
        return precios;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showResult(double result) {
        System.out.println("Los ingresos totales son: " + result);
    }
}
