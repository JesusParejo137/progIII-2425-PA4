package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

    /*
     * Clase POJO
     */

public class Task implements Serializable{
    private static final long serialVersionUID = 1L;

    int identifier;
    String title;
    Date date;
    String content;
    int priority;
    int estimatedDuration;
    boolean completed;

    public Task(String title, String content, int priority, int estimatedDuration) {
        this.identifier = (int) System.currentTimeMillis();
        this.title = title;
        this.date = new Date();
        this.content = content;
        this.priority = priority;
        this.estimatedDuration = estimatedDuration;
        this.completed = false;
    }

    public Task(int identifier, String title, String content, int priority, int estimatedDuration) {
        this.identifier = identifier;
        this.title = title;
        this.date = new Date();
        this.content = content;
        this.priority = priority;
        this.estimatedDuration = estimatedDuration;
        this.completed = false;
    }

    

    public Task(int identifier, String title, Date date, String content, int priority, int estimatedDuration,
            boolean completed) {
        this.identifier = identifier;
        this.title = title;
        this.date = date;
        this.content = content;
        this.priority = priority;
        this.estimatedDuration = estimatedDuration;
        this.completed = completed;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.identifier);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        return Objects.equals(this.identifier, other.identifier);
    }

    @Override
    public String toString() {
        return "Task{" +
                "identifier=" + identifier +
                ", taskTitle='" + title + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", priority=" + priority +
                ", estimatedDuration=" + estimatedDuration +
                ", completed=" + completed +
                '}';
    }

    public static String getHeaderTableStringForTask() {
        return String.format("|%-15s|%-20s|%-20s|%-25s|%-10s|%-18s|%-10s|", "Identificador", "Título", "Fecha", "Contenido", "Prioridad", "Duración estimada", "Estado");
    }

    public String getAsRowString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String fechaFormateada = sdf.format(date);

        String estado;
        if (completed) {
            estado = "Completada";
        } else {
            estado = "Pendiente";
        }

        return String.format("|%-15d|%-20s|%-20s|%-25s|%-10d|%-18d|%-10s|", this.identifier, this.title, fechaFormateada, this.content, this.priority, this.estimatedDuration, estado);
    }

    // Importación exportación

    public String getTareaAsDelimitedString(String delimitador) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String fechaFormateada = sdf.format(date);
        return String.format(Locale.ENGLISH,"%d" + delimitador + "%s" + delimitador + "%s" + delimitador + "%s" + delimitador+ "%d" + delimitador + "%d" + delimitador + "%b", identifier, title, fechaFormateada, content, priority, estimatedDuration, completed);
    }

    public static Task getTaskFromDelimitedString(String linea, String delimitador) throws IllegalArgumentException{
        String[] partes = linea.split(delimitador);
        if (partes.length!=7) {
            throw new IllegalArgumentException("Formato incorrecto en la linea" + linea);
        }

        int identifier;
        try {
            identifier = Integer.parseInt(partes[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Identificador inválido en la línea: " + linea);
        }
        String titulo = partes[1];
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date;
        try {
            date = dateFormat.parse(partes[2]);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Fecha inválido en la línea: " + linea);
        }
        String content = partes[3];
        int priority;
        try {
            priority = Integer.parseInt(partes[4]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Nivel de prioridad inválido en la línea: " + linea);
        }
        int estimatedDuration;
        try {
            estimatedDuration = Integer.parseInt(partes[5]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Duración estimada inválida en la línea: " + linea);
        }
        boolean completed;
        try {
            completed = Boolean.parseBoolean(partes[6]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Estado de la tarea inválido en la línea: " + linea);
        }

        return new Task(identifier, titulo, date, content, priority, estimatedDuration, completed);
    }


    // Getters y setters

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(int estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}