package controller;

import javax.swing.text.View;

import model.AlmacenModel;

public class Controller {
    View v;
    AlmacenModel m;

    public String mostrarLibros() {
        return m.toString();
    }
}