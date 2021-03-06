package model;

import model.enums.Transmission;

import java.util.Objects;

public class LightCommercialCar extends Car {
    public static final String TYPE_OF_CAR = "LightCommercial";

    private double payload;
    private double loadVolume;
    private double loadHeight;
    private double loadWidth;
    private double loadLength;

    public LightCommercialCar(String registrationNumber, String brand, String model, int seats, boolean airConditioning,
                              Transmission transmission, User user, double payLoad, double loadVolume, double loadHeight,
                              double loadWidth, double loadLength) {
        super(registrationNumber, brand , model, seats, airConditioning, transmission,user,TYPE_OF_CAR);
        this.payload = payLoad;
        this.loadVolume = loadVolume;
        this.loadHeight = loadHeight;
        this.loadWidth = loadWidth;
        this.loadLength = loadLength;
    }

    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }

    public double getLoadVolume() {
        return loadVolume;
    }

    public void setLoadVolume(double loadVolume) {
        this.loadVolume = loadVolume;
    }

    public double getLoadHeight() {
        return loadHeight;
    }

    public void setLoadHeight(double loadHeight) {
        this.loadHeight = loadHeight;
    }

    public double getLoadWidth() {
        return loadWidth;
    }

    public void setLoadWidth(double loadWidth) {
        this.loadWidth = loadWidth;
    }

    public double getLoadLength() {
        return loadLength;
    }

    public void setLoadLength(double loadLength) {
        this.loadLength = loadLength;
    }

    @Override
    public String convertToCsv() {
        String description = TYPE_OF_CAR + ";" +
                             getRegistrationNumber() + ";" +
                             getBrand() + ";" +
                             getModel() + ";" +
                             getSeats() + ";" +
                             isAirConditioning() + ";" +
                             getTransmission() + ";" +
                             getPayload() + ";" +
                             getLoadVolume() + ";" +
                             getLoadHeight() + ";" +
                             getLoadWidth() + ";" +
                             getLoadLength();
        if (getUser() != null) {
            description += getUser().convertToCsv();
        }

        return description;
    }

    @Override
    public String toString() {
        String description = super.toString() + ", payload(kg):" +
                             payload + ", load volume(m3):" +
                             loadVolume + ", load height(m):" +
                             loadHeight + ", load width(m):" +
                             loadWidth + ", load length(m):" +
                             loadLength;
        if (getUser() != null) {
            description += "Rented by:" + getUser() + "\n";
        }
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LightCommercialCar that = (LightCommercialCar) o;
        return Double.compare(that.payload, payload) == 0 &&
                Double.compare(that.loadVolume, loadVolume) == 0 &&
                Double.compare(that.loadHeight, loadHeight) == 0 &&
                Double.compare(that.loadWidth, loadWidth) == 0 &&
                Double.compare(that.loadLength, loadLength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), payload, loadVolume, loadHeight, loadWidth, loadLength);
    }
}
