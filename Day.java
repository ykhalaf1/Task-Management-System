import java.util.ArrayList;
import java.util.List;

public class Day {
    private String name;
    private List<Task> tasks;

    // Constructor
    public Day(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    // Method to add a task to the day
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Method to remove a task from the day
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    // Getter for tasks
    public List<Task> getTasks() {
        return tasks;
    }
}
