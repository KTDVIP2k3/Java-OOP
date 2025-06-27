package org.example;

public class Food {
    private String foodId;
    private String name;
    private double price;
    private String category;
    private boolean isAvailabe;
    private String description;

    public Food() {
    }

    public Food(String foodId, String name, double price, String category, boolean isAvailabe, String description) {
        this.foodId = foodId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.isAvailabe = isAvailabe;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailabe() {
        return isAvailabe;
    }

    public void setAvailabe(boolean availabe) {
        isAvailabe = availabe;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Category: %s | Price: %.2f | Available: %s | Desc: %s",
                foodId, name, category, price, isAvailabe ? "Yes" : "No", description);
    }
}
