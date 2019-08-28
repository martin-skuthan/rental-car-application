package model;

import java.util.Objects;

public abstract class Car {
    private String brand;
    private String model;
    private int seats;
    private boolean airConditioning;
    private String transmission;

    Car(String brand, String model, int seats, boolean airConditioning, String transmission) {
        this.brand = brand;
        this.model = model;
        this.seats = seats;
        this.airConditioning = airConditioning;
        this.transmission = transmission;
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

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return brand + ", " + model + ", " + seats + ", " + airConditioning + ", " + transmission;
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
