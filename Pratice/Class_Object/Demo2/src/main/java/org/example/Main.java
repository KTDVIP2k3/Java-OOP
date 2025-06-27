package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product product = new Product();
        System.out.print("Please enter product Id: ");
        product.productId = sc.nextLine();
        System.out.print("Please enter product name: ");
        product.name = sc.nextLine();
        System.out.print("Please enter product price: ");
        product.price = Double.parseDouble(sc.nextLine());
        System.out.print("Please enter product quantity: ");
        product.quantity = Integer.parseInt(sc.nextLine());
        System.out.print("Please enter product description: ");
        product.description = sc.nextLine();
        product.inStock = true;

        product.showDetail();
    }
}