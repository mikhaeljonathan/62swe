package sixtytwo.swe.service;

import sixtytwo.swe.data.Car;
import sixtytwo.swe.repository.CarRepository;

public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car get(String id) {
        Car car = carRepository.selectById(id);
        if (car != null) {
            return car;
        } else {
            throw new IllegalArgumentException("Car not found");
        }
    }

    public Car insert(String brand, String type) {
        Car car = new Car(brand, type);
        carRepository.insert(car);
        return car;
    }
}
