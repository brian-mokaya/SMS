package studentManagement;

import java.util.Scanner;

public class StudentMenu {
    private final Scanner scanner;
    private final StudentService sms;

    public StudentMenu() {
        scanner = new Scanner(System.in);
        sms = new StudentService();
    }

    public void displayMenu() {
        int choice ;
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    viewAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void addStudent() {
        System.out.println("Enter student name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty");
            return;
        }

        System.out.println("Enter student roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter student age: ");
        int age = scanner.nextInt();
        if (age < 0) {
            System.out.println("Age cannot be negative");
        }
        scanner.nextLine();

        System.out.println("Enter student email: ");
        String email = scanner.nextLine().trim();
        if (email.isEmpty()){
            System.out.println("Email cannot be empty");
        }

        System.out.println("Enter student grade: ");
        String grade = scanner.nextLine().trim();
        if (grade.isEmpty()){
            System.out.println("Grade cannot be empty");
        }

       sms.addStudent(new Student(name, rollNumber, age, email, grade));

    }

    private void removeStudent() {
        System.out.println("Enter student roll number: ");
        int rollNumber = scanner.nextInt();
        sms.removeStudent(rollNumber);
    }

    private void searchStudent() {
        System.out.println("Enter student roll number: ");
        int rollNumber = scanner.nextInt();
        Student student = sms.searchStudent(rollNumber);
    }

    private void viewAllStudents() {
        sms.getAllStudents();
    }
}