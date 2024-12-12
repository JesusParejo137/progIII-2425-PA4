import javax.swing.text.View;

import controller.Controller;
import model.BinaryRepository;
import model.IRepository;
import model.Model;
import view.BaseView;
import view.InteractiveView;

public class App {
    public static void main(String[] args) throws Exception {

        IRepository repository;
        BaseView view;

        if (args.length == 2) {
            // Notion necesita que haya 4 argumentos en total, no 2
            view = getViewForOption(args[0]);
            repository = getRepositoryForOption(args[1]);
        } else {
            // Opciones por defecto
            view = new InteractiveView();
            repository = new BinaryRepository();
        }

        Model model = new Model(repository);
        Controller controller = new Controller(model, view);

        controller.init();
    }

    private static IRepository getRepositoryForOption(String argumento) {
        switch (argumento) {
            case "bin":
                return new BinaryRepository();
            case "notion":
                // TODO
                return null;
            default:
                return new BinaryRepository();
        }
    }

    private static BaseView getViewForOption(String argumento) {
        switch (argumento) {
            case "interactive":
                return new InteractiveView();
            case "CLIview":
                // TODO
                return null;
            case "VoiceView":
                // TODO
                return null;
            default:
                return new InteractiveView();
        }
    }
}