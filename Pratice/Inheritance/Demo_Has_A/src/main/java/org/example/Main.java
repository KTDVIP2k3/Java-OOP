package org.example;

import Models.Laptop;
import Models.Student;
import Service.LaptopService;
import Service.StudentService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();
        LaptopService laptopService = new LaptopService();

        while (true) {
            System.out.println("===== Student-Laptop Management =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Laptop to Student");
            System.out.println("3. Show All Students & Laptops");
            System.out.println("4. Update Laptop Specs");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    studentService.addStudent(new Student(id, name));
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    String sid = sc.nextLine();
                    Student stu = studentService.findStudentById(sid);
                    if (stu == null) {
                        System.out.println("Student not found!");
                        break;
                    }
                    System.out.print("Enter Laptop serial: ");
                    String serial = sc.nextLine();
                    System.out.print("Enter brand: ");
                    String brand = sc.nextLine();
                    System.out.print("Enter specs: ");
                    String specs = sc.nextLine();
                    laptopService.addLaptopToStudent(stu, new Laptop(serial, brand, specs));
                    break;
                case 3:
                    studentService.showAllStudents();
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    String stuId = sc.nextLine();
                    Student s = studentService.findStudentById(stuId);
                    if (s == null) {
                        System.out.println("Student not found!");
                        break;
                    }
                    System.out.print("Enter serial number to update: ");
                    String updateSerial = sc.nextLine();
                    System.out.print("Enter new specs: ");
                    String newSpecs = sc.nextLine();
                    if (laptopService.updateLaptopSpecs(s, updateSerial, newSpecs)) {
                        System.out.println("Update success!");
                    } else {
                        System.out.println("Laptop not found!");
                    }
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }
}