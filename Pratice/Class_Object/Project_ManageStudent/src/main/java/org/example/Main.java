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
            System.out.println("2.Show student profile by studentId");
            System.out.println("3.Add Student");
            System.out.println("4.Update Student");
            System.out.println("5.Delete Student");
            System.out.println("6.Exit");
            System.out.print("Please input your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                   System.out.println("List of student!!!");
                   studentManagementList.showStudentList();
                    break;
                case 2:
                    String studentId;
                    System.out.print("Please input student Id: ");
                    studentId = sc.nextLine();
                    studentManagementList.showStudentById(studentId);
                    break;
                case 3:
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
                case 4:
                    int choice2 = 0;
                    String studentID;

                    System.out.print("Please input student ID: ");
                    studentID = sc.nextLine();
                    if(!studentManagementList.findStudentById(studentID)) {
                        System.out.println("Student id not found");
                        System.out.println("Please enter student id again");
                    }else{
                        do{
                            System.out.println("---------------Menu-----------");
                            System.out.println("1.Update student name");
                            System.out.println("2.Update student age");
                            System.out.println("3.Update student phone");
                            System.out.println("4.Update Student address");
                            System.out.println("5.Update student all field");
                            System.out.println("6.Exit");
                            System.out.print("Please enter your choice: ");
                            choice2 = Integer.parseInt(sc.nextLine());
                            switch (choice2){
                                case 1:
                                    String name;
                                    System.out.print("Please update student name: ");
                                    name = sc.nextLine();
                                    if(studentManagementList.updateStudentNameById(studentID, name)){
                                        System.out.println("Update student name successfully");
                                    }else{
                                        System.out.println("Update student name failed");
                                    }
                                    break;
                                case 2:
                                    int age;
                                    System.out.print("Please update student age: ");
                                    age = Integer.parseInt(sc.nextLine());
                                    if(studentManagementList.updateStudentAgeById(studentID, age)){
                                        System.out.println("Update student age successfully");
                                    }else{
                                        System.out.println("Update student age failed");
                                    }
                                    break;
                                case 3:
                                    String phone;
                                    System.out.print("Please update student phone: ");
                                    phone = sc.nextLine();
                                    if(studentManagementList.updateStudentPhoneById(studentID, phone)){
                                        System.out.println("Update student phone successfully");
                                    }else{
                                        System.out.println("Update student phone failed");
                                    }
                                    break;
                                case 4:
                                    String address;
                                    System.out.print("Please update student address: ");
                                    address = sc.nextLine();
                                    if(studentManagementList.updateStudentAddressById(studentID, address)){
                                        System.out.println("Update student address successfully");
                                    }else{
                                        System.out.println("Update student address failed");
                                    }
                                    break;
                                case 5:
                                    System.out.print("Please update student name: ");
                                    name = sc.nextLine();
                                    System.out.print("Please update student age: ");
                                    age = Integer.parseInt(sc.nextLine());
                                    System.out.print("Please update student phone: ");
                                    phone = sc.nextLine();
                                    System.out.print("Please update student address: ");
                                    address = sc.nextLine();
                                    if(studentManagementList.updateStudentALlById(studentID, name, age, phone, address)){
                                        System.out.println("Update all field student successfully");
                                    }else{
                                        System.out.println("Update all field student failed");
                                    }
                                    break;
                            }
                        }while (choice2 != 6);
                    }

                    break;
                case 5:
                    System.out.print("Please input student ID that you want to delete: ");
                    studentId = sc.nextLine();
                    if(studentManagementList.deteletStudentById(studentId)){
                        System.out.println("Delete student successfully");
                    }else{
                        System.out.println("Delete student failed");
                    }
                    break;
            }
        }while (choice != 6);
    }
}