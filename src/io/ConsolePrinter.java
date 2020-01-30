package io;

import exceptions.NoSuchTypeException;
import io.enums.PrintFilter;
import model.*;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ConsolePrinter {
    private DataReader dataReader;

    public ConsolePrinter(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    public void printPassengerCars(Collection<Car> cars) {
        PrintFilter printFilter = getPrintFilter();
        Supplier<Stream<Car>> streamSupplier = () -> cars.stream();
        switch (printFilter) {
            case AVAILABLE:
                System.out.println("Available cars:");
                streamSupplier.get().filter(car -> car.getUser() == null && car instanceof PassengerCar).
                        forEach(System.out::println);
                if (streamSupplier.get().noneMatch(car -> car.getUser() == null && car instanceof PassengerCar)) {
                    System.out.println("There is no available car in car rental");
                }
                break;
            case RENTED:
                System.out.println("Rented cars:");
                streamSupplier.get().filter(car -> car.getUser() != null && car instanceof PassengerCar).
                        forEach(System.out::println);
                if (streamSupplier.get().noneMatch(car -> car.getUser() != null && car instanceof PassengerCar)) {
                    System.out.println("There is no rented cars in car rental");
                }
                break;
            case ALL:
                streamSupplier.get().filter(car -> car instanceof PassengerCar).forEach(System.out::println);
                if (streamSupplier.get().noneMatch(car -> car instanceof PassengerCar)) {
                    System.out.println("There is no passenger cars in car rental");
                }
                break;
        }
    }

    public void printLightCommercialCars(Collection<Car> cars) {
        PrintFilter printFilter = getPrintFilter();
        Supplier<Stream<Car>> streamSupplier = () -> cars.stream();
        switch (printFilter) {
            case AVAILABLE:
                streamSupplier.get().filter(car -> car.getUser() == null && car instanceof LightCommercialCar).
                        forEach(System.out::println);
                if (streamSupplier.get().noneMatch(car -> car.getUser() == null && car instanceof LightCommercialCar)) {
                    System.out.println("There is no available car in car rental");
                }
                break;
            case RENTED:
                streamSupplier.get().filter(car -> car.getUser() != null && car instanceof LightCommercialCar).
                        forEach(System.out::println);
                if (streamSupplier.get().noneMatch(car -> car.getUser() == null && car instanceof LightCommercialCar)) {
                    System.out.println("There is no rented cars in car rental");
                }
                break;
            case ALL:
                streamSupplier.get().filter(car -> car instanceof LightCommercialCar).forEach(System.out::println);
                if (streamSupplier.get().noneMatch(car -> car instanceof LightCommercialCar)) {
                    System.out.println("There is no light commercial cars in car rental");
                }
                break;
        }
    }

    public void printCarRentalUsers(Collection<User> carRentalUsers) {
        Supplier<Stream<User>> streamSupplier = () -> carRentalUsers.stream();
        streamSupplier.get().forEach(System.out::println);
        if (streamSupplier.get().count() == 0) {
            System.out.println("There is no users in car rental");
        }
    }

    private PrintFilter getPrintFilter() {
        PrintFilter printFilter = null;
        boolean optionOk = false;
        while (!optionOk) {
            try {
                printOptions();
                String description = dataReader.getString().toUpperCase();
                printFilter = PrintFilter.getPrintFilter(description);
                optionOk = true;
            }catch (NoSuchTypeException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return printFilter;
    }

    private void printOptions() {
        for (PrintFilter printFilter : PrintFilter.values()) {
            System.out.println(printFilter);
        }
    }
}
