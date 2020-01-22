package io.database.dao;

import model.Car;

public interface CarDao {

    public void create(Car car);

    public Car read(String registrationNumber);

    public void update(Car car);

    public void delete(String registrationNumber);
}
