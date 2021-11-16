package cars.services;

import cars.entity.Engine;

import java.util.List;

public interface EngineService {
    Engine newEngine(Engine engine);
    void delete(int id);
    Engine getByName(String engine);
    Engine getById(int id);
    Engine editEngine(Engine engine);
    List<Engine> getAll();
}
