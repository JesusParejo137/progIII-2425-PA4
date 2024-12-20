package model;

import java.util.ArrayList;
import java.util.List;

    /*
     * Interfaz con operaciones CRUD
     * y métodos de importación y exportación
     */

public interface IRepository {

    Task addTask(Task t) throws RepositoryException;

    void modifyTask(Task task) throws RepositoryException;

    void removeTask(Task task) throws RepositoryException;

    List<Task> getAllTasks() throws RepositoryException;

    boolean cambiarEstadoTarea(Task task) throws RepositoryException;

    ArrayList<Task> loadData();
    
    boolean saveData();
    
}