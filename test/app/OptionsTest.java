package app;

import exceptions.NoSuchOptionException;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class OptionsTest {

    @Test
    void shouldReturnExitOption() {
        final int option = Options.EXIT.ordinal();
        assertEquals(Options.EXIT, Options.getOptionFromInt(option));
    }

    @Test
    void shouldReturnAddPassengerCarOption() {
        final int option = Options.ADD_PASSENGER_CAR.ordinal();
        assertEquals(Options.ADD_PASSENGER_CAR, Options.getOptionFromInt(option));
    }

    @Test
    void shouldReturnAddLightCommercialCar() {
        final int option = Options.ADD_LIGHT_COMMERCIAL_CAR.ordinal();
        assertEquals(Options.ADD_LIGHT_COMMERCIAL_CAR, Options.getOptionFromInt(option));
    }

    @Test
    void shouldReturnRemoveCarOption() {
        final int option = Options.REMOVE_CAR.ordinal();
        assertEquals(Options.REMOVE_CAR, Options.getOptionFromInt(option));
    }

    @Test
    void shouldReturnPrintPassengerCarsOption() {
        final int option = Options.PRINT_PASSENGER_CARS.ordinal();
        assertEquals(Options.PRINT_PASSENGER_CARS, Options.getOptionFromInt(option));
    }

    @Test
    void shouldReturnPrintLightCommercialCarsOption() {
        final int option = Options.PRINT_LIGHT_COMMERCIAL_CARS.ordinal();
        assertEquals(Options.PRINT_LIGHT_COMMERCIAL_CARS, Options.getOptionFromInt(option));
    }

    @Test
    void shouldReturnAddUserOption() {
        final int option = Options.ADD_USER.ordinal();
        assertEquals(Options.ADD_USER, Options.getOptionFromInt(option));
    }

    @Test
    void shouldReturnRemoveUserOption() {
        final int option = Options.REMOVE_USER.ordinal();
        assertEquals(Options.REMOVE_USER, Options.getOptionFromInt(option));
    }

    @Test
    void shouldReturnPrintUsersOption() {
        final int option = Options.PRINT_USERS.ordinal();
        assertEquals(Options.PRINT_USERS, Options.getOptionFromInt(option));
    }

    @Test
    void shouldReturnRentCarOption() {
        final int option = Options.RENT_CAR.ordinal();
        assertEquals(Options.RENT_CAR, Options.getOptionFromInt(option));
    }

    @Test
    void shouldReturnReturnCarOption() {
        final int option = Options.RETURN_CAR.ordinal();
        assertEquals(Options.RETURN_CAR, Options.getOptionFromInt(option));
    }

    @Test
    void shouldThrowExceptionWithIncorectEnumOption() {
        final int option = 1000;
        assertThrows(NoSuchOptionException.class, () -> Options.getOptionFromInt(option));
    }

    @Test
    void shouldThrowExceptionWithWrongFormatOfEnumOption() {
        final String option = "someString";
        assertThrows(NumberFormatException.class, () -> Options.getOptionFromInt(Integer.valueOf(option)));
    }

}