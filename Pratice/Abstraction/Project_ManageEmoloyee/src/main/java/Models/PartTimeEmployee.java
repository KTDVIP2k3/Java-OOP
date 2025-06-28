package Models;

public class PartTimeEmployee extends Employee{
    private int hourWorks;
    private double hourlyRate;

    public PartTimeEmployee() {
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
    public double calculateSalary() {
        return this.hourlyRate * (double) this.hourWorks;
    }

    public PartTimeEmployee(int hourWorks, double hourlyRate) {
        this.hourWorks = hourWorks;
        this.hourlyRate = hourlyRate;
    }

    public int getHourWorks() {
        return hourWorks;
    }

    public void setHourWorks(int hourWorks) {
        this.hourWorks = hourWorks;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
