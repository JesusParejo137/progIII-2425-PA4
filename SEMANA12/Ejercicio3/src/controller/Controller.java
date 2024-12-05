package controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Model;
import model.MyCustomException;
import view.View;

public class Controller {

    View v;
    Model m;

    public Controller(Model m, View v) {
        this.m = m;
        this.v = v;
    }

    public void init() {
        v.showMenu();
    }

    public void cargarDatosBinario() throws MyCustomException   {
        m.loadDataFromBinaryFile();
    }

}
