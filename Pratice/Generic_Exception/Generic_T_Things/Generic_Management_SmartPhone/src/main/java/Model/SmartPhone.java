package Model;

public class SmartPhone {
    private String id;
    private String name;
    private String brand;
    private String model;
    private String processor;
    private int ramGB;
    private int storageGB;
    private String displayType;
    private int batteryMah;
    private String operatingSystem;

    public SmartPhone() {
    }

    public SmartPhone(String id, String name, String brand, String model, String processor, int storageGB, int ramGB, String displayType, int batteryMah, String operatingSystem) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.storageGB = storageGB;
        this.ramGB = ramGB;
        this.displayType = displayType;
        this.batteryMah = batteryMah;
        this.operatingSystem = operatingSystem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRamGB() {
        return ramGB;
    }

    public void setRamGB(int ramGB) {
        this.ramGB = ramGB;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public int getStorageGB() {
        return storageGB;
    }

    public void setStorageGB(int storageGB) {
        this.storageGB = storageGB;
    }

    public int getBatteryMah() {
        return batteryMah;
    }

    public void setBatteryMah(int batteryMah) {
        this.batteryMah = batteryMah;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String showInformation() {
        return "SmartPhone{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", processor='" + processor + '\'' +
                ", ramGB=" + ramGB +
                ", storageGB=" + storageGB +
                ", displayType='" + displayType + '\'' +
                ", batteryMah=" + batteryMah +
                ", operatingSystem='" + operatingSystem + '\'' +
                '}';
    }
}
