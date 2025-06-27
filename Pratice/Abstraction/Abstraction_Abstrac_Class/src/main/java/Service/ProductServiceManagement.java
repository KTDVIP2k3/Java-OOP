package Service;

import Models.Drink;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceManagement {
    private List<Drink> drinkList;

    public ProductServiceManagement(){
        this.drinkList = new ArrayList<>();
    }

    public void showListOfDrink(){
        for(Drink drink: drinkList){
            drink.displayInfo();
        }
    }

    public boolean addDrink(Drink drink){
        if(drinkList.add(drink)){
            return true;
        }
        return false;
    }

    public boolean updateDrinkNameById(String id, String name){
        for(Drink drink : drinkList){
            if(drink.getProductId().equalsIgnoreCase(id)){
                drink.setName(name);
                return true;
            }
        }
        return false;
    }

    public boolean deleteDrinkById(String id){
        for(Drink drink: drinkList){
            if (drink.getProductId().equalsIgnoreCase(id)){
                drinkList.remove(drink);
                return true;
            }
        }
        return false;
    }

}
