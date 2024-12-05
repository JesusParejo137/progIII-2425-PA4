package view;

import com.coti.tools.Esdia;

import controller.Controller;

public class View {
    Controller c;

    public Controller getC() {
        return c;
    }

    public void setC(Controller c) {
        this.c = c;
    }

    public void showMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println(" --- Menu --- ");
            System.out.println("1. Cargar datos de fichero binario");
            System.out.println("2. Salir");
            int opcion = Esdia.readInt("Intorduzca una opción: ",1,2);
            if (opcion == 1) {
                c.loadDataFromBinaryFile();
            } else {
                continuar = false;
            }
        }
    }
}
