package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVExporter implements IExporter{

    private static final String DELIMITER = ";";

    @Override
    public void exportTasks(List<Task> tareas, Path filePath) throws ExporterException{

        ArrayList<String> lineas = new ArrayList<>();

        for (Task t : tareas) {
            lineas.add(t.getTareaAsDelimitedString(DELIMITER));
        }

        try {
            Files.write(filePath, lineas, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ExporterException(e.getMessage());
        }
    }

    @Override
    public List<Task> importTasks(Path ruta) throws ExporterException {

        List<Task> tasks = new ArrayList<>();

        try {
            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
            for (String linea : lineas) {
                try {
                    Task task = Task.getTaskFromDelimitedString(linea, DELIMITER);
                    tasks.add(task);
                } catch (IllegalArgumentException e) {
                    throw new ExporterException("Formato de archivo CSV no válido");
                }
            }
        } catch (Exception e) {
            throw new ExporterException("Error al leer el archivo" + e.getMessage());
        }

        return tasks;
    }
}