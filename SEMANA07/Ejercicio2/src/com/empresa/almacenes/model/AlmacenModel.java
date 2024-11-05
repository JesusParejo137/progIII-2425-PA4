package com.empresa.almacenes.model;

public class AlmacenModel {
    private int[][] ventas;
    private double[] precios;
    private boolean ventasLeidas = false;
    private boolean preciosLeidos = false;
    private double ingresosTotales;
    
    public AlmacenModel() {
        this.ventas = new int[5][2];
        this.precios = new double[2];
    }

    public void setVentas(int[][] ventas) {
        this.ventas = ventas;
        ventasLeidas = true;
    }
    public void setPrecios(double[] precios) {
        this.precios = precios;
        preciosLeidos = true;
    }

    public boolean getVentasLeidas() {
        return ventasLeidas;
    }
    public boolean getPreciosLeidos() {
        return preciosLeidos;
    }

    public void calcularIngresosTotales() {
        double ingresosTotales = 0.0;
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                ingresosTotales += ventas[i][j] * precios[j];
            }
        }
        this.ingresosTotales = ingresosTotales;
    }

    public double getIngresosTotales() {
        return ingresosTotales;
    }
}
