package model;

import java.nio.file.Path;
import java.util.List;

public interface IExporter {

    void exportTasks(List<Task> tasks, Path filePath) throws ExporterException;

    List<Task> importTasks(Path filePath) throws ExporterException;
}
