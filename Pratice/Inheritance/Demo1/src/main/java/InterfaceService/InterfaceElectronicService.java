package InterfaceService;

import Models.Electronic;

public interface InterfaceElectronicService {
    
    public void showAllElectronics();

    public Electronic findElectronicById(String id);

    public boolean addElectronics(Electronic electronic);

    public boolean updateElectronicWarrantMonthsById(String id);

    public boolean deleteElectronicById(String id);


}
