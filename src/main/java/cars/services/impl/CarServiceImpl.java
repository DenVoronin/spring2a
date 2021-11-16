package cars.services.impl;

import cars.entity.Car;
import cars.repository.CarRepository;
import cars.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car newCar(Car car) {
        Car savedCar = carRepository.saveAndFlush(car);

        return savedCar;
    }

    @Override
    public void delete(int id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car getByName(String car) {
        return carRepository.findByName(car);
    }

    @Override
    public Car getById(int id) {
        return carRepository.findById(id);
    }

    @Override
    public Car editCar(Car car) {
        return carRepository.saveAndFlush(car);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }
}
