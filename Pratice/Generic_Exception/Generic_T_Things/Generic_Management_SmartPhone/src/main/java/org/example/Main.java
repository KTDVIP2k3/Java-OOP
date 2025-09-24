package org.example;
import Model.SmartPhone;
import ServiceImplements.SmartPhoneServiceImplement;

import java.util.List;
import java.util.Scanner;
import Model.SmartPhone;
import ServiceImplements.SmartPhoneServiceImplement;

import java.util.List;
import java.util.Scanner;

public class Main {
        private static final SmartPhoneServiceImplement smartPhoneService = new SmartPhoneServiceImplement();
        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            // Add some sample data for testing
            try {
                smartPhoneService.add(new SmartPhone("1", "iPhone 15", "Apple", "15 Pro", "A17", 256, 8, "OLED", 3274, "iOS"));
                smartPhoneService.add(new SmartPhone("2", "Galaxy S24", "Samsung", "S24 Ultra", "Snapdragon 8 Gen 3", 512, 12, "AMOLED", 5000, "Android"));
            } catch (IllegalArgumentException e) {
                System.out.println("Error adding sample data: " + e.getMessage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            int choice;
            do {
                showMenu();
                System.out.print("Enter your choice: ");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            addSmartPhone();
                            break;
                        case 2:
                            updateSmartPhone();
                            break;
                        case 3:
                            deleteSmartPhone();
                            break;
                        case 4:
                            searchById();
                            break;
                        case 5:
                            showAllSmartPhones();
                            break;
                        case 0:
                            System.out.println("Exiting the program. See you again!");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                    choice = -1; // Reset choice to continue the loop
                }
            } while (choice != 0);

            scanner.close();
        }

        private static void showMenu() {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add a new smartphone");
            System.out.println("2. Update smartphone information");
            System.out.println("3. Delete smartphone by ID");
            System.out.println("4. Search smartphone by ID");
            System.out.println("5. Show all smartphones");
            System.out.println("0. Exit");
            System.out.println("--------------------");
        }

        private static void addSmartPhone() {
            try {
                System.out.println("--- ADD A NEW SMARTPHONE ---");
                System.out.print("Enter ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter brand: ");
                String brand = scanner.nextLine();
                System.out.print("Enter model: ");
                String model = scanner.nextLine();
                System.out.print("Enter processor: ");
                String processor = scanner.nextLine();
                System.out.print("Enter RAM (GB): ");
                int ramGB = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter storage (GB): ");
                int storageGB = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter display type: ");
                String displayType = scanner.nextLine();
                System.out.print("Enter battery capacity (mAh): ");
                int batteryMah = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter operating system: ");
                String os = scanner.nextLine();

                SmartPhone newPhone = new SmartPhone(id, name, brand, model, processor, storageGB, ramGB, displayType, batteryMah, os);
                if (smartPhoneService.add(newPhone)) {
                    System.out.println("Smartphone added successfully!");
                }
            } catch (Exception e) {
                System.out.println("Error adding smartphone: " + e.getMessage());
            }
        }

        private static void updateSmartPhone() {
            try {
                System.out.println("--- UPDATE SMARTPHONE INFORMATION ---");
                System.out.print("Enter the ID of the smartphone to update: ");
                String id = scanner.nextLine();

                SmartPhone existingPhone = smartPhoneService.findById(id);

                System.out.println("Enter new information (leave blank to keep current):");
                System.out.printf("Current name: %s, Enter new name: ", existingPhone.getName());
                String name = scanner.nextLine();
                if (!name.isEmpty()) existingPhone.setName(name);

                System.out.printf("Current brand: %s, Enter new brand: ", existingPhone.getBrand());
                String brand = scanner.nextLine();
                if (!brand.isEmpty()) existingPhone.setBrand(brand);

                System.out.printf("Current model: %s, Enter new model: ", existingPhone.getModel());
                String model = scanner.nextLine();
                if (!model.isEmpty()) existingPhone.setModel(model);

                System.out.printf("Current processor: %s, Enter new processor: ", existingPhone.getProcessor());
                String processor = scanner.nextLine();
                if (!processor.isEmpty()) existingPhone.setProcessor(processor);

                System.out.printf("Current RAM: %d GB, Enter new RAM (GB): ", existingPhone.getRamGB());
                String ramStr = scanner.nextLine();
                if (!ramStr.isEmpty()) existingPhone.setRamGB(Integer.parseInt(ramStr));

                System.out.printf("Current storage: %d GB, Enter new storage (GB): ", existingPhone.getStorageGB());
                String storageStr = scanner.nextLine();
                if (!storageStr.isEmpty()) existingPhone.setStorageGB(Integer.parseInt(storageStr));

                System.out.printf("Current display type: %s, Enter new display type: ", existingPhone.getDisplayType());
                String displayType = scanner.nextLine();
                if (!displayType.isEmpty()) existingPhone.setDisplayType(displayType);

                System.out.printf("Current battery: %d mAh, Enter new battery capacity (mAh): ", existingPhone.getBatteryMah());
                String batteryStr = scanner.nextLine();
                if (!batteryStr.isEmpty()) existingPhone.setBatteryMah(Integer.parseInt(batteryStr));

                System.out.printf("Current OS: %s, Enter new OS: ", existingPhone.getOperatingSystem());
                String os = scanner.nextLine();
                if (!os.isEmpty()) existingPhone.setOperatingSystem(os);

                if (smartPhoneService.update(existingPhone)) {
                    System.out.println("Update successful!");
                }
            } catch (Exception e) {
                System.out.println("Error updating smartphone: " + e.getMessage());
            }
        }

        private static void deleteSmartPhone() {
            try {
                System.out.println("--- DELETE SMARTPHONE BY ID ---");
                System.out.print("Enter the ID of the smartphone to delete: ");
                String id = scanner.nextLine();
                if (smartPhoneService.deleteById(id)) {
                    System.out.println("Deletion successful!");
                }
            } catch (Exception e) {
                System.out.println("Error deleting smartphone: " + e.getMessage());
            }
        }

        private static void searchById() {
            try {
                System.out.println("--- SEARCH SMARTPHONE BY ID ---");
                System.out.print("Enter the ID of the smartphone to find: ");
                String id = scanner.nextLine();
                SmartPhone foundPhone = smartPhoneService.findById(id);
                System.out.println("Smartphone found: " + foundPhone.showInformation());
            } catch (Exception e) {
                System.out.println("Error searching: " + e.getMessage());
            }
        }

        private static void showAllSmartPhones() {
            try {
                System.out.println("--- LIST OF ALL SMARTPHONES ---");
                List<SmartPhone> allPhones = smartPhoneService.getAll();
                allPhones.forEach(phone -> System.out.println(phone.showInformation()));
            } catch (Exception e) {
                System.out.println("Error displaying list: " + e.getMessage());
            }
        }
    }
