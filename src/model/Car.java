package model;

import model.enums.Transmission;

import java.io.Serializable;
import java.util.Objects;

public abstract class Car implements Serializable {
    private String registrationNumber;
    private String brand;
    private String model;
    private int seats;
    private boolean airConditioning;
    private Transmission transmission;

    Car(String registrationNumber, String brand, String model, int seats, boolean airConditioning, Transmission transmission) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        this.seats = seats;
        this.airConditioning = airConditioning;
        this.transmission = transmission;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public abstract String convertToCsv();

    @Override
    public String toString() {
        return registrationNumber + ", " + brand + ", " + model + ", " + seats + ", " + airConditioning + ", " + transmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return seats == car.seats &&
                airConditioning == car.airConditioning &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model) &&
                Objects.equals(transmission, car.transmission);
    }

    @Override
    public int hashCode() {

        return Objects.hash(brand, model, seats, airConditioning, transmission);
    }
}
