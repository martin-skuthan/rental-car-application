package io.file;

import exceptions.ExportDataException;
import exceptions.ImportDataException;
import exceptions.InvalidDataException;
import model.*;
import model.enums.Transmission;
import model.enums.TypeOfDrive;

import java.io.*;
import java.util.Collection;

public class CsvFileManager implements FileManager {
    private static final String CARS_FILE_NAME = "CarRentalCars.csv";
    private static final String USERS_FILE_NAME = "CarRentalUsers.csv";

    public void exportData(CarRental carRental) {
        exportCars(carRental);
        exportUsers(carRental);
    }

    public CarRental importData() {
        CarRental carRental = new CarRental();
        importCars(carRental);
        importUsers(carRental);
        return carRental;
    }

    private void exportCars(CarRental carRental) {
        Collection<Car> cars = carRental.getCars().values();
        exportCollection(cars, CARS_FILE_NAME);
    }

    private void exportUsers(CarRental carRental) {
        Collection<CarRentalUser> users = carRental.getCarRentalUsers().values();
        exportCollection(users, USERS_FILE_NAME);
    }

    private <T extends CsvConvert> void  exportCollection(Collection<T> collection, String fileName) {
        try(
                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                ) {
            for (T element : collection) {
                bufferedWriter.write(element.convertToCsv());
                bufferedWriter.newLine();
            }
        }catch (IOException ex) {
            throw new ExportDataException("Problem with export data to: " + fileName);
        }
    }

    private void importCars(CarRental carRental) {
       try(
               FileReader fileReader = new FileReader(CARS_FILE_NAME);
               BufferedReader bufferedReader = new BufferedReader(fileReader);
               )  {
           String line = null;
           while ((line = bufferedReader.readLine()) != null) {
               Car car = createCarFromString(line);
               carRental.addCar(car);
           }
       }catch (IOException ex) {
           throw new ImportDataException("Problem with import data from:" + CARS_FILE_NAME);
       }
    }

    private void importUsers(CarRental carRental) {
        try(
                FileReader fileReader = new FileReader(USERS_FILE_NAME);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                ) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                CarRentalUser carRentalUser = createCarRentalUser(line);
                carRental.addCarRentalUser(carRentalUser);
            }
        }catch (IOException ex) {
            throw new ImportDataException("Problem with import data from:" + USERS_FILE_NAME);
        }
    }

    private Car createCarFromString(String line) {
        String[] split = line.split(";");
        String typeOfCar = split[0];
        if (typeOfCar.equals(PassengerCar.TYPE_OF_CAR)) {
            return createPassengerCar(split);
        }else if (typeOfCar.equals(LightCommercialCar.TYPE_OF_CAR)) {
            return createLightCommercialCar(split);
        }

        throw new InvalidDataException("Problem with data");
    }

    private PassengerCar createPassengerCar(String[] split) {
        String registrationNumber = split[1];
        String brand = split[2];
        String model = split[3];
        int seats = Integer.valueOf(split[4]);
        boolean airConditioning = Boolean.valueOf(split[5]);
        Transmission transmission = Transmission.getFromDescription(split[6]);
        int numberOfDoors = Integer.valueOf(split[7]);
        TypeOfDrive typeOfDrive = TypeOfDrive.getFromDescription(split[8]);
        int trunkCapacity = Integer.valueOf(split[9]);

        return new PassengerCar(registrationNumber, brand, model, seats, airConditioning, transmission, numberOfDoors,
                                typeOfDrive, trunkCapacity);
    }

    private LightCommercialCar createLightCommercialCar(String[] split) {
        String registrationNumber = split[1];
        String brand = split[2];
        String model = split[3];
        int seats = Integer.valueOf(split[4]);
        boolean airConditioning = Boolean.valueOf(split[5]);
        Transmission transmission = Transmission.getFromDescription(split[6]);
        double payLoad = Double.valueOf(split[7]);
        double loadVolume = Double.valueOf(split[8]);
        double loadHeight = Double.valueOf(split[9]);
        double loadWidth = Double.valueOf(split[10]);
        double loadLength = Double.valueOf(split[11]);

        return new LightCommercialCar(registrationNumber, brand, model, seats, airConditioning, transmission, payLoad,
                                      loadVolume, loadHeight, loadWidth, loadLength);
    }

    private CarRentalUser createCarRentalUser(String line) {
        String[] spltit = line.split(";");
        String userId = spltit[0];
        String firstName = spltit[1];
        String lastName = spltit[2];
        String pesel = spltit[3];

        return new CarRentalUser(userId, firstName, lastName, pesel);
    }



}
