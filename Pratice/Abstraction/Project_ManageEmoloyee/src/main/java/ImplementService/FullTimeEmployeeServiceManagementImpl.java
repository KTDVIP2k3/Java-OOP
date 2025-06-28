package ImplementService;

import InterfaceSevice.FullTimeEmployeeServiceManagement;
import Models.FullTimeEmployee;

import java.util.ArrayList;
import java.util.List;

public class FullTimeEmployeeServiceManagementImpl implements FullTimeEmployeeServiceManagement {
    private List<FullTimeEmployee> fullTimeEmployeeList;

    public FullTimeEmployeeServiceManagementImpl(){
        fullTimeEmployeeList = new ArrayList<>();
    }

    @Override
    public void showAllFullTimeEmployee() {
        if(fullTimeEmployeeList.isEmpty()){
            System.out.println("full time employee list is blank!!!");
            return;
        }

        for(FullTimeEmployee fullTimeEmployee : fullTimeEmployeeList){
            fullTimeEmployee.displayInfo();
        }
    }

    @Override
    public void showFullTimeEmployeeById(String employeeId) {
        if(findFullTimeEmployeeById(employeeId) == null){
            System.out.println("Full time employee with this id does not exist");
            return;
        }
        findFullTimeEmployeeById(employeeId).displayInfo();
    }

    @Override
    public FullTimeEmployee findFullTimeEmployeeById(String employeeId) {
        for(FullTimeEmployee fullTimeEmployee : fullTimeEmployeeList){
            if(fullTimeEmployee.getEmployeeId().equalsIgnoreCase(employeeId)){
                return fullTimeEmployee;
            }
        }
        return null;
    }

    @Override
    public boolean addFullTimeEmployee(FullTimeEmployee fullTimeEmployee) {
        if(fullTimeEmployeeList.add(fullTimeEmployee)){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateSalaryFullTimeEmployeeById(String employeeId, double salary) {
        if(findFullTimeEmployeeById(employeeId) == null){
            System.out.println("Full time employee with this id does not exist");
            return false;
        }
        findFullTimeEmployeeById(employeeId).setMonthSalary(salary);
        return true;
    }

    @Override
    public boolean deleteFullTimeEmployeeById(String employeeId) {
        if(findFullTimeEmployeeById(employeeId) == null){
            System.out.println("Full time employee with this id does not exist");
            return false;
        }
        fullTimeEmployeeList.remove(findFullTimeEmployeeById(employeeId));
        return true;
    }
}
