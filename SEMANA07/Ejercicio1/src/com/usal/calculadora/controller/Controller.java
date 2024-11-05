package com.usal.calculadora.controller;

import com.usal.calculadora.model.CalculadoraModel;
import com.usal.calculadora.view.View;

public class Controller {
    
    View v;
    CalculadoraModel m;

    public Controller(CalculadoraModel m, View v) {
        this.m = m;
        this.v = v;

        //Inyectar la instancia del controlador a la vista
        v.setController(this);
    }

    public void init() {

        // Inicializar el modelo, obtener datos, mostrar un preview...

        // TODO.

        // Mostrar el menú principal
        v.showMainMenu();

        // Terminar ordenadamente la aplicación
    }

    public void run() {
        boolean salir = false;
        while (!salir) {
            v.showMainMenu();
            int opcion = v.getUserOption();

            switch (opcion) {
                case 1:
                    int num1 = v.getNumerInput("Ingrese el primer número entero: ");
                    m.setNum1(num1);
                    break;
                case 2:
                    int num2 = v.getNumerInput("Ingrese el segundo número entero: ");
                    m.setNum2(num2);
                    break;
                case 3:
                    m.calcularSuma();
                    break;
                case 4:
                    v.showResult(m.getSum());
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