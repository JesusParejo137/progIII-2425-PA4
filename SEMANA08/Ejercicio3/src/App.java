public class App {
    public static void main(String[] args) {
        Model modelo = new Model();
        View vista = new View();
        Controller controlador = new Controller(modelo, vista);
        controlador.iniciar();
    }
}