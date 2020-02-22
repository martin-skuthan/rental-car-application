package model.enums;

import exceptions.NoSuchTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarRentalTypeTest {

    @Test
    void shouldReturnDatabaseCarRentalType() {
        final String description = "DATABASE";
        assertEquals(CarRentalType.DATABASE, CarRentalType.getCarRentalType(description));
    }

    @Test
    void shouldReturnFileCarRentalType() {
        final String description = "FILE";
        assertEquals(CarRentalType.FILE, CarRentalType.getCarRentalType(description));
    }

    @Test
    void shouldThrowExceptionWithWrongEnumDescription() {
        final String description = "wrongDescription";
        assertThrows(NoSuchTypeException.class, () -> CarRentalType.getCarRentalType(description));
    }

    @Test
    void shouldThrowExceptionWithEmptyEnumDescription() {
        final String description = "";
        assertThrows(NoSuchTypeException.class, () -> CarRentalType.getCarRentalType(description));
    }

    @Test
    void shouldThrowExcpetionWithNullEnumDescription() {
        final String description = null;
        assertThrows(NullPointerException.class, () -> CarRentalType.getCarRentalType(description));
    }

}