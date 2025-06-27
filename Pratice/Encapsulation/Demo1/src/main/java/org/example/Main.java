package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount();
        System.out.print("Please enter account number: ");
        bankAccount.setAccountNumber(sc.nextLine());
        System.out.print("Please enter owner name: ");
        bankAccount.setOwnerName(sc.nextLine());
        System.out.print("Enter initial ballace: ");
        bankAccount.setBalance(Double.parseDouble(sc.nextLine()));

        int choice = 0;

        do{
            System.out.println("\n===== BANK ACCOUNT MENU =====");
            System.out.println("1. Show account info");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1 :
                    bankAccount.showBanAccountInfo();
                    break;
                case 2:
                    System.out.print("Please enter ammount that you want to depost: ");
                    bankAccount.deposit(Double.parseDouble(sc.nextLine()));
                    break;
                case 3:
                    System.out.print("Please enter ammount that you want to withdraw: ");
                    bankAccount.withdraw(Double.parseDouble(sc.nextLine()));
                    break;
                case 4:
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }while(choice != 4);
    }
}