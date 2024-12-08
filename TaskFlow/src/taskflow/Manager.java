package taskflow;

import Form.Dashboard;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import listener.Listener;
import model.DataHandler;
import model.Task;

/**
 *
 * @author wb2c0
 */
public class Manager implements Listener{
    
    Dashboard dashboard;
    DataHandler handler;
    
    
    public Manager(Dashboard dashboard) {
        this.handler = new DataHandler();
        this.dashboard = dashboard;
        this.dashboard.setListener(this);
    }

    @Override
    public void addTask(String task, String category, LocalDate date, LocalTime time) {
        if (!validateInput(task, category, date, time)) {
            return;
        }
        handler.add(new Task(task, category, date, time));
        this.updateTable(handler.getTasks());
    }

    @Override
    public void gotoAdd() {
    }

    @Override
    public void gotoEdit() {
    }

    @Override
    public void gotoView() {
    }

    @Override
    public void editTask(int id) {
    }
    
    @Override
    public void filterDate(LocalDate date) {
        this.updateTable(handler.filterTask(date));
    }
    
    private void updateTable(LinkedList<Task> tasks) {
        this.dashboard.clearTable();
        for (Task task : tasks) {
            dashboard.addTask(task);
        }
    }
    
    private boolean validateInput(String task, String category, LocalDate date, LocalTime time) {
        
        if (task.strip().length() == 0 || category.strip().length() == 0) {
            JOptionPane.showMessageDialog(dashboard, "Task Cannot be empty");
            return false;
        }
        
        return true;
    }
}
