package controller;

import java.nio.file.Path;
import java.util.List;

import model.ExporterException;
import model.ExporterFactory;
import model.IExporter;
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


    // Métodos CRUD

    public void agregarTarea(Task task) throws RepositoryException{
        model.agregarTarea(task);
    }

    public void modificarTarea(Task task) throws RepositoryException{
        model.modificarTarea(task);
    }

    public List<Task> obtenerTareasSinCompletar() throws RepositoryException {
        return model.obtenerTareasSinCompletar();
    }

    public List<Task> obtenerTodasLasTareas() throws RepositoryException {
        return model.obtenerTodasLasTareas();
    }

    public boolean cambiarEstadoTarea(Task task) throws RepositoryException{
        return model.cambiarEstadoTarea(task);
    }

    public void eliminarTarea(Task task) throws RepositoryException {
        model.eliminarTarea(task);
    }

    // Importación y exportación

    public void configurarExportador(String tipo) {
            IExporter exporter = ExporterFactory.getExporter(tipo);
            model.setExporter(exporter);
        try {
            
            view.showMessage("Exportador configurado como: " + tipo);
        } catch (IllegalArgumentException e) {
            view.showErrorMessage("Tipo de exportador no válido: " + e.getMessage());
        }
    }

    public void importarTareas(Path filePath) throws ExporterException{
        model.importarTareas(filePath);
    }

    public void exportarTareas(Path filePath) throws ExporterException, RepositoryException {
        model.exportarTareas(filePath);
    }
}