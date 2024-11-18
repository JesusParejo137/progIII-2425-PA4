import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Model {
    private List<Persona> personas = new ArrayList<>();

    public boolean cargarDatos(String rutaArchivo) {
        personas.clear();
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) return false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split("\t");
                if (campos.length == 3) {
                    String nombre = campos[0];
                    String telefono = campos[1];
                    double peso = Double.parseDouble(campos[2]);
                    personas.add(new Persona(nombre, telefono, peso));
                }
            }
            return true;
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Persona> getPersonas() {
        return personas;
    }
}