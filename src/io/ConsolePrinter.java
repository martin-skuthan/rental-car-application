package io;

import model.Car;
import model.LightCommercialCar;
import model.PassengerCar;

import java.util.Collection;
import java.util.Collections;

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
            System.out.println("There is no ligt commercial cars in car rental");
        }
    }
}
