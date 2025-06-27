package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        int numberOfStudent = 0;
        System.out.print("Please input number of students you want to manger in list: ");
        numberOfStudent = Integer.parseInt(sc.nextLine());
        StudentManagementList studentManagementList = new StudentManagementList(numberOfStudent);
        do{
            System.out.println("---------------Menu-----------");
            System.out.println("1.Show student list");
            System.out.println("2.Add Student");
            System.out.println("3.Delete Student");
            System.out.println("4.Exit");
            System.out.print("Please input your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                   System.out.println("List of student!!!");
                   studentManagementList.showStudentList();
                    break;
                case 2:
                    Student student = new Student();
                    System.out.print("Please enter student Id: ");
                    student.studentId = sc.nextLine();
                    System.out.print("Please enter student name: ");
                    student.name = sc.nextLine();
                    System.out.print("Please enter student age: ");
                    student.age = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter student phone: ");
                    student.phone = sc.nextLine();
                    System.out.print("Please enter student address: ");
                    student.address = sc.nextLine();
                    System.out.print("Please enter student gender: ");
                    student.gender = sc.nextLine();
                    if(studentManagementList.addStudent(student)){
                        System.out.println("Add student succsessfully");
                    }else{
                        System.out.println("Add student failed");
                    }
                    break;
                case 3:
                    String studentId;
                    System.out.print("Please input student ID that you want to delete: ");
                    studentId = sc.nextLine();
                    if(studentManagementList.deteletStudentById(studentId)){
                        System.out.println("Delete student successfully");
                    }else{
                        System.out.println("Delete student failed");
                    }
                    break;
                case 4:
                    break;
            }
        }while (choice != 4);
    }
}