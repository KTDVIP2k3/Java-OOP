package Models;

import Interface.ShowInforInterface;

public class Engine implements ShowInforInterface {
    private String engineId;
    private String model;
    private int horsepower;
    private double capacity; // dung tích (lít)
    private String fuelType; // loại nhiên liệu: xăng, dầu, điện
    private boolean isRunning;

    // Constructor không tham số
    public Engine() {
    }

    // Constructor đầy đủ tham số
    public Engine(String engineId, String model, int horsepower, double capacity, String fuelType) {
        this.engineId = engineId;
        this.model = model;
        this.horsepower = horsepower;
        this.capacity = capacity;
        this.fuelType = fuelType;
        this.isRunning = false;
    }

    public String getEngineId() {
        return engineId;
    }

    public void setEngineId(String engineId) {
        this.engineId = engineId;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    // Getters & Setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public void showInfo() {
        System.out.println("Engine Id: " + engineId);
        System.out.println("Engine Model: " + model);
        System.out.println("Horsepower: " + horsepower + " HP");
        System.out.println("Capacity: " + capacity + " L");
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Status: " + (isRunning ? "Running" : "Stopped"));
    }
}
