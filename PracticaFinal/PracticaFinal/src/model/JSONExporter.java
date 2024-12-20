package model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class JSONExporter implements IExporter{

    @Override
    public void exportTasks(List<Task> tareas, Path filePath) throws ExporterException{

        try {
            Gson gson = new Gson();
            String json = gson.toJson(tareas);
            Files.write(filePath, json.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new ExporterException("Error en la exportación " + e.getMessage());
        }
    }

    @Override

    public List<Task> importTasks(Path filePath) throws ExporterException {

        File file = filePath.toFile();

        if (!file.exists() || !file.isFile()) {
            throw new ExporterException("El archivo no existe o es inválido.");
        }

        try {
            Gson gson = new Gson();
            String json = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
            Type tipoDeLista = new TypeToken<List<Task>>() {}.getType();
            List<Task> nuevasTareas = gson.fromJson(json, tipoDeLista);

            return nuevasTareas != null ? nuevasTareas : new ArrayList<>();

        } catch (IOException e) {
            throw new ExporterException("Error al importar tareas desde JSON: " + e.getMessage());
        }
    }
}