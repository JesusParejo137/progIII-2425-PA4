package controller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.DatosDeAlumno;
import view.Vista;

public class Controller {
    private List<DatosDeAlumno> alumnos;
    private Vista vista;

    public Controller(Vista vista) {
        this.vista = vista;
        this.alumnos = DatosDeAlumno.generarLista(20); // Generar lista inicial
    }

    public void iniciar() {
        while (true) {
            vista.mostrarMenu();
            String opcion = vista.leerOpcion();

            switch (opcion) {
                case "1":
                    alumnos = DatosDeAlumno.generarLista(20);
                    vista.mostrarMensaje("Lista de alumnos generada nuevamente.");
                    break;
                case "2":
                    vista.mostrarTabla(alumnos);
                    break;
                case "3":
                    exportarDatosPersonales();
                    break;
                case "4":
                    exportarDirecciones();
                    break;
                case "q":
                    vista.mostrarMensaje("Saliendo...");
                    vista.cerrar();
                    return;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
    }

    private void exportarDatosPersonales() {
        try (FileWriter writer = new FileWriter("datos_personales.csv")) {
            for (DatosDeAlumno alumno : alumnos) {
                writer.write(alumno.getDatosPersonales() + "\n");
            }
            vista.mostrarMensaje("Datos personales exportados a datos_personales.csv");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al exportar datos personales: " + e.getMessage());
        }
    }

    private void exportarDirecciones() {
        try (FileWriter writer = new FileWriter("direcciones.csv")) {
            for (DatosDeAlumno alumno : alumnos) {
                writer.write(alumno.getDireccion() + "\n");
            }
            vista.mostrarMensaje("Direcciones exportadas a direcciones.csv");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al exportar direcciones: " + e.getMessage());
        }
    }
}