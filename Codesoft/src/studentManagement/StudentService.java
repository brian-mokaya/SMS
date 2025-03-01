package studentManagement;

import java.io.*;
import java.util.*;

public class StudentService {
    private List<Student> students;
    private final String FILE_NAME = "students.txt";

    public StudentService() {
        students = new ArrayList<>();
        loadStudentsFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudentsToFile();
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int rollNumber) {
        Student student = searchStudent(rollNumber);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        boolean removed = students.removeIf(s -> s.getRollNumber() == rollNumber);
        if (removed) {
            saveStudentsToFile();
            System.out.printf("Student with roll number %d removed successfully.\n", rollNumber);
        }
    }

    public List<Student> getAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return null;
        }
        students.forEach(System.out::println);
        return students;
    }

    public Student searchStudent(int rollNumber) {
        return students.stream()
                .filter(student -> student.getRollNumber() == rollNumber)
                .findFirst()
                .orElse(null);
    }

    private void loadStudentsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            students = new ArrayList<>();  // Ensure list is never null
            System.out.println("No students found.");
        }
    }

    private void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving students.");
        }
    }
}
