package view;

import static com.coti.tools.Esdia.readInt;
import static com.coti.tools.Esdia.readString;
import static com.coti.tools.Esdia.readString_ne;
import java.util.List;

import model.RepositoryException;
import model.Task;

    /*
     * Clase concreta que implementa BaseView.
     */

public class InteractiveView extends BaseView{

    @Override
    public void init() {
        showMessage("Bienvenido a la aplicación de gestión de tareas.");
        showMainMenu();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        System.err.println("Error: " + errorMessage);
    }

    @Override
    public void end(String finalMessage) {
        showMessage(finalMessage);
    }

    private void showMainMenu() {
        int opcion;
        do {
            System.out.println("\n --- Menú principal (submenús) --- ");
            System.out.println("1. Operaciones CRUD");
            System.out.println("2. Importación/Exportación");
            System.out.println("3. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    subMenuCRUD();
                    break;
                case 2:
                    subMenuImportacionExportacion();
                    break;
                case 3:
                    break;
                default:
                    showErrorMessage("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 3);
    }

    private void subMenuCRUD() {
        int opcion;
        do {
            System.out.println("\n --- Submenú CRUD --- ");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Mostrar tareas sin completar por prioridad (mayor a menor)");
            System.out.println("3. Mostrar todas las tareas (completadas o no)");
            System.out.println("4. Marcar tarea como completa/pendiente (cambia su estado)");
            System.out.println("5. Modificar tarea");
            System.out.println("6. Eliminar tarea");
            System.out.println("7. Volver al menú principal");

            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    agregarTarea();
                    break;
                case 2:
                    mostrarTareasSinCompletar();
                    break;
                case 3:
                    mostrarTareas();
                    break;
                case 4:
                    modificarCompleta();
                    break;
                case 5:
                    modificarTarea();
                    break;
                case 6:
                    eliminarTarea();
                    break;
                case 7:
                    break;
                default:
                    showErrorMessage("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 7);
    }

    private void subMenuImportacionExportacion() {
        int opcion;
        do {
            System.out.println("\n --- Submenú Importación/Exportación --- ");
            System.out.println("1. Exportar a JSON (output.json)");
            System.out.println("2. Exportar a CSV (output.csv)");
            System.out.println("3. Importar de JSON");
            System.out.println("4. Importar de CSV");

            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    agregarTarea();
                    break;
                case 2:
                    mostrarTareasSinCompletar();
                    break;
                case 3:
                    mostrarTareas();
                    break;
                case 4:
                    break;
                default:
                    showErrorMessage("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 4);
    }

    private void agregarTarea() {

        System.out.println("Introduzca los datos de la nueva tarea: ");
        String title = readString("Título: ");
        String content = readString("Descripción: ");
        int priority = readInt("Nivel de prioridad: ");
        int estimatedDuration = readInt("Duración estimada: ");

        try {
            if (c.agregarTarea(new Task(title, content, priority, estimatedDuration))) {
                showMessage("Tarea agregada con éxito");
            } else {
                showErrorMessage("No se pudo agregar la tarea con esos datos");
            }
        } catch (RepositoryException e) {
            showErrorMessage("Surgió un problema en el repositorio " + e);
        }
    }

    private void mostrarTareasSinCompletar() {

    }

    private void mostrarTareas() {

    }

    private void modificarCompleta() {

    }

    private void modificarTarea() {

    }

    private void eliminarTarea() {

    }

}