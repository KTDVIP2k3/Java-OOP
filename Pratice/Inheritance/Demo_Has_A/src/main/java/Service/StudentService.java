package Service;

import Models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> studentList = new ArrayList<>();

    public void addStudent(Student s) {
        studentList.add(s);
    }

    public Student findStudentById(String id) {
        for (Student s : studentList) {
            if (s.getStudentId().equalsIgnoreCase(id)) return s;
        }
        return null;
    }

    public void showAllStudents() {
        for (Student s : studentList) {
            System.out.println("Student: " + s.getName() + " (ID: " + s.getStudentId() + ")");
            s.getLaptops().forEach(System.out::println);
        }
    }
}
