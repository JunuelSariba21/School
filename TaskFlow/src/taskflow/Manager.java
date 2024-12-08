package taskflow;

import Form.Dashboard;
import Form.EditForm;
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
public class Manager implements Listener {

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
    public void doAction(int id) {
        Task task = handler.get(id);

        if (task != null) {
            task.setStatus("ongoing");
            handler.edit(task);
            this.updateTable(handler.getTasks());

        }
    }

    @Override
    public void gotoEdit(int id) {
        Task task = handler.get(id);

        if (task != null) {
            new EditForm(dashboard, true, task, this).setVisible(true);
        }

    }

    @Override
    public void doneAtion(int id) {
         Task task = handler.get(id);

        if (task != null) {
            task.setStatus("complete");
            handler.edit(task);
            this.updateTable(handler.getTasks());

        }
    }

    @Override
    public void editTask(Task task) {
        handler.edit(task);
        this.updateTable(handler.getTasks());

    }

    @Override
    public void filterDate(LocalDate date) {
        this.updateTable(handler.filterTask(date));
    }

    @Override
    public void delete(int id) {
        handler.delete(id);
        this.updateTable(handler.getTasks());

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
