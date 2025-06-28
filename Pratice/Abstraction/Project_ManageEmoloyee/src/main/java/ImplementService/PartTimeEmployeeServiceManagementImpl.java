package ImplementService;

import InterfaceSevice.PartTimeEmployeeServiceManagement;
import Models.FullTimeEmployee;
import Models.PartTimeEmployee;

import java.util.ArrayList;
import java.util.List;

public class PartTimeEmployeeServiceManagementImpl implements PartTimeEmployeeServiceManagement {
    private List<PartTimeEmployee> partTimeEmployeeList;

    public PartTimeEmployeeServiceManagementImpl(){
        partTimeEmployeeList = new ArrayList<>();
    }
    @Override
    public void showAllPartTimeEmployee() {
        if(partTimeEmployeeList.isEmpty()){
            System.out.println("Part time employee list is blank!!!");
        }
        for(PartTimeEmployee partTimeEmployee: partTimeEmployeeList){
            partTimeEmployee.displayInfo();
        }
    }

    @Override
    public void showPartTimeEmployeeById(String employeeId) {
        if(findPartTimeEmployeeById(employeeId) == null){
            System.out.println("Part time employee Id does not exist");
            return;
        }
        findPartTimeEmployeeById(employeeId).displayInfo();
    }

    @Override
    public PartTimeEmployee findPartTimeEmployeeById(String employeeId) {
        for(PartTimeEmployee partTimeEmployee : partTimeEmployeeList){
            if(partTimeEmployee.getEmployeeId().equalsIgnoreCase(employeeId)){
                return partTimeEmployee;
            }
        }
        return null;
    }

    @Override
    public boolean addPartTimeEmployee(PartTimeEmployee partTimeEmployee) {
        if(partTimeEmployeeList.add(partTimeEmployee)){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateSalaryPartTimeEmployeeById(String employeeId,  double hourRate) {
        if(findPartTimeEmployeeById(employeeId) == null){
            System.out.println("Part time employee Id does not exist");
            return false;
        }
        findPartTimeEmployeeById(employeeId).setHourlyRate(hourRate);
        return true;
    }

    @Override
    public boolean deletePartEmployeeById(String employeeId) {
        if(findPartTimeEmployeeById(employeeId) == null){
            System.out.println("Part time employee Id does not exist");
            return false;
        }
        if(partTimeEmployeeList.remove(findPartTimeEmployeeById(employeeId))){
            return true;
        }
        return false;
    }
}
