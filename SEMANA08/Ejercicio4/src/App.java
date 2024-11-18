import controller.Controller;
import view.Vista;

public class App {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Controller controlador = new Controller(vista);
        controlador.iniciar();
    }
}