package org.example;

public class Student {
    //They are attributes to present behaviour for collection of object (student) in reality.
    String studentId;
    String name;
    int age;
    String phone;
    String address;
    String gender;

    // this is the default constructor, programmer don't need to create because compiler will create.
    // This is the constructor that no argument or parameter to set the attributes of the object.
    public Student(){}


    // This is the constructor with full parameter. What are these parameters mean ???
    // These parameters  are meant to be attributes that when an object created they must have to have its separate attributes.
    // So when want fill the separate attributes or created an object. It needed constructor to initialized.
    // All this name parameters have to be named like the name attributes of class because when created object they will be performed that programmer can understand.
    // Keyword (this) used for to help distinguish between attributes and parameters.
    public Student(String studentId, String name, int age, String phone, String address, String gender){
        this.studentId = studentId;
        this.name = name;
        this.age  =  age;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }


    // This is the method to present this class student and the collection of object student have this function.
    public void showProfileDetail(){
        System.out.println("Student Id: " + this.studentId);
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Phone: " + this.phone);
        System.out.println("Address: " + this.address);
        System.out.println("Gender: " + this.gender);
    }
}
