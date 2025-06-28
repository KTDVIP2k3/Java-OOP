package Models;

public class Laptop {
    private String serialNumber;
    private String brand;
    private String specs;

    public Laptop(String serialNumber, String brand, String specs) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.specs = specs;
    }

    public String getSerialNumber() { return serialNumber; }
    public String getBrand() { return brand; }
    public String getSpecs() { return specs; }

    public void setBrand(String brand) { this.brand = brand; }
    public void setSpecs(String specs) { this.specs = specs; }

    @Override
    public String toString() {
        return "Laptop{" + "serial='" + serialNumber + "', brand='" + brand + "', specs='" + specs + "'}";
    }
}
