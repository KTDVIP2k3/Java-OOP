package org.example;

import Models.Drink;
import Service.ProductServiceManagement;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductServiceManagement productServiceManagement = new ProductServiceManagement();
        int choice = 0;
        do{
            System.out.println("==============Book Management=======");
            System.out.println("1.Show all Drink");
            System.out.println("2. Add new drink");
            System.out.println("3. Update drink name by Id");
            System.out.println("4.Delete drink by Id");
            System.out.println("5.Exist");
            System.out.print("Please enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    productServiceManagement.showListOfDrink();
                    break;
                case 2:
                    Drink drink = new Drink();
                    System.out.print("Please enter id: ");
                    drink.setProductId(sc.nextLine());
                    System.out.print("Please enter name: ");
                    drink.setName(sc.nextLine());
                    System.out.print("Please enter price: ");
                    drink.setPrice(Double.parseDouble(sc.nextLine()));
                    System.out.print("Please enter category: ");
                    drink.setCategory(sc.nextLine());
                    if(productServiceManagement.addDrink(drink)){
                        System.out.println("Add new drink successfully");
                    }else{
                        System.out.println("Add new drink failed");
                    }

                    break;
                case 3:
                    String drinkId, name;
                    System.out.print("Please enter id: ");
                    drinkId = sc.nextLine();
                    System.out.print("Please enter new name: ");
                    name = sc.nextLine();
                    if(productServiceManagement.updateDrinkNameById(drinkId, name)){
                        System.out.println("Update new name drink successfully");
                    }else{
                        System.out.println("Update new name drink failed");
                    }
                    break;
                case 4:
                    System.out.print("Please enter id: ");
                    if(productServiceManagement.deleteDrinkById(sc.nextLine())){
                        System.out.println("Delete drink successfully");
                    }else{
                        System.out.println("Delete drink failed");
                    }
                    break;
                default:
                    System.out.println("Invalid choice!!!");
                    break;
            }

        }while (choice != 5);
    }
}