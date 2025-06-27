package org.example;

public class Product {
    String productId;
    String name;
    double price;
    int quantity;
    String description;
    boolean inStock;

    public Product(){}

    public Product(String productId, String name, double price, int quantity, String description, boolean inStock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.inStock = inStock;
    }

    public void showInfo(){
        System.out.print("Product Id: " + this.productId
        + "Name: " + this.name + "Price: " + this.price);
    }

    public void showDetail(){
        System.out.print("Product Id: " + this.productId
                + "Name: " + this.name + "Price: " + this.price + "Quantity: " + this.quantity
                + "Description: " + this.description + "Instock: " + inStock);
    }
}
