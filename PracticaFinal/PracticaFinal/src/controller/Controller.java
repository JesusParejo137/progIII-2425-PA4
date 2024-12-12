package controller;

import model.Model;
import model.RepositoryException;
import model.Task;
import view.BaseView;

public class Controller {
    
    Model model;
    BaseView view;

    public Controller(Model model, BaseView view) {
        this.model = model;
        this.view = view;
        view.setController(this);
    }

    public void init() {

        // Carga inicial del programa
        if (model.cargarEstadoAplicacion()) {
            view.showMessage("Cargado estado anterior con éxito.");
        } else {
            view.showMessage("No se encontró fichero para carga del programa.");
        }

        // Menú principal
        view.init();

        // Guardado final del programa
        if (model.guardarEstadoAplicacion()) {
            view.end("Guardado el estado de la aplicación.\nSaliendo...");
        } else {
            view.end("No se pudo guardar el estado de la aplicación.\nSaliendo...");
        }
    }

    public boolean agregarTarea(Task task) throws RepositoryException{
        return model.agregarTarea(task);
    }
}