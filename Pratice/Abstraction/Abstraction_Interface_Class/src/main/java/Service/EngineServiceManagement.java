package Service;

import Interface.EngineServiceInterface;
import Models.Engine;

import java.util.ArrayList;
import java.util.List;

public class EngineServiceManagement  implements EngineServiceInterface {
    private List<Engine> engineList;

    public EngineServiceManagement() {
        engineList = new ArrayList<>();
    }

    @Override
    public void showEngine() {
        if (engineList.isEmpty()) {
            System.out.println("Engine list is empty.");
        } else {
            System.out.println("=== Engine List ===");
            for (Engine engine : engineList) {
                engine.showInfo();
                System.out.println("--------------------");
            }
        }
    }

    @Override
    public boolean addEngine(Engine engine) {
        // Check for duplicate ID
        for (Engine e : engineList) {
            if (e.getModel().equalsIgnoreCase(engine.getModel())) {
                return false; // Duplicate found
            }
        }
        engineList.add(engine);
        return true;
    }

    @Override
    public boolean findEngineById(String engineId) {
        for (Engine engine : engineList) {
            if (engine.getModel().equalsIgnoreCase(engineId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateEngineById(String engineId) {
        for (Engine engine : engineList) {
            if (engine.getModel().equalsIgnoreCase(engineId)) {
                // Update info (có thể viết thêm code nhập dữ liệu mới từ Scanner)
                engine.setHorsepower(engine.getHorsepower() + 10); // ví dụ tăng thêm
                System.out.println("Engine updated (horsepower increased).");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteEngineById(String engineId) {
        for (Engine engine : engineList) {
            if (engine.getModel().equalsIgnoreCase(engineId)) {
                engineList.remove(engine);
                return true;
            }
        }
        return false;
    }
}
