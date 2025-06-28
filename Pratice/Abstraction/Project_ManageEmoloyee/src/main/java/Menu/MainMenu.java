package Menu;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PartTimeManagementMenu partTimeManagementMenu = new PartTimeManagementMenu();
        FullTimeEmployeeManagementMenu fullTimeEmployeeManagementMenu = new FullTimeEmployeeManagementMenu();
        int choice = 0;
        do{
            System.out.println("=========Employee Management Menu=========");
            System.out.println("1.Full-Time Employee Management Menu");
            System.out.println("2.Part-Time Employee Management Menu");
            System.out.println("3.Exist");
            System.out.print("Please enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    fullTimeEmployeeManagementMenu.showFullTimeManageMenu(sc);
                    break;
                case 2:
                    partTimeManagementMenu.showFullTimeManageMenu(sc);
                    break;
                case 3:
                    System.out.println("Good Bye!!!!");
                    break;
                default:
                    System.out.println("Invalid choice!!!");
                    break;
            }
        }while(choice != 3);
    }
}