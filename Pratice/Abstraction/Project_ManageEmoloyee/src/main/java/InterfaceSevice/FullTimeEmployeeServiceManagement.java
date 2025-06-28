package InterfaceSevice;

import Models.FullTimeEmployee;

public interface FullTimeEmployeeServiceManagement {
    public void showAllFullTimeEmployee();

    public void showFullTimeEmployeeById(String employeeId);

    public FullTimeEmployee findFullTimeEmployeeById(String employeeId);

    public boolean addFullTimeEmployee(FullTimeEmployee fullTimeEmployee);

    public boolean updateSalaryFullTimeEmployeeById(String employeeId, double salary);

    public boolean deleteFullTimeEmployeeById(String employeeId);
}
