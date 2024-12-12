package model;

import java.util.ArrayList;

    /*
     * Interfaz con operaciones CRUD
     * y métodos de importación y exportación
     */

public interface IRepository {

    public abstract ArrayList<Task> importarTareas();
    
    public abstract boolean exportarTareas(ArrayList<Task> tareas);

    public abstract boolean addTask(Task t) throws RepositoryException;
}