package Models;
//Keyword extends was used in previous lesson in abstraction principle
//It was used by subclass who inherit superclass or abstract class
public class Electronic extends Product{
    private String model;
    private int warrantMonths;
    private boolean rechargeable;

    public Electronic(){}


    public Electronic(String productId, String name, String description, double price, int quantity, String model, int warrantMonths, boolean rechargeable) {
        super(productId, name, description, price, quantity);
        //this the keyword super represent by superclass and this super is constructor of superclass.
        this.model = model;
        this.warrantMonths = warrantMonths;
        this.rechargeable = rechargeable;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWarrantMonths() {
        return warrantMonths;
    }

    public void setWarrantMonths(int warrantMonths) {
        this.warrantMonths = warrantMonths;
    }

    public boolean isRechargeable() {
        return rechargeable;
    }

    public void setRechargeable(boolean rechargeable) {
        this.rechargeable = rechargeable;
    }


    //Reuse the method toString() was override in superclass from subclass
    @Override
    public String toString(){
        return super.toString() + " - " + "Model: " + this.model + " - " + "Warrant months: " + this.warrantMonths
                + " - " + "Rechargeable: " + this.rechargeable;
    }
}
