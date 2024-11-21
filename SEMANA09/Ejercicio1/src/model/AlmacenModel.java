package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AlmacenModel implements Serializable{
    
    private ArrayList<Libro> libros;

    public AlmacenModel() {
        libros = new ArrayList<>();
    }

    public ArrayList<Libro> getLibros() {
        return this.libros;
    }

    public static ArrayList<Libro> readModelFromBinary(Path path /* Path sin el .bin al final */) {
        FileInputStream fileInput = null;
        ObjectInputStream  ois = null;
        File file = null;
        
        path = Paths.get(path.toString(), "libros.bin");
        file = path.toFile();

        try {

            ois = new ObjectInputStream(fileInput);
            return (ArrayList<Libro>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error durante la deserialización " + e.getMessage());
            return null;
        } finally{
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el flujo " + e.getMessage());
                }
            }
        }
    }

    // Guardar el Model en binario
    public void saveModelToBinary(Path path) {
        ObjectOutputStream oos = null;
        File file = null;

        path = Paths.get(path.toString(), "libros.bin");
        file = path.toFile();

        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(this.libros);
        } catch (Exception e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (Exception e) {
                    System.err.println("Error al cerrar el flujo " + e.getMessage());
                }
            }
        }
    }

    // Guardar el Model en CSV
    public void saveModelToCSV(Path path) {
        File file = null;

        path = Paths.get(path.toString(),"libros.csv");
        file = path.toFile();

        try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // Mostrar libros
    @Override
    public String toString() {
        String total = null;
        for (Libro l : libros) {
            total = total + l.toString() + "\n";
        }
        return total;
    }
}
