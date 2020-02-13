package model;

import exceptions.CarAlreadyExistsException;
import exceptions.CarNotFoundException;
import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
import io.database.dao.MySqlCarDao;
import io.database.dao.MySqlUserDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class DataBaseCarRental implements CarRental {
    private MySqlCarDao mySqlCarDao;
    private MySqlUserDao mySqlUserDao;

    public DataBaseCarRental() {
        mySqlCarDao = new MySqlCarDao();
        mySqlUserDao = new MySqlUserDao();
    }

    @Override
    public Collection<Car> getSortedCars(Comparator<Car> comparator) {
        ArrayList<Car> cars = new ArrayList<>(mySqlCarDao.readAll());
        cars.sort(comparator);
        return cars;
    }

    @Override
    public Collection<User> getSortedUsers(Comparator<User> comparator) {
        ArrayList<User> users = new ArrayList<>(mySqlUserDao.readAll());
        users.sort(comparator);
        return users;
    }

    @Override
    public void addCar(Car car) {
        if (car.getRegistrationNumber() == null) {
            throw new NullPointerException("Regisration number cannot be null");
        }

        Car foundCar = mySqlCarDao.read(car.getRegistrationNumber());
        if (foundCar != null) {
            throw new CarAlreadyExistsException("Car with this registration number already exists");
        }

        mySqlCarDao.create(car);
    }

    @Override
    public boolean removeCar(String registrationNumber) {
        Car foundCar = mySqlCarDao.read(registrationNumber);
        if (foundCar != null) {
            mySqlCarDao.delete(registrationNumber);
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

        User foundUser = mySqlUserDao.read(user.getPesel());
        if (foundUser != null) {
            throw new UserAlreadyExistsException("User with this pesel already exists");
        }

        mySqlUserDao.create(user);
    }

    @Override
    public boolean removeCarRentalUser(String pesel) {
        User foundUser = mySqlUserDao.read(pesel);
        if (foundUser != null) {
            mySqlUserDao.delete(pesel);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void rentCar(String registrationNumber, String pesel) {
        Car carFound = mySqlCarDao.read(registrationNumber);
        User userFound = mySqlUserDao.read(pesel);
        if (carFound == null) {
            throw new CarNotFoundException("Car with this registration number not found");
        }

        if (userFound == null) {
            throw new UserNotFoundException("User with this pesel not found");
        }

        carFound.setUser(userFound);
        mySqlCarDao.update(carFound);
    }

}
