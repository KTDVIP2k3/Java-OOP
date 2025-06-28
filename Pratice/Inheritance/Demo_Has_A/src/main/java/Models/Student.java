package Models;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String name;
    private List<Laptop> laptops;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.laptops = new ArrayList<>();
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public List<Laptop> getLaptops() { return laptops; }

    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
    }
}
