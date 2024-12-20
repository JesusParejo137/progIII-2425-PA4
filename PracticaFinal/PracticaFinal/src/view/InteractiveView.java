package view;

import static com.coti.tools.Esdia.readInt;
import static com.coti.tools.Esdia.readString;
import static com.coti.tools.Esdia.readString_ne;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import model.CSVExporter;
import model.ExporterException;
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
                    configurarExportacion();
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

    private void subMenuImportacionExportacionCSV() {
        int opcion;
        do {
            System.out.println("\n --- Submenú Importación/Exportación --- ");
            System.out.println("1. Importar de CSV (output.csv)");
            System.out.println("2. Exportar a CSV (output.csv)");
            System.out.println("3. Salir");

            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    importarTareasCSV();
                    break;
                case 2:
                    exportarTareasCSV();
                    break;
                case 3:
                    break;
                default:
                    showErrorMessage("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 3);
    }

    private void subMenuImportacionExportacionJSON() {
        int opcion;
        do {
            System.out.println("\n --- Submenú Importación/Exportación --- ");
            System.out.println("1. Importar de JSON (output.json)");
            System.out.println("2. Exportar a JSON (output.json)");
            System.out.println("3. Salir");

            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    importarTareasJSON();
                    break;
                case 2:
                    exportarTareasJSON();
                    break;
                case 3:
                    break;
                default:
                    showErrorMessage("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 3);
    }

    private void agregarTarea() {

        System.out.println("Introduzca los datos de la nueva tarea: ");
        String title = readString("Título: ");
        String content = readString("Descripción: ");
        int priority = readInt("Nivel de prioridad: ");
        int estimatedDuration = readInt("Duración estimada: ");

        try {
            c.agregarTarea(new Task(title, content, priority, estimatedDuration));
            showMessage("Tarea agregada con éxito");
        } catch (RepositoryException e) {
            showErrorMessage("No se pudo agregar la tarea con esos datos");
            showErrorMessage("Surgió un problema en el repositorio " + e);
        }
    }

    private void mostrarTareasSinCompletar() {
        try {
            List<Task> tareas = c.obtenerTareasSinCompletar();
            if (tareas.isEmpty()) {
                showMessage("No hay tareas sin completar.");
            } else {
                showMessage(Task.getHeaderTableStringForTask());
                for (Task t : tareas) {
                    showMessage(t.getAsRowString());
                }
            }
        } catch (RepositoryException e) {
            showErrorMessage("Error al obtener tareas: " + e.getMessage());
        }
    }

    private void mostrarTareas() {
        try {
            List<Task> tareas = c.obtenerTodasLasTareas();
            if (tareas.isEmpty()) {
                showMessage("No hay tareas registradas.");
            } else {
                showMessage(Task.getHeaderTableStringForTask());
                for (Task t : tareas) {
                    showMessage(t.getAsRowString());
                }
            }
        } catch (RepositoryException e) {
            showErrorMessage("Error al obtener tareas: " + e.getMessage());
        }
    }

    private void modificarCompleta() {
        String titulo = readString_ne("Ingrese el titulo de la tarea cuyo estado desea modificar: ");
        try {
            if(c.cambiarEstadoTarea(new Task(titulo,"",0, 0))) {
                showMessage("Estado de la tarea modificado con éxito.");
            }
            else {
                showMessage("No se ha encontrado una tarea con ese título.");
            }
        } catch (RepositoryException e) {
            showErrorMessage("Error al cambiar el estado de la tarea: " + e.getMessage());
        }
        
    }

    private void modificarTarea() {
        int id = readInt("Ingrese el identificador de la tarea a modificar: ");
        try {
            String nuevoTitulo = readString("Nuevo título: ");
            String nuevoContenido = readString("Nueva descripción: ");
            int nuevaPrioridad = readInt("Nueva prioridad: ");
            int nuevaDuracion = readInt("Nueva duración estimada: ");

            c.modificarTarea(new Task(id, nuevoTitulo, nuevoContenido, nuevaPrioridad, nuevaDuracion));

            showMessage("Tarea modificada con éxito.");
        } catch (RepositoryException e) {
            showErrorMessage("Error al modificar la tarea: " + e.getMessage());
        }
    }

    private void eliminarTarea() {
        int id = readInt("Ingrese el identificador de la tarea a eliminar: ");
        try {
            c.eliminarTarea(new Task(id,"","",0,0));
            showMessage("Tarea eliminada con éxito.");
        } catch (RepositoryException e) {
            showErrorMessage("Error al eliminar la tarea: " + e.getMessage());
        }
    }

    // Importación y exportación

    private void configurarExportacion() {
        String tipo = readString("Ingrese el tipo de exportación (csv/json): ");
        c.configurarExportador(tipo);
        switch (tipo.toLowerCase()) {
            case "csv":
                subMenuImportacionExportacionCSV();
                break;
            case "json":
                subMenuImportacionExportacionJSON();
                break;
            default:
                throw new IllegalArgumentException("Tipo de exportador no válido: " + tipo);
        }
    }

    private void exportarTareasCSV() {
        Path filePath = Paths.get(System.getProperty("user.home"), "output.csv");
        try {
            c.exportarTareas(filePath);
            showMessage("Exportación exitosa");
        } catch (ExporterException e) {
            showErrorMessage("Error en el exportador" + e.getMessage());
            e.printStackTrace();
        } catch (RepositoryException e) {
            showErrorMessage("Error en el repositorio" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void importarTareasCSV() {
        Path filePath = Paths.get(System.getProperty("user.home"), "output.csv");
        try {
            c.importarTareas(filePath);
            showMessage("Importación exitosa");
        } catch (ExporterException e) {
            showErrorMessage("Error en el exportador" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void exportarTareasJSON() {
        Path filePath = Paths.get(System.getProperty("user.home"), "output.json");
        try {
            c.exportarTareas(filePath);
            showMessage("Exportación exitosa");
        } catch (ExporterException e) {
            showErrorMessage("Error en el exportador" + e.getMessage());
            e.printStackTrace();
        } catch (RepositoryException e) {
            showErrorMessage("Error en el repositorio" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void importarTareasJSON() {
        Path filePath = Paths.get(System.getProperty("user.home"), "output.json");
        try {
            showMessage("Importación exitosa");
            c.importarTareas(filePath);
        } catch (ExporterException e) {
            showErrorMessage("Error en el exportador" + e.getMessage());
            e.printStackTrace();
        }
    }
}