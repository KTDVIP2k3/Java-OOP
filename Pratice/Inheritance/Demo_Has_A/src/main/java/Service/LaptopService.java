package Service;

import Models.Laptop;
import Models.Student;

public class LaptopService {
    public boolean addLaptopToStudent(Student student, Laptop laptop) {
        student.addLaptop(laptop);
        return true;
    }

    public boolean updateLaptopSpecs(Student student, String serial, String newSpecs) {
        for (Laptop l : student.getLaptops()) {
            if (l.getSerialNumber().equalsIgnoreCase(serial)) {
                l.setSpecs(newSpecs);
                return true;
            }
        }
        return false;
    }
}
