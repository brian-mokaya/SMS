package studentManagement;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int rollNumber;
    private int age;
    private String email;
    private String grade;

    public Student(String name, int rollNumber, int age, String email, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
        this.email = email;
        this.grade = grade;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Grade: " + grade + ", Roll Number: " + rollNumber + ", Email: " + email;
    }
}
