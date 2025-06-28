package InterfaceSevice;

import Models.FullTimeEmployee;
import Models.PartTimeEmployee;

public interface PartTimeEmployeeServiceManagement {
    public void showAllPartTimeEmployee();

    public void showPartTimeEmployeeById(String employeeId);

    public PartTimeEmployee findPartTimeEmployeeById(String employeeId);

    public boolean addPartTimeEmployee(PartTimeEmployee partTimeEmployee);

    public boolean updateSalaryPartTimeEmployeeById(String employeeId, double hourRate);

    public boolean deletePartEmployeeById(String employeeId);
}
