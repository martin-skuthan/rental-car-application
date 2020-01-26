package model;

import java.util.Collection;
import java.util.Comparator;

public interface CarRental {

    public void addCar(Car car);

    public boolean removeCar(String registrationNumber);

    public void addCarRentalUser(CarRentalUser user);

    public boolean removeCarRentalUser(String pesel);

    public Collection<Car> getSortedCars(Comparator<Car> comparator);

    public Collection<User> getSortedUsers(Comparator<User> comparator);

}
