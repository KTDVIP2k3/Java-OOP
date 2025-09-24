package ServiceImplements;

import Model.SmartPhone;


import java.util.List;


public class SmartPhoneServiceImplement {

    private final GenericServiceImplement<SmartPhone> genericServiceImplement = new GenericServiceImplement<>();

    private void validateSmartphone(SmartPhone smartPhone) {
        if (smartPhone == null) {
            throw new IllegalArgumentException("Smartphone object cannot be null.");
        }
        if (smartPhone.getId() == null || smartPhone.getId().trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
        if (smartPhone.getBatteryMah() < 1000) {
            throw new IllegalArgumentException("Invalid battery capacity. Must be at least 1000 mAh.");
        }
        if (smartPhone.getRamGB() < 2) {
            throw new IllegalArgumentException("Invalid RAM. Must be at least 2 GB.");
        }
    }

    private void validateId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
    }

    private void validateExistingSmartphone(String id) throws Exception{
        if (genericServiceImplement.findById(id) == null) {
            throw new IllegalArgumentException("Smartphone with ID " + id + " does not exist.");
        }
    }

    public List<SmartPhone> getAll() throws Exception{
        List<SmartPhone> allPhones = genericServiceImplement.getAll();
        if (allPhones.isEmpty()) {
            throw new IllegalArgumentException("List of smartphones is empty.");
        }
        return allPhones;
    }

    public SmartPhone findById(String id) throws Exception{
        validateId(id);
        SmartPhone foundPhone = genericServiceImplement.findById(id);
        if (foundPhone == null) {
            throw new IllegalArgumentException("Smartphone with ID " + id + " does not exist.");
        }
        return foundPhone;
    }

public boolean add(SmartPhone smartPhone) throws Exception{
        validateSmartphone(smartPhone);
        if (genericServiceImplement.findById(smartPhone.getId()) != null) {
            throw new IllegalArgumentException("Smartphone with ID " + smartPhone.getId() + " already exists.");
        }
        return genericServiceImplement.add(smartPhone);
    }

    public boolean update(SmartPhone smartPhone) throws Exception{
        validateSmartphone(smartPhone);
        validateExistingSmartphone(smartPhone.getId());
        return genericServiceImplement.update(smartPhone);
    }

    public boolean deleteById(String id) throws Exception{
        validateId(id);
        validateExistingSmartphone(id);
        return genericServiceImplement.deleteById(id);
    }
}