package Models;

public class Drink extends Product{
    //This is the class that inherit the subclass Product
    private String category;

    public Drink(String productId, String name, double price, String category) {
        super(productId, name, price);
        this.category = category;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public void displayInfo() {
        System.out.println("productID : " + super.productId + " - " + "Name: " + super.name + "Category :" + category);
    }
}
