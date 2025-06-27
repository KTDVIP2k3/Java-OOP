package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//
//        Student student1 = new Student();
//
//        // this is the object when created with the keyword new.
//        // student1 is the reference variable of this object.
//        // the constructor to initialize for the object is constructor default which have no parameters.
//
//        // Fill the separate attribute by that use the reference variable call the attribute
//        student1.studentId = "SE173443";
//        student1.name = "Tran Duy Khanh";
//        student1.age = 22;
//        student1.phone = "056594928";
//        student1.address = "tp.Bien Hoa";
//        student1.gender = "Male";
//
//        // Present the method of object that reference variable represent.
//        student1.showProfileDetail();
//
//        System.out.println();
//
//        // This is another initialized object type
//        // This constructor that programmer want defined to create the object follow by their way.
//        Student student2 = new Student("SE173444", "Do Minh Khang", 22 ,"123456789", "tp.Da Lat", "Male");
//
//        student2.showProfileDetail();

        Scanner sc = new Scanner(System.in);
        // This class scanner represent standard input (System.in)
        Student student = new Student();
        System.out.print("Please enter the student Id: ");
        student.studentId = sc.nextLine();
        System.out.print("Please enter the student name: ");
        student.name = sc.nextLine();
        //Read 1 full line which user input.
        System.out.print("Please enter the student age: ");
        student.age = Integer.parseInt(sc.nextLine());
        System.out.print("Please enter the student phone: ");
        student.phone = sc.nextLine();
        System.out.print("Please enter the student address: ");
        student.address = sc.nextLine();
        System.out.print("Please enter the student gender: ");
        student.gender = sc.nextLine();

        System.out.println("Student profile");

        student.showProfileDetail();

    }
}