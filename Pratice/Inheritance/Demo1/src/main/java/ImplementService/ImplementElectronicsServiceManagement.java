package ImplementService;

import InterfaceService.InterfaceElectronicService;
import Models.Electronic;

import java.util.ArrayList;
import java.util.List;

public class ImplementElectronicsServiceManagement implements InterfaceElectronicService {
    private final List<Electronic> electronicList;

    public ImplementElectronicsServiceManagement(){
        electronicList = new ArrayList<>();
    }

    @Override
    public void showAllElectronics() {
        if(electronicList.isEmpty()){
            System.out.println("The electronic list is blank!!!");
            return;
        }
        for(Electronic electronic : electronicList){
            electronic.toString();
        }
    }

    @Override
    public void showElectronicById(String id) {
        if(findElectronicById(id) == null){
            System.out.println("The electronic id does not exist");
            return;
        }
        findElectronicById(id).toString();
    }

    @Override
    public Electronic findElectronicById(String id) {
        for(Electronic electronic : electronicList){
            if(electronic.getProductId().equalsIgnoreCase(id)){
                return electronic;
            }
        }
        return null;
    }

    @Override
    public boolean addElectronics(Electronic electronic) {
        if(electronicList.add(electronic)){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateElectronicWarrantMonthsById(String id, int warrantMonths) {
        if(findElectronicById(id) == null){
            System.out.println("The electronic id does not exist");
            return false;
        }
        findElectronicById(id).setWarrantMonths(warrantMonths);
        return true;
    }

    @Override
    public boolean deleteElectronicById(String id) {
        if(findElectronicById(id) == null){
            System.out.println("The electronic id does not exist");
            return false;
        }
        electronicList.remove(findElectronicById(id));
        return true;
    }
}
