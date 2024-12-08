package listener;

import java.time.LocalDate;
import java.time.LocalTime;
import model.Task;

/**
 *
 * @author wb2c0
 */
public interface Listener {
    
    void doAction(int id);
    
    void gotoEdit(int id);
    
    void doneAtion(int id);
    
    void addTask(String task, String category, LocalDate date, LocalTime time);
    
    void editTask(Task task);
    
    void delete(int id);
    
    void filterDate(LocalDate date);
    
}
