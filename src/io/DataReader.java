package io;

import model.CarRentalUser;
import model.LightCommercialCar;
import model.PassengerCar;
import model.enums.Transmission;
import model.enums.TypeOfDrive;
import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void nextLine() {
        scanner.nextLine();
    }

    public int getInt() {
        try {
            return scanner.nextInt();
        }finally {
            scanner.nextLine();
        }
    }

    public String getString() {
        return scanner.nextLine();
    }

    public boolean getBoolean() {
        try {
            return scanner.nextBoolean();
        }finally {
            scanner.nextLine();
        }
    }

    public String getCarRegistrationNuber() {
        System.out.println("Enter registration number:");
        return getString();
    }

    public String getUserPesel() {
        System.out.println("Enter pesel:");
        return getString();
    }

    public void close() {
        scanner.close();
    }

    public PassengerCar readAndCreatePassengerCar() {
        System.out.println("Registration number: ");
        String registrationNumber = scanner.nextLine();
        System.out.println("Brand: ");
        String brand = scanner.nextLine();
        System.out.println("Model: ");
        String model = scanner.nextLine();
        System.out.println("Number of seats: ");
        int seats = getInt();
        System.out.println("Air conditioning(true/false): ");
        boolean airConditioning = getBoolean();
        System.out.println("Transmission(manual/automatic): ");
        String transmissionDesc = scanner.nextLine();
        Transmission transmission = Transmission.getFromDescription(transmissionDesc);
        System.out.println("Number of doors: ");
        int numberOfDoors = getInt();
        System.out.println("Type of drive(petrol/diesel/hybrid): ");
        String typeOfDriveDesc = scanner.nextLine();
        TypeOfDrive typeOfDrive = TypeOfDrive.getFromDescription(typeOfDriveDesc);
        System.out.println("Trunk capacity(in suitcases): ");
        int trunkCapacity = getInt();

        return new PassengerCar(registrationNumber,brand, model, seats, airConditioning, transmission, null,
                                numberOfDoors, typeOfDrive, trunkCapacity);
    }

    public LightCommercialCar readAndCreateLightCommercialCar() {
        System.out.println("Registration number: ");
        String registrationNumber = scanner.nextLine();
        System.out.println("Brand: ");
        String brand = scanner.nextLine();
        System.out.println("Model: ");
        String model = scanner.nextLine();
        System.out.println("Number of seats: ");
        int seats = getInt();
        System.out.println("Air conditioning(true/false): ");
        boolean airConditioning = getBoolean();
        System.out.println("Transmission(manual/automatic): ");
        String transmissionDesc = scanner.nextLine();
        Transmission transmission = Transmission.getFromDescription(transmissionDesc);
        System.out.println("Payload(kg): ");
        double payload = scanner.nextDouble();
        System.out.println("Load volume(m3): ");
        double loadVolume = scanner.nextDouble();
        System.out.println("Load height(m): ");
        double loadHeight = scanner.nextDouble();
        System.out.println("Load width(m): ");
        double loadWidth = scanner.nextDouble();
        System.out.println("Load length(m): ");
        double loadLegth = scanner.nextDouble();

        return new LightCommercialCar(registrationNumber, brand, model, seats, airConditioning, transmission, null,
                                      payload, loadVolume, loadHeight, loadWidth, loadLegth);
    }

    public CarRentalUser readAndCreateCarRentalUser() {
        System.out.println("First name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Pesel: ");
        String pesel = scanner.nextLine();

        return new CarRentalUser(firstName, lastName, pesel);
    }
}
