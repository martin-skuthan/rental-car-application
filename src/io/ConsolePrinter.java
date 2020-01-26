package io;

import model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ConsolePrinter {

    public void printPassengerCars(Collection<Car> cars) {
        int counter = 0;
        for (Car car : cars) {
            if (car instanceof PassengerCar) {
                System.out.println(car);
                counter++;
            }
        }

        if (counter == 0) {
            System.out.println("There is no passenger cars in car rental.");
        }
    }

    public void printLightCommercialCars(Collection<Car> cars) {
        int counter = 0;
        for (Car car : cars) {
            if (car instanceof LightCommercialCar) {
                System.out.println(car);
                counter++;
            }
        }

        if (counter == 0) {
            System.out.println("There is no light commercial cars in car rental");
        }
    }

    public void printCarRentalUsers(Collection<User> carRentalUsers) {
        int counter = 0;
        for (User user : carRentalUsers) {
            System.out.println(user);
            counter++;
        }

        if (counter == 0) {
            System.out.println("There is no users in car rental");
        }
    }
}
