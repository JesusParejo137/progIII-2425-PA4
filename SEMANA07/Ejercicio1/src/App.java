import com.usal.calculadora.controller.Controller;
import com.usal.calculadora.view.View;
import com.usal.calculadora.model.CalculadoraModel;

public class App {
    public static void main(String[] args) throws Exception {
        
        CalculadoraModel m = new CalculadoraModel();
        View v = new View();
        Controller c = new Controller(m, v);

        c.run();
    }
}