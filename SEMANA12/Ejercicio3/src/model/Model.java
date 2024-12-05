package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Model {
    public void loadDataFromBinaryFile() throws MyCustomException {

        /* Para el ejercicio 5?
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hola.bin"));
            Persona p =(Persona) ois.readObject();
        } catch (Exception e) {
            // TODO: handle exception
        }
        */
        
        //ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hola.bin"));
        //Persona p =(Persona) ois.readObject();
        
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hola.bin"))){
            Persona p =(Persona) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new MyCustomException("Ha habido un error en la importación",e);
        }
        
        
    }
}
