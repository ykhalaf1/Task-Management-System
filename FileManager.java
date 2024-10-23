import java.io.*;
import java.util.Map;

public class FileManager {

    private static final String FILE_PATH = "tasks.txt";

    public void saveTasks(Map<String, Day> weekDays) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(weekDays);
            System.out.println("Tasks saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public void loadTasks(Map<String, Day> weekDays) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Map<String, Day> loadedTasks = (Map<String, Day>) inputStream.readObject();
            weekDays.clear();
            weekDays.putAll(loadedTasks);
            System.out.println("Tasks loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            // File not found or error loading tasks, ignore and proceed with an empty map
            System.out.println("No saved tasks found.");
        }
    }
}
