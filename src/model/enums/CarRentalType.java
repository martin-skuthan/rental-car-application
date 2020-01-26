package model.enums;

import exceptions.NoSuchTypeException;

public enum CarRentalType {
    DATABASE,
    FILE;

    public static CarRentalType getCarRentalType(String description) {
        try{
            return CarRentalType.valueOf(description);
        }catch (IllegalArgumentException ex) {
            throw new NoSuchTypeException("There is no option:" + description);
        }
    }
}
