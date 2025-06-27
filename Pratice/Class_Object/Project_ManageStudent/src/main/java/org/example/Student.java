package org.example;

public class Student {
    String studentId;
    String name;
    int age;
    String phone;
    String address;
    String gender;

    public Student() {
    }

    public Student(String studentId, String name, int age, String phone, String address, String gender) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }

    public void showProfile(){
        System.out.println("Student Id: " + this.studentId + " " + "Name: " + this.name +  " " + "Age: " + this.age +  " " + "Phone: " + this.phone
        + " " + "Address: " + this.address + " " + "Gender: " + this.gender);
    }
}
