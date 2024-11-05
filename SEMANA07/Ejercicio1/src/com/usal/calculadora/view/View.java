package com.usal.calculadora.view;

import com.coti.tools.Esdia;
import com.usal.calculadora.controller.Controller;

public class View {
    
    Controller c;

    public void setController(Controller c) {
        this.c = c;
    }

    public void showMainMenu() {

        System.out.println("--- MENÚ ---");
        System.out.println("1. Ingresar número 1");
        System.out.println("2. Ingresar número 2");
        System.out.println("3. Hacer cálculos (Lógica de negocio del modelo)");
        System.out.println("4. Mostrar resultado (Estado del modelo)");
        System.out.println("5. Salir");

    }

    public int getUserOption() {
        return Esdia.readInt("Elija una opción: ", 1, 5);
    }

    public int getNumerInput(String prompt) {
        return Esdia.readInt(prompt);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showResult(int result) {
        System.out.println("El resultado de la suma es: " + result);
    }
}