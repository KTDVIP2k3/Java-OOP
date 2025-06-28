package Models;

public abstract class Employee {
    private String employeeId;
    private String name;
    private String address;
    private String phone;

    public Employee(){}

    public Employee(String employeeId, String name, String address, String phone) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public abstract void displayInfo();

    public abstract double calculateSalary();
}
