package model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author wb2c0
 */
public class Task {
    
    private int id;
    private String task;
    private String category;
    private LocalDate date;
    private LocalTime time;
    private boolean isDone = false;
    
    public Task(String task, String category, LocalDate date, LocalTime time) {
        this.task = task;
        this.category = category;
        this.date = date;
        this.time = time;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void markAsDone() {
        this.isDone = true;
    }
    
    public boolean getIsDone() {
        return this.isDone;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getTask() {
        return this.task;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    public LocalDate getDate() {
        return this.date;
    }
    
    public LocalTime getTime() {
        return this.time;
    }
    
}
