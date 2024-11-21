import java.nio.file.Path;

import com.coti.tools.Rutas;

public class App {
    public static void main(String[] args) throws Exception {
        // Path path = Paths.get(System.getProperty("user.home"));
        Path path = Rutas.pathToDesktopOD();
    }
}
