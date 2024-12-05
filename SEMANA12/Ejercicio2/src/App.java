import controller.Controller;
import model.Model;
import view.View;

public class App {
    public static void main(String[] args) throws Exception {

        Model m = new Model();
        View v = new View();
        Controller c = new Controller(m, v);

        c.init();
    }
}
