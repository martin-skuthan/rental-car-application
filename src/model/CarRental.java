package model;

import exceptions.CarAlreadyExistsException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CarRental implements Serializable{
    private Map<String, Car> cars = new HashMap<>();

    public Map<String, Car> getCars() {
        return cars;
    }

    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        if (car.getRegistrationNumber() == null) {
            throw new NullPointerException("Registration number cannot be null");
        }

        if (cars.containsKey(car.getRegistrationNumber())) {
            throw new CarAlreadyExistsException("Car with this registration number already exists");
        }

        cars.put(car.getRegistrationNumber(), car);
    }

    public boolean removeCar(String registrationNumber) {
        if (!cars.containsKey(registrationNumber)) {
            return false;
        }else {
            cars.remove(registrationNumber);
            return true;
        }
    }
}
