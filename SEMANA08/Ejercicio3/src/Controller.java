public class Controller {
    private Model modelo;
    private View vista;

    public Controller(Model modelo, View vista) {
        this.modelo = modelo;
        this.vista = vista;
        cargarDatosIniciales();
    }

    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    String rutaArchivo = vista.pedirRutaArchivo();
                    if (modelo.cargarDatos(rutaArchivo)) {
                        vista.mostrarMensaje("Datos cargados correctamente.");
                    } else {
                        vista.mostrarMensaje("Error al cargar el archivo.");
                    }
                    break;
                case 2:
                    vista.mostrarDatos(modelo.getPersonas());
                    break;
                case 3:
                    continuar = !vista.confirmarSalida();
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
    }

    private void cargarDatosIniciales() {
        String rutaArchivo = System.getProperty("user.home") + "/Desktop/datos.txt";
        if (modelo.cargarDatos(rutaArchivo)) {
            vista.mostrarMensaje("Datos iniciales cargados desde datos.txt");
        } else {
            vista.mostrarMensaje("No se encontró el archivo datos.txt en el escritorio.");
        }
    }
}