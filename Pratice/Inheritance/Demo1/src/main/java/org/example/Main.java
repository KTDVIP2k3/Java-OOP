package org.example;

import ImplementService.ImplementElectronicsServiceManagement;
import Models.Electronic;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ImplementElectronicsServiceManagement service = new ImplementElectronicsServiceManagement();

        int choice;
        do {
            System.out.println("\n===== ELECTRONIC PRODUCT MANAGEMENT =====");
            System.out.println("1. Show all electronic products");
            System.out.println("2. Show electronic product by ID");
            System.out.println("3. Add new electronic product");
            System.out.println("4. Update warranty months by ID");
            System.out.println("5. Delete electronic product by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    service.showAllElectronics();
                    break;
                case 2:
                    System.out.print("Enter product ID to view: ");
                    String idToView = sc.nextLine();
                    service.showElectronicById(idToView);
                    break;
                case 3:
                    Electronic newProduct = new Electronic();

                    System.out.print("Enter product ID: ");
                    newProduct.setProductId(sc.nextLine());

                    System.out.print("Enter product name: ");
                    newProduct.setName(sc.nextLine());

                    System.out.print("Enter product price: ");
                    newProduct.setPrice(Double.parseDouble(sc.nextLine()));

                    System.out.print("Enter product model: ");
                    newProduct.setModel(sc.nextLine());

                    System.out.print("Enter warranty months: ");
                    newProduct.setWarrantMonths(Integer.parseInt(sc.nextLine()));

                    System.out.print("Is it rechargeable? (true/false): ");
                    newProduct.setRechargeable(Boolean.parseBoolean(sc.nextLine()));

                    if (service.addElectronics(newProduct)) {
                        System.out.println("Added successfully.");
                    } else {
                        System.out.println("Failed to add.");
                    }
                    break;
                case 4:
                    System.out.print("Enter product ID to update: ");
                    String idToUpdate = sc.nextLine();
                    System.out.print("Enter new warranty months: ");
                    int months = Integer.parseInt(sc.nextLine());
                    if (service.updateElectronicWarrantMonthsById(idToUpdate, months)) {
                        System.out.println("Update successful.");
                    } else {
                        System.out.println("Update failed.");
                    }
                    break;
                case 5:
                    System.out.print("Enter product ID to delete: ");
                    String idToDelete = sc.nextLine();
                    if (service.deleteElectronicById(idToDelete)) {
                        System.out.println("Deleted successfully.");
                    } else {
                        System.out.println("Deletion failed.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting program. Bye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();

    }
}