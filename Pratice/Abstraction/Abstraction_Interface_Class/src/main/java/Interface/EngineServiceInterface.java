package Interface;

import Models.Engine;

public interface EngineServiceInterface {
    public void showEngine();

    public boolean addEngine(Engine engine);

    public boolean findEngineById(String engineId);

    public boolean updateEngineById(String engineId);

    public boolean deleteEngineById(String engineId);
}
