import empresa.controller.Controller;
import empresa.model.Model;
import empresa.view.View;

public class App {
    public static void main(String[] args) throws Exception {
        
        Model modelo = new Model();
        View vista = new View();
        Controller controlador = new Controller(modelo, vista);
        controlador.iniciar();
    }
}
