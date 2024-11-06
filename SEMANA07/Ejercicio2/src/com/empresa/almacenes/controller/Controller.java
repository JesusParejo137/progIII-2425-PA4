package com.empresa.almacenes.controller;

import com.empresa.almacenes.model.AlmacenModel;
import com.empresa.almacenes.view.View;

public class Controller {
    View v;
    AlmacenModel m;

    public Controller(AlmacenModel m, View v) {
        this.m = m;
        this.v = v;

        // Inyectar la instancia del controlador a la vista para que esta última tenga acceso al primero
        v.setController(this);
    }
    public void run() {
        boolean salir = false;
        while (!salir) {
            v.showMainMenu();
            int opcion = v.getUserOption();

            switch (opcion) {
                case 1:
                    int[][] ventas = v.getTablaVentas();
                    m.setVentas(ventas);
                    v.showMessage("Tabla de ventas registrada correctamente.");
                    break;
                case 2:
                    double[] precios = v.getTablaPrecios();
                    m.setPrecios(precios);
                    v.showMessage("Tabla de precios registrada correctamente.");
                    break;
                case 3:
                    if (m.getVentasLeidas() && m.getPreciosLeidos()) {
                        m.calcularIngresosTotales();
                    } else {
                        v.showMessage("Debe ingresar la tabla de ventas y la tabla de precios primero");
                    }
                    break;
                case 4:
                    v.showResult(m.getIngresosTotales());
                    break;
                case 5:
                    salir = true;
                    v.showMessage("Saliendo del programa.");
                    break;
                default:
                    v.showMessage("Opción inválida, inténtelo de nuevo.");
                    break;
            }
        }
    }
}