package app;

import exceptions.NoSuchOptionException;

public enum Options {
    EXIT("Exit"),
    ADD_PASSENGER_CAR("Add passenger car"),
    ADD_LIGHT_COMMERCIAL_CAR("Add light commercial car"),
    REMOVE_CAR("Remove car"),
    PRINT_PASSENGER_CARS("Print passenger cars"),
    PRINT_LIGHT_COMMERCIAL_CARS("Print light commercial cars"),
    ADD_USER("Add user"),
    REMOVE_USER("Remove user"),
    PRINT_USERS("Print users"),
    RENT_CAR("Rent car"),
    RETURN_CAR("Return car");

    String description;

    Options(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.ordinal() + " - " + description;
    }

    public static Options getOptionFromInt(int option) {
        try {
            return Options.values()[option];
        }catch (ArrayIndexOutOfBoundsException ex) {
            throw new NoSuchOptionException("There is no option with id : " + option);
        }
    }
}
