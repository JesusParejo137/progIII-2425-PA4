package view;

import controller.Controller;

    /*
     * Clase abstracta con métodos básicos
     * para interactuar con el usuario.
     */

public abstract class BaseView {

    protected Controller c;

    public abstract void init();

    public abstract void showMessage(String message);

    public abstract void showErrorMessage(String errorMessage);

    public abstract void end(String finalMessage);

    public void setController(Controller c) {
        this.c = c;
    }
}