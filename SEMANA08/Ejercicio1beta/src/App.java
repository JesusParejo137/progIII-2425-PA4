import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import model.QuinielaModel;

public class App {
    public static void main(String[] args) throws Exception {
        
        Path rutaArchivo = Paths.get(System.getProperty("user.home"),"Desktop","partidos.txt");

        QuinielaModel quiniela = new QuinielaModel();
        
        try {
            int numPartidos = quiniela.cargarPartidos(rutaArchivo);
            System.out.printf("Se han añadido %d partidos", numPartidos);

        } catch (IOException e) {
            System.out.println("Hubo un error en la lectura del fichero");
        }
        
    }
}
