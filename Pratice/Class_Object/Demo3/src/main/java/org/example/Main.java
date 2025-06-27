package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.print("Please enter employee Id: ");
        employee.employeeId = sc.nextLine();
        System.out.print("Please enter employee full name: ");
        employee.fullName = sc.nextLine();
        System.out.print("Please enter employee department: ");
        employee.department = sc.nextLine();
        System.out.print("Please enter employee email: ");
        employee.email = sc.nextLine();
        System.out.print("Please enter employee phone: ");
        employee.phone = sc.nextLine();
        System.out.print("Please enter employee salary: ");
        employee.salary = Double.parseDouble(sc.nextLine());
        System.out.print("Please enter employee position: ");
        employee.position = sc.nextLine();

        employee.showSummary();
    }
}