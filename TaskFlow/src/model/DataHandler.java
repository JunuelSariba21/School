package model;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 *
 * @author wb2c0
 */
public class DataHandler {

    private LinkedList<Task> tasks;

    public DataHandler() {
        tasks = new LinkedList<>();
    }

    public void add(Task task) {
        task.setId(tasks.size() + 2);
        this.tasks.add(task);
    }

    public LinkedList<Task> getTasks() {
        return this.tasks;
    }

    public LinkedList<Task> filterTask(LocalDate date) {
        LinkedList<Task> filtered = new LinkedList<>();
        for (Task task : this.tasks) {
            if (task.getDate().equals(date)) {
                filtered.add(task);
            }
        }
        return filtered;
    }

}
