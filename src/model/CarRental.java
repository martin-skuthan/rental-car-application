package model;

import exceptions.CarAlreadyExistsException;

import java.util.HashMap;
import java.util.Map;

public class CarRental {
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

    public void printPassengerCars() {
        int counter = 0;
        for (Car car : cars.values()) {
            if (car instanceof PassengerCar) {
                System.out.println(car);
                counter++;
            }
        }

        if (counter == 0) {
            System.out.println("There is no passenger cars in car rental.");
        }
    }

    public void printLightCommercialCars() {
        int counter = 0;
        for (Car car : cars.values()) {
            if (car instanceof LightCommercialCar) {
                System.out.println(car);
                counter++;
            }
        }

        if (counter == 0) {
            System.out.println("There is no ligt commercial cars in car rental");
        }
    }
}
