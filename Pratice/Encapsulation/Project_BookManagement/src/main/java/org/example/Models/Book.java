package org.example.Models;

public class Book {
    private String bookId;
    private String tilte;
    private String author;
    private String description;
    private int quantity;
    private double price;
    private boolean isAvailabe;

    public Book(){}

    public Book(String bookId, String tilte, String author, String description, int quantity, double price, boolean isAvailabe) {
        this.bookId = bookId;
        this.tilte = tilte;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.isAvailabe = isAvailabe;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailabe() {
        return isAvailabe;
    }

    public void setAvailabe(boolean availabe) {
        isAvailabe = availabe;
    }

    public void showInforBook(){
      System.out.println("BookId: " + this.bookId + " - " + this.tilte + " - " + "Author: "  + this.author +
              " - " + "Description: " +  this.description + " - " + "Quantity: " + this.quantity
              + " - " + "Price: " + this.price + " - " + "Avaialbe: " + this.isAvailabe);
    }
}
