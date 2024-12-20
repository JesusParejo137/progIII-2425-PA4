package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BinaryRepository implements IRepository{

    ArrayList<Task> tareas;

    File ficheroEstadoSerializado = Paths.get(System.getProperty("user.home"), "tasks.bin").toFile();

    public BinaryRepository() {
        this.tareas = new ArrayList<>(); // Inicialización por defecto
    }

    // Métodos CRUD
        
    @Override
    public Task addTask(Task t) throws RepositoryException {
        if (tareas.contains(t)) {
            throw new RepositoryException("Ya existe una tarea con el mismo identificador");
        } else {
            tareas.add(t);
            return t;
        }
    }

    @Override
    public void modifyTask(Task task) throws RepositoryException {
        boolean encontrado = false;
        for (Task t : tareas) {
            if (t.getIdentifier() == task.getIdentifier()) {
                t.setTitle(task.getTitle());
                t.setDate(task.getDate());
                t.setContent(task.getContent());
                t.setPriority(task.getPriority());
                t.setEstimatedDuration(task.getEstimatedDuration());
                t.setCompleted(task.isCompleted());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            throw new RepositoryException("La tarea no existe");
        }
    }

    @Override
    public void removeTask(Task task) throws RepositoryException {
        boolean eliminado = false;
        for (Task t : tareas) {
            if (t.getIdentifier() == task.getIdentifier()) {
                tareas.remove(t);
                eliminado = true;
                break;
            }
        }
        if (!eliminado) {
            throw new RepositoryException("No se encontró una tarea con el identificador especificado");
        }
    }

    @Override
    public List<Task> getAllTasks() throws RepositoryException {
        return new ArrayList<>(tareas);
    }

    @Override
    public boolean cambiarEstadoTarea(Task task) throws RepositoryException{
        boolean encontrada = false;
        for (Task t : tareas) {
            if (t.getTitle().equals(task.getTitle())) {
                if (t.isCompleted()) {
                    t.setCompleted(false);
                } else {
                    t.setCompleted(true);
                }
                encontrada = true;
                break;
            }
        }
        return encontrada;
    }

    // Métodos importación y exportación

    @Override
    public boolean saveData() {
        
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(ficheroEstadoSerializado));
            oos.writeObject(tareas);
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    return false;
                }
            }
        }
    }

    @Override
    public ArrayList<Task> loadData() {
        if (ficheroEstadoSerializado.exists() && ficheroEstadoSerializado.isFile()) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(ficheroEstadoSerializado));
                this.tareas = (ArrayList<Task>) ois.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                return null;
            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException ex) {
                        return null;
                    }
                }
            }
            return tareas;
        } else {
            return null;
        }
    }
}