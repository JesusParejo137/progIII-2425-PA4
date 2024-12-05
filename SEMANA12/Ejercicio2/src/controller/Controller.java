package controller;

import model.Model;
import view.View;

public class Controller {

    View v;
    Model m;

    public Controller(Model m, View v) {
        this.m = m;
        this.v = v;

        v.setC(this);
    }

    public void init() {
        v.showMenu();
    }

    public void loadDataFromBinaryFile() {
        m.loadDataFromBinaryFile();
    }
}
