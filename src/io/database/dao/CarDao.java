package io.database.dao;

import model.Car;

import java.util.Collection;
import java.util.List;

public interface CarDao {

    public void create(Car car);

    public Car read(String registrationNumber);

    public Collection<Car> readAll();

    public void update(Car car);

    public void delete(String registrationNumber);
}
