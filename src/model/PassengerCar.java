package model;

import model.enums.Transmission;
import model.enums.TypeOfDrive;

import java.util.Objects;

public class PassengerCar extends Car {
    public static final String TYPE_OF_CAR = "Passenger";

    private int numberOfDoors;
    private TypeOfDrive typeOfDrive;
    private int trunkCapacity;

    public PassengerCar(String registrationNumber, String brand, String model, int seats, boolean airConditioning,
                        Transmission transmission, int numberOfDoors, TypeOfDrive typeOfDrive, int trunkCapacity) {
        super(registrationNumber, brand, model, seats, airConditioning, transmission);
        this.typeOfDrive = typeOfDrive;
        this.trunkCapacity = trunkCapacity;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public TypeOfDrive getTypeOfDrive() {
        return typeOfDrive;
    }

    public void setTypeOfDrive(TypeOfDrive typeOfDrive) {
        this.typeOfDrive = typeOfDrive;
    }

    public int getTrunkCapacity() {
        return trunkCapacity;
    }

    public void setTrunkCapacity(int trunkCapacity) {
        this.trunkCapacity = trunkCapacity;
    }

    @Override
    public String convertToCsv() {
        return  TYPE_OF_CAR + ";" +
                getRegistrationNumber() + ";" +
                getBrand() + ";" +
                getModel() + ";" +
                getSeats() + ";" +
                isAirConditioning() + ";" +
                getTransmission() + ";" +
                getNumberOfDoors() + ";" +
                getTypeOfDrive() + ";" +
                trunkCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + numberOfDoors + ", " + typeOfDrive + ", " + trunkCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerCar that = (PassengerCar) o;
        return numberOfDoors == that.numberOfDoors &&
                trunkCapacity == that.trunkCapacity &&
                Objects.equals(typeOfDrive, that.typeOfDrive);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), numberOfDoors, typeOfDrive, trunkCapacity);
    }
}
