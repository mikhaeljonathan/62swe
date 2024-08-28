package sixtytwo.swe.repository;

import sixtytwo.swe.data.Car;

public interface CarRepository {
    public Car selectById(String id);

    public void insert(Car car);
}
