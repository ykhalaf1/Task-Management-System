import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    // Constructor
    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    // Method to display the main menu
    public void displayMainMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Login");
        System.out.println("2. Create Account");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to display the user menu
    public void displayUserMenu() {
        System.out.println("User Menu");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. Clear All Tasks");
        System.out.println("4. See All Tasks");
        System.out.println("5. Go back to main menu");
        System.out.print("Enter your choice: ");
    }    

    // Method to get user choice
    public int getChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return choice;
    }
}