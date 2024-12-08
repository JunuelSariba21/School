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
    private String status;
    
    public Task(String task, String category, LocalDate date, LocalTime time) {
        this.task = task;
        this.category = category;
        this.date = date;
        this.time = time;
        this.status = "pending";
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setTask(String task) {
        this.task = task;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public void setDate(LocalDate date) {
        this.date =date;
    }
    
    public void setTime(LocalTime time) {
        this.time = time;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return this.status;
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
