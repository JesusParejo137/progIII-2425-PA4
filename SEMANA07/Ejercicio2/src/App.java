import com.empresa.almacenes.controller.Controller;
import com.empresa.almacenes.model.AlmacenModel;
import com.empresa.almacenes.view.View;

public class App {
    public static void main(String[] args) {
        AlmacenModel model = new AlmacenModel();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.run();
    }
}