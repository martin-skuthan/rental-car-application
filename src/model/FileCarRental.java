package model;

import exceptions.CarAlreadyExistsException;
import exceptions.CarNotFoundException;
import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;

import java.io.Serializable;
import java.util.*;

public class FileCarRental implements CarRental, Serializable {
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

    @Override
    public Collection<Car> getSortedCars(Comparator<Car> comparator) {
        ArrayList<Car> cars = new ArrayList<>(getCars().values());
        cars.sort(comparator);
        return cars;
    }

    @Override
    public Collection<User> getSortedUsers(Comparator<User> comparator) {
        ArrayList<User> users = new ArrayList<>(getCarRentalUsers().values());
        users.sort(comparator);
        return users;
    }

    @Override
    public void addCar(Car car) {
        if (car.getRegistrationNumber() == null) {
            throw new NullPointerException("Registration number cannot be null");
        }

        if (cars.containsKey(car.getRegistrationNumber())) {
            throw new CarAlreadyExistsException("Car with this registration number already exists");
        }

        cars.put(car.getRegistrationNumber(), car);
    }

    @Override
    public boolean removeCar(String registrationNumber) {
        if (cars.containsKey(registrationNumber)) {
            cars.remove(registrationNumber);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void addCarRentalUser(CarRentalUser user) {
        if (user.getPesel() == null) {
            throw new NullPointerException("Pesel cannot be null");
        }

        if (carRentalUsers.containsKey(user.getPesel())) {
            throw new UserAlreadyExistsException("User with this pesel already exists");
        }

        carRentalUsers.put(user.getPesel(), user);
    }

    @Override
    public boolean removeCarRentalUser(String pesel) {
        if (carRentalUsers.containsKey(pesel)) {
            carRentalUsers.remove(pesel);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void rentCar(String registrationNumber, String pesel) {
        if (!cars.containsKey(registrationNumber)) {
            throw new CarNotFoundException("Car with this registration number not found");
        }

        if (!carRentalUsers.containsKey(pesel)) {
            throw new UserNotFoundException("User with this pesel not found");
        }

        Car carFound = cars.get(registrationNumber);
        User userFound = carRentalUsers.get(pesel);
        carFound.setUser(userFound);
    }
}
