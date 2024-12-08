package listener;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author wb2c0
 */
public interface Listener {
    
    void gotoAdd();
    
    void gotoEdit();
    
    void gotoView();
    
    void addTask(String task, String category, LocalDate date, LocalTime time);
    
    void editTask(int id);
    
    void delete(int id);
    
    void filterDate(LocalDate date);
    
}
