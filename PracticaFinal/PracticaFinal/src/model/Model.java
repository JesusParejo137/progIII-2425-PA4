package model;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Model {

    private ArrayList<Task> tareas = new ArrayList<>();;
    
    private IRepository repository;

    private IExporter exporter;

    public void setExporter(IExporter exporter) {
        this.exporter = exporter;
    }

    public Model(IRepository repository) {
        this.repository = repository;
        tareas = new ArrayList<>();
    }

    public boolean guardarEstadoAplicacion() {
        return repository.saveData();
    }

    public boolean cargarEstadoAplicacion() {
        
        tareas = repository.loadData();
        
        if (tareas != null) {
            return true;
        }
        return false;
        
    }

    public boolean importarTareas() {

        ArrayList<Task> tareasImportadas = repository.loadData();

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

    // Métodos CRUD

    public void agregarTarea(Task task) throws RepositoryException{
        repository.addTask(task);
    }

    public void modificarTarea(Task task) throws RepositoryException {
        repository.modifyTask(task);
    }

    public void eliminarTarea(Task task) throws RepositoryException {
        repository.removeTask(task);
    }

    public List<Task> obtenerTodasLasTareas() throws RepositoryException {
        return repository.getAllTasks();
    }

    public List<Task> obtenerTareasSinCompletar() throws RepositoryException {
        
        List<Task> filtrados = repository.getAllTasks();

        Iterator<Task> iterator = filtrados.iterator();
        while (iterator.hasNext()) {
            Task t = iterator.next();
            if (t.isCompleted()) {
                iterator.remove();
            }
        }

        Collections.sort(filtrados, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return Integer.compare(o2.getPriority(), o1.getPriority()); // Orden descendente
            }
        });

        return filtrados;
    }

    public boolean cambiarEstadoTarea(Task task) throws RepositoryException{
        return repository.cambiarEstadoTarea(task);
    }

    // Importación y exportación

    public void exportarTareas(Path filePath) throws ExporterException, RepositoryException {
        if (exporter == null) {
            throw new IllegalStateException("No se ha configurado un exportador.");
        }
        exporter.exportTasks(obtenerTodasLasTareas(), filePath);
    }

    public void importarTareas(Path filePath) throws ExporterException {
        if (exporter == null) {
            throw new IllegalStateException("No se ha configurado un exportador.");
        }
        List<Task> importedTasks = exporter.importTasks(filePath);
        for (Task task : importedTasks) {
            try {
                agregarTarea(task);
            } catch (RepositoryException e) {
                System.err.println("Error al agregar una tarea importada: " + e.getMessage());
            }
        }
    }
}
