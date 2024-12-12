package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BinaryRepository implements IRepository{

    ArrayList<Task> tareas;

    File ficheroEstadoSerializado = Paths.get(System.getProperty("user.home"), "tasks.bin").toFile();

    @Override
    public boolean exportarTareas(ArrayList<Task> tareas) {
        
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
    public ArrayList<Task> importarTareas() {
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

    // CRUD
    
    @Override
    public boolean addTask(Task t) throws RepositoryException {
        if (tareas.contains(t)) {
            return false;
        } else {
            tareas.add(t);
            return true;
        }
    }












}