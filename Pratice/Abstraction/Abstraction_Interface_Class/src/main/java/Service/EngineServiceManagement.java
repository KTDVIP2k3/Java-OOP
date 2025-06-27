package Service;

import Interface.EngineServiceInterface;
import Models.Engine;

import java.util.ArrayList;
import java.util.List;

public class EngineServiceManagement  implements EngineServiceInterface {
    private List<Engine> engineList;

    public EngineServiceManagement(){
        engineList = new ArrayList<>();
    }

    @Override
    public void showEngine() {
        
    }

    @Override
    public boolean addEngine(Engine engine) {
        return false;
    }

    @Override
    public boolean findEngineById(String engineId) {
        return false;
    }

    @Override
    public boolean updateEngineById(String engineId) {
        return false;
    }

    @Override
    public boolean deleteEngineById(String engineId) {
        return false;
    }
}
