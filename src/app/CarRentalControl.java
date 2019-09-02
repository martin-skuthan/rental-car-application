package app;

import exceptions.ExportDataException;
import exceptions.ImportDataException;
import exceptions.NoSuchOptionException;
import exceptions.NoSuchTypeException;
import io.ConsolePrinter;
import io.DataReader;
import io.file.CsvFileManager;
import model.Car;
import model.CarRental;
import model.LightCommercialCar;
import model.PassengerCar;

import java.util.Collection;
import java.util.InputMismatchException;

public class CarRentalControl {
    private CarRental carRental;
    private DataReader dataReader = new DataReader();
    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private CsvFileManager csvFileManager = new CsvFileManager();

    public CarRentalControl() {
        try {
            carRental = csvFileManager.importData();
            System.out.println("Import from file succeeded");
        }catch (ImportDataException ex) {
            System.out.println(ex.getMessage());
            carRental = new CarRental();
            System.out.println("New Car Rental was created.");
        }
    }

    public void controlLoop() {
        Options option = null;
        do {
            printOptions();
            option = getOption();
            executeOption(option);
        }while (option != Options.EXIT);
    }

    private void printOptions() {
        for (Options option : Options.values()) {
            System.out.println(option);
        }
    }

    private void executeOption(Options option) {
        switch (option) {
            case EXIT:
                close();
                break;
            case ADD_PASSENGER_CAR:
                addPassengerCar();
                break;
            case ADD_LIGHT_COMMERCIAL_CAR:
                addLightCommercialCar();
                break;
            case PRINT_PASSENGER_CARS:
                printPassengerCars();
                break;
            case PRINT_LIGHT_COMMERCIAL_CARS:
                printLightCommercialCars();
                break;
        }
    }

    private Options getOption() {
        boolean optionOk = false;
        Options option = null;
        while (!optionOk) {
            try {
                option = Options.getOptionFromInt(dataReader.getInt());
                optionOk = true;
            }catch (NoSuchOptionException ex) {
                System.out.println(ex.getMessage() + ", try again: ");
            }
        }

        return option;
    }

    private void addPassengerCar() {
        try {
            PassengerCar passengerCar = dataReader.readAndCreatePassengerCar();
            carRental.addCar(passengerCar);
        }catch (NoSuchTypeException ex) {
            System.out.println(ex.getMessage());
        }catch (InputMismatchException ex) {
            System.out.println("Provided value isn't in correct format");
        }
    }

    private void addLightCommercialCar() {
        try {
            LightCommercialCar lightCommercialCar = dataReader.readAndCreateLightCommercialCar();
            carRental.addCar(lightCommercialCar);
        }catch (NoSuchTypeException ex) {
            System.out.println(ex.getMessage());
        }catch (InputMismatchException ex) {
            System.out.println("Provided value isn't in correct format");
        }
    }

    private void printPassengerCars() {
        Collection<Car> cars = carRental.getCars().values();
        consolePrinter.printPassengerCars(cars);
    }

    private void printLightCommercialCars() {
        Collection<Car> cars = carRental.getCars().values();
        consolePrinter.printLightCommercialCars(cars);
    }

    private void close() {
        try {
            csvFileManager.exportData(carRental);
            System.out.println("Export to file succeeded");
        }catch (ExportDataException ex) {
            System.out.println(ex.getMessage());
        }
        dataReader.close();
    }
}
