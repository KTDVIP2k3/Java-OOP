package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Food> foodList = new ArrayList<>(); // this is new data structure will be mentioned in next lesson
        int choice;

        do {
            System.out.println("\n===== FOOD MANAGEMENT MENU =====");
            System.out.println("1. Add new food");
            System.out.println("2. Show all foods");
            System.out.println("3. Update price by food ID");
            System.out.println("4. Delete food by ID");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter food ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    System.out.print("Available (true/false): ");
                    boolean available = Boolean.parseBoolean(sc.nextLine());
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();

                    Food food = new Food(id, name, price, category, available, desc);
                    foodList.add(food);
                    System.out.println("✅ Food added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- FOOD LIST ---");
                    if (foodList.isEmpty()) {
                        System.out.println("⚠️  No food found.");
                    } else {
                        for (Food f : foodList) {
                            System.out.println(f);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter food ID to update price: ");
                    String updateId = sc.nextLine();
                    boolean found = false;
                    for (Food f : foodList) {
                        if (f.getFoodId().equals(updateId)) {
                            System.out.print("Enter new price: ");
                            double newPrice = Double.parseDouble(sc.nextLine());
                            f.setPrice(newPrice);
                            System.out.println("✅ Price updated.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("❌ Food not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter food ID to delete: ");
                    String deleteId = sc.nextLine();
                    boolean removed = foodList.removeIf(f -> f.getFoodId().equals(deleteId));
                    if (removed) {
                        System.out.println("✅ Food deleted.");
                    } else {
                        System.out.println("❌ Food not found.");
                    }
                    break;

                case 5:
                    System.out.println("👋 Goodbye!");
                    break;

                default:
                    System.out.println("❗ Invalid choice.");
            }

        } while (choice != 5);
    }
}