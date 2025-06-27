package org.example;

public class Employee {
     String employeeId;
     String fullName;
     String department;
     String email;
     String phone;
     double salary;
     String position;
     boolean isManager;

    public Employee(){}

    public Employee(String employeeId, String fullName, String department, String email,
                    String phone, double salary, String position, boolean isManager) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.department = department;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.position = position;
        this.isManager = isManager;
    }

    public void showSummary() {
        System.out.printf("ID: %s | Name: %s | Dept: %s | Role: %s\n",
                employeeId, fullName, department, position);
    }
}
