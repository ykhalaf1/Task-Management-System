import java.time.LocalDate;

public class Task {
    private String description;
    private PriorityLevel priority;
    private LocalDate dueDate;

    public Task(String description, PriorityLevel priority, LocalDate dueDate) {
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public PriorityLevel getPriority() {
        return priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public enum PriorityLevel {
        HIGH,
        MEDIUM,
        LOW
    }
}
