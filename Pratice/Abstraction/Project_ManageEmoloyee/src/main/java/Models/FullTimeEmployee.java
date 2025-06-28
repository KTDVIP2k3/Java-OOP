package Models;

public class FullTimeEmployee extends Employee{
    private double monthSalary;

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(String employeeId, String name, String address, String phone, double monthSalary) {
        super(employeeId, name, address, phone);
        this.monthSalary = monthSalary;
    }

    public double getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(double monthSalary) {
        this.monthSalary = monthSalary;
    }

    @Override
    public void displayInfo() {
        System.out.println("Employee Id: " + this.getEmployeeId());
        System.out.println("Name: " + this.getName());
        System.out.println("Address: " + this.getAddress());
        System.out.println("Phone: " + this.getPhone());
        System.out.println("Salary: " + calculateSalary());
    }

    @Override
    public String toString(){
        return "EmployeeId: " + this.getEmployeeId() + " - " + "Name: " + this.getName() + " - " + "Address: " + this.getAddress()
                + " - " + "Phone: " + this.getPhone() + " - " + "Salary " + calculateSalary();
    }

    @Override
    public double calculateSalary() {
        return this.monthSalary;
    }
}
