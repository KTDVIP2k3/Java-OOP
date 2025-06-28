package InterfaceService;

import Models.Electronic;

public interface InterfaceElectronicService {

    public void showAllElectronics();

    public void showElectronicById(String id);

    public Electronic findElectronicById(String id);

    public boolean addElectronics(Electronic electronic);

    public boolean updateElectronicWarrantMonthsById(String id, int warrantMonths);

    public boolean deleteElectronicById(String id);


}
