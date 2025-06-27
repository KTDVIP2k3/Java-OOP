package org.example;

import Models.Engine;
import Service.EngineServiceManagement;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EngineServiceManagement engineService = new EngineServiceManagement();

        int choice;
        do {
            System.out.println("\n========= ENGINE MANAGEMENT =========");
            System.out.println("1. Show all engines");
            System.out.println("2. Add new engine");
            System.out.println("3. Find engine by ID");
            System.out.println("4. Update engine by ID");
            System.out.println("5. Delete engine by ID");
            System.out.println("6. Exit");
            System.out.print("Please enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    engineService.showEngine();
                    break;
                case 2:
                    Engine newEngine = new Engine();

                    System.out.print("Enter engine model (ID): ");
                    newEngine.setModel(sc.nextLine());

                    System.out.print("Enter horsepower: ");
                    newEngine.setHorsepower(Integer.parseInt(sc.nextLine()));

                    if (engineService.addEngine(newEngine)) {
                        System.out.println("✅ Engine added successfully!");
                    } else {
                        System.out.println("❌ Engine already exists!");
                    }
                    break;
                case 3:
                    System.out.print("Enter engine model (ID) to find: ");
                    String findId = sc.nextLine();
                    if (engineService.findEngineById(findId)) {
                        System.out.println("✅ Engine exists in the system.");
                    } else {
                        System.out.println("❌ Engine not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter engine model (ID) to update: ");
                    String updateId = sc.nextLine();
                    if (engineService.updateEngineById(updateId)) {
                        System.out.println("✅ Engine updated.");
                    } else {
                        System.out.println("❌ Engine not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter engine model (ID) to delete: ");
                    String deleteId = sc.nextLine();
                    if (engineService.deleteEngineById(deleteId)) {
                        System.out.println("✅ Engine deleted.");
                    } else {
                        System.out.println("❌ Engine not found.");
                    }
                    break;
                case 6:
                    System.out.println("👋 Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice. Please try again.");
            }

        } while (choice != 6);
    }
}