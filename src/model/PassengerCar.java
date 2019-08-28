package model;

import java.util.Objects;

public class PassengerCar extends Car {
    private int numberOfDoors;
    private String typeOfDrive;
    private int trunkCapacity;

    public PassengerCar(String brand, String model, int seats, boolean airConditioning, String transmission,
                        int numberOfDoors, String typeOfDrive, int trunkCapacity) {
        super(brand, model, seats, airConditioning, transmission);
        this.typeOfDrive = typeOfDrive;
        this.trunkCapacity = trunkCapacity;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getTypeOfDrive() {
        return typeOfDrive;
    }

    public void setTypeOfDrive(String typeOfDrive) {
        this.typeOfDrive = typeOfDrive;
    }

    public int getTrunkCapacity() {
        return trunkCapacity;
    }

    public void setTrunkCapacity(int trunkCapacity) {
        this.trunkCapacity = trunkCapacity;
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
