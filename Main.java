import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate; // Imports LocalDate

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<User> users = new ArrayList<>();
    private static User currentUser;
    private static List<Task> tasks = new ArrayList<>();
    private static Menu menu = new Menu(); // Creates Menu

    public static void main(String[] args) {
        // Demo data
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));

        while (true) {
            menu.displayMainMenu();
            int choice = menu.getChoice();
            switch (choice) {
                case 1:
                    currentUser = login();
                    if (currentUser != null) {
                        displayUserMenu();
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static User login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine(); 
        System.out.print("Enter password: ");
        String password = scanner.nextLine(); 

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private static void createAccount() {
        System.out.print("Enter new username: ");
        String username = scanner.nextLine(); 
        System.out.print("Enter new password: ");
        String password = scanner.nextLine(); 
        users.add(new User(username, password));
    }

    private static void displayUserMenu() {
        while (true) {
            menu.displayUserMenu();
            int choice = menu.getChoice();
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    clearAllTasks();
                    break;
                case 4:
                    seeAllTasks(); 
                    break;
                case 5:
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine(); 
        System.out.print("Enter task priority (HIGH, MEDIUM, LOW): ");
        String priorityInput = scanner.nextLine().toUpperCase(); // Reads entire line and convert to uppercase
        Task.PriorityLevel priority = Task.PriorityLevel.valueOf(priorityInput); // Explicitly refers to PriorityLevel enum
    
        // Prompt for due date
        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDateInput = scanner.nextLine();
        LocalDate dueDate = LocalDate.parse(dueDateInput);
    
        // Creates Task object with due date
        tasks.add(new Task(description, priority, dueDate));
        System.out.println("Task added successfully.");
    }
    
    
    
    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("Task list is empty.");
            return;
        }
        System.out.print("Enter task description to remove: ");
        String descriptionToRemove = scanner.nextLine(); // Reads task description
        boolean removed = false;
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(descriptionToRemove)) {
                tasks.remove(task);
                removed = true;
                break; // Exit loop once task is removed
            }
        }
        if (removed) {
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }
     
    private static void clearAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Task list is already empty.");
            return;
        }
        tasks.clear();
        System.out.println("All tasks cleared.");
    }

    private static void seeAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("All Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println("Task " + (i + 1) + ":");
            System.out.println("Description: " + task.getDescription());
            System.out.println("Priority: " + task.getPriority());
            System.out.println("Due Date: " + task.getDueDate());
            System.out.println();
        }
    }
    
    
}
