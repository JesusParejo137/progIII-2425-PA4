package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

    /*
     * Clase POJO
     */

public class Task implements Serializable{

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
}