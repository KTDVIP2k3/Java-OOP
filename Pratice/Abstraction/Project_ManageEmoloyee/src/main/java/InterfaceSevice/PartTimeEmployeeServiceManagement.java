package InterfaceSevice;

import Models.FullTimeEmployee;

public interface PartTimeEmployeeServiceManagement {
    public void showAllPartTimeEmployee();

    public void showPartTimeEmployeeById(String employeeId);

    public boolean findPartTimeEmployeeById(String employeeId);

    public boolean addPartTimeEmployee(FullTimeEmployee fullTimeEmployee);

    public boolean updateSalaryPartTimeEmployeeById(String employeeId);

    public boolean deletePartEmployeeById(String employeeId);
}
