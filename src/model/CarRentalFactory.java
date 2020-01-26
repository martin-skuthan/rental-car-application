package model;

import exceptions.NoSuchTypeException;
import io.DataReader;
import model.enums.CarRentalType;

public class CarRentalFactory {
    private DataReader dataReader;

    public CarRentalFactory(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    public CarRental buildCarRental() {
        CarRentalType carRentalType = getCarRentalType();
        switch (carRentalType) {
            case FILE:
                return new FileCarRental();
            case DATABASE:
                return new DataBaseCarRental();
            default:
                return null;
        }
    }

    private CarRentalType getCarRentalType() {
        CarRentalType carRentalType = null;
        boolean optionOk = false;
        while (!optionOk) {
            try {
                System.out.println("Select the read and write method: ");
                printOption();
                String description = (dataReader.getString()).toUpperCase();
                carRentalType = CarRentalType.getCarRentalType(description);
                optionOk = true;
            }catch (NoSuchTypeException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return carRentalType;
    }

    private void printOption() {
        for (CarRentalType carRentalType : CarRentalType.values()) {
            System.out.println(carRentalType);
        }
    }
}
