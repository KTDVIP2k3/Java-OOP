package Models;

public class Product {
    //This is the super class product which another subclass can inherit their attributes and methods
    protected String productId;
    protected String name;
    protected String description;
    protected double price;
    protected int quantity;

    public Product(){}

    public Product(String productId, String name, String description, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //This special method is all applied the inheritance principle OOP
    // In OOP have 1 super class all everything class is object and this method toString() is created by this superclass
    //Now we use keyword @Override this method
    @Override
    public String toString(){
        return "Product Id: " + productId + " - " + "Name: " + name
                + " - " + "Description: " + description + " - " + "Price: " + price
                + " - " + "Quantity: " + quantity;
    }
}
