package io.enums;

import exceptions.NoSuchTypeException;

public enum PrintFilter {
    AVAILABLE,
    RENTED,
    ALL;

    public static PrintFilter getPrintFilter(String description) {
        try{
            return PrintFilter.valueOf(description);
        }catch (IllegalArgumentException ex) {
            throw new NoSuchTypeException("There is no option:" + description);
        }
    }
}
