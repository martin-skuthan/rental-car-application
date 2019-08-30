package io;

import model.LightCommercialCar;
import model.PassengerCar;

import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner(System.in);

    public int getInt() {
        try {
            return scanner.nextInt();
        }finally {
            scanner.nextLine();
        }
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
        boolean airConditioning = scanner.nextBoolean();
        System.out.println("Transmission: ");
        String transmission = scanner.nextLine();
        System.out.println("Number of doors: ");
        int doors = getInt();
        System.out.println("Type of drive(): ");
        String typeOfDrive = scanner.nextLine();
        System.out.println("Trunk capacity(in suitcases): ");
        int trunkCapacity = getInt();

        return new PassengerCar(registrationNumber,brand, model, seats, airConditioning, transmission, doors,
                                typeOfDrive, trunkCapacity);
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
        boolean airConditioning = scanner.nextBoolean();
        System.out.println("Transmission: ");
        String transmission = scanner.nextLine();
        System.out.println("Payload(kg): ");
        double payload = scanner.nextDouble();
        System.out.println("Load volume(m3): ");
        double loadVolume = scanner.nextDouble();
        System.out.println("Load height: ");
        double loadHeight = scanner.nextDouble();
        System.out.println("Load width: ");
        double loadWidth = scanner.nextDouble();
        System.out.println("Load length: ");
        double loadLegth = scanner.nextDouble();

        return new LightCommercialCar(registrationNumber, brand, model, seats, airConditioning, transmission , payload,
                                      loadVolume, loadHeight, loadWidth, loadLegth);
    }
}
