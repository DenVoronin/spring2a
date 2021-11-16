package cars.services.impl;

import cars.entity.Engine;
import cars.repository.EngineRepository;
import cars.services.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineServiceImpl implements EngineService {
    @Autowired
    private EngineRepository engineRepository;

    @Override
    public Engine newEngine(Engine engine) {
        Engine savedEngine = engineRepository.saveAndFlush(engine);

        return savedEngine;
    }

    @Override
    public void delete(int id) {
        engineRepository.deleteById(id);
    }

    @Override
    public Engine getByName(String engine) {
        return engineRepository.findByName(engine);
    }

    @Override
    public Engine getById(int id) {
        return engineRepository.findById(id);
    }

    @Override
    public Engine editEngine(Engine engine) {
        return engineRepository.saveAndFlush(engine);
    }

    @Override
    public List<Engine> getAll() {
        return engineRepository.findAll();
    }
}
