package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Model {

    private ArrayList<Task> tareas;
    
    private IRepository repository;

    File ficheroEstadoSerializado;

    public Model(IRepository repository) {
        this.repository = repository;
        ficheroEstadoSerializado = Paths.get(System.getProperty("user.home"), "file.txt").toFile();
        tareas = new ArrayList<>();
    }

    public boolean exportarTareas() {
        return repository.exportarTareas(tareas);
    }

    public boolean cargarEstadoAplicacion() {

        ArrayList<Task> tareasImportadas = repository.importarTareas();

        if (tareasImportadas != null) {
            for (Task tareaImportada : tareasImportadas) {
                if (!tareas.contains(tareaImportada)) {
                    tareas.add(tareaImportada);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean guardarEstadoAplicacion() {
        return repository.exportarTareas(tareas);
    }

    public boolean agregarTarea(Task task) throws RepositoryException{
        return repository.addTask(task);
    }
}
