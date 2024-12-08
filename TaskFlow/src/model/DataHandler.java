package model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.stream.Collectors;

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
        return this.tasks.stream()
                .filter(task -> task.getDate().equals(date))
                .collect(Collectors.toCollection(LinkedList::new));
    }
    
    public Task get(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void edit(Task task) {
        this.tasks.set(this.tasks.indexOf(task), task);
    }
    
    public void delete(int id) {
        Task task = get(id);
        
        if (task != null) {
            this.tasks.remove(task);
        }
    }
}
