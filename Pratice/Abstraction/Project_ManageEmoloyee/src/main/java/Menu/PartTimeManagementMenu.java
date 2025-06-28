package Menu;

import ImplementService.PartTimeEmployeeServiceManagementImpl;
import Models.FullTimeEmployee;
import Models.PartTimeEmployee;

import java.util.Scanner;

public class PartTimeManagementMenu {
    private final PartTimeEmployeeServiceManagementImpl partTimeEmployeeServiceManagement;

    public PartTimeManagementMenu(){
        partTimeEmployeeServiceManagement = new PartTimeEmployeeServiceManagementImpl();
    }

    public void showFullTimeManageMenu(Scanner sc){
        int choice = 0;
        do{
            System.out.println("==========Full-Time Employee Management Menu");
            System.out.println("1.Show All Part-Time employee");
            System.out.println("2.Show Part-Time employee by id");
            System.out.println("3.Add Part-Time employee");
            System.out.println("4.Update Part-Time employee salary by id");
            System.out.println("5.Delete Part-Time employee by id");
            System.out.println("6.Exist");
            System.out.print("Please enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    showPartTimeEmployeeList();
                    break;
                case 2:
                    showwPartTimeEmployeeById(sc);
                    break;
                case 3:
                    addPartTimeEmployee(sc);
                    break;
                case 4:
                    updatePartTimeEmployeeById(sc);
                    break;
                case 5:
                    deletePartTimeById(sc);
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

    private void showPartTimeEmployeeList(){
        System.out.println("Part_Time employee list");
        partTimeEmployeeServiceManagement.showAllPartTimeEmployee();
    }

    private void showwPartTimeEmployeeById(Scanner sc){
        System.out.print("Please enter part-time employee Id: ");
        partTimeEmployeeServiceManagement.findPartTimeEmployeeById(sc.nextLine());
    }

    private void addPartTimeEmployee(Scanner sc){
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
        System.out.print("Please enter part-time employee Id: ");
        partTimeEmployee.setEmployeeId(sc.nextLine());
        System.out.print("Please enter part-time employee name: ");
        partTimeEmployee.setName(sc.nextLine());
        System.out.print("Please enter part-time employee address: ");
        partTimeEmployee.setAddress(sc.nextLine());
        System.out.print("Please enter part-time employee phone: ");
        partTimeEmployee.setPhone(sc.nextLine());
        System.out.print("Please enter part-time employee hour rate: ");
        partTimeEmployee.setHourlyRate(Double.parseDouble(sc.nextLine()));
        if(partTimeEmployeeServiceManagement.addPartTimeEmployee(partTimeEmployee)){
            System.out.println("Add part-time employee successfully");
        }else{
            System.out.println("Add part-time employee failed");
        }
    }

    private void updatePartTimeEmployeeById(Scanner sc){
        String partTimeId;
        double salary;
        System.out.print("Please enter part-time employee id");
        partTimeId = sc.nextLine();
        if(partTimeEmployeeServiceManagement.findPartTimeEmployeeById(partTimeId) == null){
            System.out.println("Part-Time employee id does not exist");
            return;
        }
        System.out.print("Please enter full-time salary: ");
        salary = Double.parseDouble(sc.nextLine());
        if(partTimeEmployeeServiceManagement.updateSalaryPartTimeEmployeeById(partTimeId, salary)){
            System.out.println("Update part-time employee successfully");
        }else{
            System.out.println("Update part-time employee failed");
        }
    }

    private void deletePartTimeById(Scanner sc){
        System.out.print("Please enter part-time employee id");
        if(partTimeEmployeeServiceManagement.findPartTimeEmployeeById(sc.nextLine()) == null){
            System.out.println("Part-Time employee id does not exist");
            return;
        }
        if(partTimeEmployeeServiceManagement.deletePartEmployeeById(sc.nextLine())){
            System.out.println("Delete part-time successfully");
            return;
        }
        System.out.println("Delete part-time failed");
    }
}
