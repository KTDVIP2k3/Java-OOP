package org.UI;

import Model.BankAccount;
import ServiceImplements.BankAccountServiceImplements;
import ServiceInterfaces.BankAccountServiceInterfaces;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner scanner = new Scanner(System.in);


    private static final BankAccountServiceInterfaces bankAccountServiceInterfaces = new BankAccountServiceImplements();

    public static void main(String[] args) {
        try{
            int choice = 0;
            boolean flag = true;
            do{
                System.out.println("============System=========");
                System.out.println("1.Admin Management");
                System.out.println("2.Customer Management");
                System.out.println("3.Exit");
                System.out.print("Please enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        showAdminMenuManagement();
                        break;
                    case 2:
                        showCustomerMenuManagement();
                        break;
                    case 3:
                        System.out.println("Exit.....");
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }while (flag);
        }catch (NumberFormatException numberFormatException){
            System.out.println("Choice should be digit: " + numberFormatException.getMessage());
        }

    }

    private static void showAdminMenuManagement(){
        try{
            int choice = 0;
            boolean flag = true;
            do{
                System.out.println("============Bank Account Management=========");
                System.out.println("1.Get All Bank Account");
                System.out.println("2.Get Bank Account");
                System.out.println("3.Add new bank account");
                System.out.println("4.Update password bank account");
                System.out.println("5.Delete bank account");
                System.out.println("6.Exit!!!");
                System.out.print("Please enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        List<BankAccount> bankAccountList = bankAccountServiceInterfaces.getAllBankAccount();
                        System.out.println("Bank Account List");
                        for(BankAccount bankAccount : bankAccountList){
                            System.out.println(bankAccount.showOverall());
                        }
                        break;
                    case 2:{
                        System.out.print("Please input account number: ");
                        String accountNumber = scanner.nextLine();
                        System.out.println(bankAccountServiceInterfaces.findBankAccountByAccountNumber(accountNumber).showOverall());
                        break;
                    }

                    case 3: {
                        String accountNumber = getInput(scanner, "Please input account number: ");
                        String accountHolderName = getInput(scanner, "Please input account holder name: ");
                        String accountType = getInput(scanner, "Please input account type: ");
                        String password = getInput(scanner, "Please input password: ");
                        String address = getInput(scanner, "Please input address: ");
                        if (bankAccountServiceInterfaces.addBankAccount(accountNumber, accountHolderName, accountType, password, address)) {
                            System.out.println("Add bank account successfully!!");
                        } else {
                            System.out.println("Add bank account fail!!");
                        }
                        break;
                    }
                    case 4:{
                        String accountNumber = getInput(scanner, "Please input account number: ");
                        String password = getInput(scanner, "Please input new password: ");
                        if(bankAccountServiceInterfaces.updatePasswordBankAccountByAccountNumber(accountNumber, password)){
                            System.out.println("Update new password succesfully!!!");
                        }else{
                            System.out.println("Update new password failed!!!");
                        }
                        break;
                    }
                    case 5:{
                        String accountNumber = getInput(scanner, "Please input account number: ");
                        if(bankAccountServiceInterfaces.deleteBankAccountByAccountNumber(accountNumber)){
                            System.out.println("Delete bank account succesfully!!!");
                        }else{
                            System.out.println("Delete bank account failed!!!");
                        }
                        break;
                    }
                    case 6:
                        System.out.println("Back To Bank Account Management.....");
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid Input!!!");
                        break;

                }
            }while (flag);
        }catch (IllegalArgumentException e){
            System.out.println("\nError service: " + e.getMessage());
        }
        catch (Exception e){
            System.out.println("\nChoice should be digit: " + e.getMessage());
        }

    }

    private static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static void showCustomerMenuManagement(){
       try{
           int choice = 0;
           boolean flag = true;
           do{
               System.out.println("============Bank Account Management=========");
               System.out.println("1.Get Bank Account Detail");
               System.out.println("2.Deposit Into Bank Account");
               System.out.println("3.Withdraw From Bank Account");;
               System.out.println("4.Exit!!!");
               System.out.print("Please enter your choice: ");
               choice = Integer.parseInt(scanner.nextLine());
               switch (choice){
                   case 1: {
                       System.out.print("Please input account number: ");
                       String accountNumber = scanner.nextLine();
                      System.out.println( bankAccountServiceInterfaces.findBankAccountByAccountNumber(accountNumber).showAccountDetail());
                       break;
                   }
                   case 2:{
                       try{
                           String accountNumber = getInput(scanner, "Please input account number: ");
                           System.out.print("Please input amount want deposit into your bank account: ");
                          if( bankAccountServiceInterfaces.findBankAccountByAccountNumber(accountNumber).deposit(Integer.parseInt(scanner.nextLine()))){
                              System.out.println("Deposit into bank account successfully");
                          }else{
                              System.out.println("Deposit into bank account failed");
                          }
                       }catch (NumberFormatException numberFormatException){
                           System.out.println("Amount should be digit!!!");
                       }
                       break;
                   }
                   case 3:{
                       try{
                           String accountNumber = getInput(scanner, "Please input account number: ");
                           System.out.print("Please input amount want withdraw into your bank account: ");
                           if(bankAccountServiceInterfaces.findBankAccountByAccountNumber(accountNumber).withdraw(Integer.parseInt(scanner.nextLine()))){
                               System.out.println("Withdraw into bank account successfully");
                           }else{
                               System.out.println("Withdraw into bank account failed");
                           }
                       }catch (NumberFormatException numberFormatException){
                           System.out.println("Amount should be digit!!!");
                       }
                       break;
                   }
                   case 4:{
                       System.out.println("Back To Bank Account Management.....");
                       flag = false;
                   }
                   default:
                       System.out.println("Invalid Input!!!");
                       break;
               }
           }while (flag);

       }catch (IllegalArgumentException illegalArgumentException){
           System.out.println("\nError service: " + illegalArgumentException.getMessage());
       }
       catch (Exception e){
           System.out.println("\nChoice should be digit: " + e.getMessage());
       }

    }
}