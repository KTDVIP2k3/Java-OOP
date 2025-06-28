package Menu;

import ImplementService.FullTimeEmployeeServiceManagementImpl;
import Models.FullTimeEmployee;

import java.util.Scanner;

public class FullTimeEmployeeManagementMenu {
    private final FullTimeEmployeeServiceManagementImpl fullTimeEmployeeServiceManagement;


    public FullTimeEmployeeManagementMenu(Scanner sc){
        fullTimeEmployeeServiceManagement = new FullTimeEmployeeServiceManagementImpl();
    }

    public void showFullTimeManageMenu(Scanner sc){
        int choice = 0;
        do{
            System.out.println("==========Full-Time Employee Management Menu");
            System.out.println("1.Show All Full-Time employee");
            System.out.println("2.Show Full-Time employee by id");
            System.out.println("3.Add Full-Time employee");
            System.out.println("4.Update Full-Time employee salary by id");
            System.out.println("5.Delete Full-Time employee by id");
            System.out.println("6.Exist");
            System.out.print("Please enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    showFullTimeEmployeeList();
                    break;
                case 2:
                    showwFullTimeEmployeeById(sc);
                    break;
                case 3:
                    addFullTimeEmployee(sc);
                    break;
                case 4:
                    updateFullTimeEmployeeById(sc);
                    break;
                case 5:
                    deleteFullTimeById(sc);
                    break;
                case 6:
                    System.out.println("Back main menu!!!");
                    break;
                default:
                    System.out.println("Invalid choice!!");
                    break;

            }
        }while(choice != 6);
    }

    private void showFullTimeEmployeeList(){
        System.out.println("Full_Time employee list");
        fullTimeEmployeeServiceManagement.showAllFullTimeEmployee();
    }

    private void showwFullTimeEmployeeById(Scanner sc){
        System.out.print("Please enter full-time employee Id: ");
        fullTimeEmployeeServiceManagement.showFullTimeEmployeeById(sc.nextLine());
    }

    private void addFullTimeEmployee(Scanner sc){
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
        System.out.print("Please enter full-time employee Id: ");
        fullTimeEmployee.setEmployeeId(sc.nextLine());
        System.out.print("Please enter full-time employee name: ");
        fullTimeEmployee.setName(sc.nextLine());
        System.out.print("Please enter full-time employee address: ");
        fullTimeEmployee.setAddress(sc.nextLine());
        System.out.print("Please enter full-time employee phone: ");
        fullTimeEmployee.setPhone(sc.nextLine());
        System.out.print("Please enter full-time employee month salary: ");
        fullTimeEmployee.setMonthSalary(Double.parseDouble(sc.nextLine()));
        if(fullTimeEmployeeServiceManagement.addFullTimeEmployee(fullTimeEmployee)){
            System.out.println("Add full-time employee successfully");
        }else{
            System.out.println("Add full-time employee failed");
        }
    }

    private void updateFullTimeEmployeeById(Scanner sc){
        String fullTimeId;
        double salary;
        System.out.print("Please enter full-time employee id");
        fullTimeId = sc.nextLine();
        if(fullTimeEmployeeServiceManagement.findFullTimeEmployeeById(fullTimeId) == null){
            System.out.println("Full-Time employee id does not exist");
            return;
        }
        System.out.print("Please enter full-time salary: ");
        salary = Double.parseDouble(sc.nextLine());
        if(fullTimeEmployeeServiceManagement.updateSalaryFullTimeEmployeeById(fullTimeId, salary)){
            System.out.println("Update full-time employee successfully");
        }else{
            System.out.println("Update full-time employee failed");
        }
    }

    private void deleteFullTimeById(Scanner sc){
        System.out.print("Please enter full-time employee id");
        if(fullTimeEmployeeServiceManagement.findFullTimeEmployeeById(sc.nextLine()) == null){
            System.out.println("Full-Time employee id does not exist");
            return;
        }
        if(fullTimeEmployeeServiceManagement.deleteFullTimeEmployeeById(sc.nextLine())){
            System.out.println("Delete full-time successfully");
            return;
        }
        System.out.println("Delete full-time failed");
    }
}
