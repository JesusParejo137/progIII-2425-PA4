package view;

import controller.Controller;

public class View {
    Controller c;
    

    public void mostrarLibros() {
        System.out.println(" --- ALMACÉN DE LIBROS --- ");
        System.out.println(c.mostrarLibros());
    }
}