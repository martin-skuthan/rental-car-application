package model;

import exceptions.CarAlreadyExistsException;
import exceptions.UserAlreadyExistsException;

import java.io.Serializable;
import java.util.*;

public class CarRental implements Serializable{
    private Map<String, Car> cars = new HashMap<>();
    private Map<String, CarRentalUser> carRentalUsers = new HashMap<>();

    public Map<String, Car> getCars() {
        return cars;
    }

    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }

    public Map<String, CarRentalUser> getCarRentalUsers() {
        return carRentalUsers;
    }

    public void setCarRentalUsers(Map<String, CarRentalUser> carRentalUsers) {
        this.carRentalUsers = carRentalUsers;
    }

    public Collection<Car> getSortedCars(Comparator<Car> comparator) {
        ArrayList<Car> cars = new ArrayList<>(getCars().values());
        cars.sort(comparator);
        return cars;
    }

    public Collection<CarRentalUser> getSortedCarRentalUsers(Comparator<CarRentalUser> comparator) {
        ArrayList<CarRentalUser> carRentalUsers = new ArrayList<>(getCarRentalUsers().values());
        carRentalUsers.sort(comparator);
        return carRentalUsers;
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

    public void addCarRentalUser(CarRentalUser carRentalUser) {
        if (carRentalUser.getPesel() == null) {
            throw new NullPointerException("Pesel cannot be null");
        }

        if (carRentalUsers.containsKey(carRentalUser.getPesel())) {
            throw new UserAlreadyExistsException("User with this pesel already exists");
        }

        String userId = generateIdForUser();
        carRentalUser.setUserId(userId);
        carRentalUsers.put(carRentalUser.getPesel(), carRentalUser);
    }

    public boolean removeCarRentalUser(String pesel) {
        if (carRentalUsers.containsKey(pesel)) {
            return false;
        }else {
            carRentalUsers.remove(pesel);
            return true;
        }
    }

    private String generateIdForUser() {
        int numberOfUsers = carRentalUsers.size();
        String userId;
        if (numberOfUsers < 9) {
            userId = "00" + (numberOfUsers + 1);
        }else if (numberOfUsers < 99) {
            userId = "0" + (numberOfUsers + 1);
        }else {
            userId = String.valueOf(numberOfUsers + 1);
        }

        return userId;
    }
}
