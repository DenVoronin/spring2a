package cars.services;

import cars.entity.Car;

import java.util.List;

public interface CarService {
    Car newCar(Car car);
    void delete(int id);
    Car getByName(String car);
    Car getById(int id);
    Car editCar(Car car);
    List<Car> getAll();
}
