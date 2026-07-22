import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        boolean running = true;

        System.out.println("=== Student Management System ===");

        while (running) {
            printMenu();
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    addStudent(input, manager);
                    break;
                case "2":
                    viewAll(manager);
                    break;
                case "3":
                    searchStudent(input, manager);
                    break;
                case "4":
                    manager.sortByGradeDescending();
                    System.out.println("Sorted by grade (highest first).");
                    viewAll(manager);
                    break;
                case "5":
                    manager.sortByName();
                    System.out.println("Sorted alphabetically by name.");
                    viewAll(manager);
                    break;
                case "6":
                    System.out.printf("Class average: %.2f%n", manager.classAverage());
                    break;
                case "7":
                    removeStudent(input, manager);
                    break;
                case "8":
                    manager.saveToFile();
                    break;
                case "9":
                    manager.loadFromFile();
                    break;
                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
        input.close();
    }

    private static void printMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add student");
        System.out.println("2. View all students");
        System.out.println("3. Search by name");
        System.out.println("4. Sort by grade (highest first)");
        System.out.println("5. Sort by name (A-Z)");
        System.out.println("6. Show class average");
        System.out.println("7. Remove student");
        System.out.println("8. Save to file");
        System.out.println("9. Load from file");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addStudent(Scanner input, StudentManager manager) {
        System.out.print("Name: ");
        String name = input.nextLine();

        int grade = readValidGrade(input);

        System.out.print("Is graduate student? (true/false): ");
        boolean isGraduate = Boolean.parseBoolean(input.nextLine().trim());

        manager.addStudent(new Student(name, grade, isGraduate));
        System.out.println("Added: " + name);
    }

    private static int readValidGrade(Scanner input) {
        int grade;
        while (true) {
            System.out.print("Grade (0-100): ");
            try {
                grade = Integer.parseInt(input.nextLine().trim());
                if (grade < 0 || grade > 100) {
                    System.out.println("Invalid grade. Must be between 0 and 100.");
                    continue;
                }
                return grade;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private static void viewAll(StudentManager manager) {
        ArrayList<Student> all = manager.getAll();
        if (all.isEmpty()) {
            System.out.println("No students yet.");
            return;
        }
        for (Student s : all) {
            System.out.println(s);
        }
    }

    private static void searchStudent(Scanner input, StudentManager manager) {
        System.out.print("Enter name (or part of name) to search: ");
        String query = input.nextLine();
        ArrayList<Student> results = manager.searchByName(query);
        if (results.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            for (Student s : results) {
                System.out.println(s);
            }
        }
    }

    private static void removeStudent(Scanner input, StudentManager manager) {
        System.out.print("Enter name to remove: ");
        String name = input.nextLine();
        boolean removed = manager.removeStudent(name);
        System.out.println(removed ? "Removed " + name : "Student not found.");
    }
}
