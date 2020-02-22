package model.enums;

import exceptions.NoSuchTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeOfDriveTest {

    @Test
    void shouldReturnPetrolTypeOfDrive() {
        final String description = "PETROL";
        assertEquals(TypeOfDrive.PETROL, TypeOfDrive.getFromDescription(description));
    }

    @Test
    void shouldReturnDieselTypeOfDrive() {
        final String description = "DIESEL";
        assertEquals(TypeOfDrive.DIESEL, TypeOfDrive.getFromDescription(description));
    }

    @Test
    void shouldReturnHybridTypeOfDrive() {
        final String description = "HYBRID";
        assertEquals(TypeOfDrive.HYBRID, TypeOfDrive.getFromDescription(description));
    }

    @Test
    void shouldThrowExceptionWithWrongEnumDescription() {
        final String description = "wrongDescription";
        assertThrows(NoSuchTypeException.class, () -> TypeOfDrive.getFromDescription(description));
    }

    @Test
    void shouldThrowExceptionWithEmptyEnumDescription() {
        final String description = "";
        assertThrows(NoSuchTypeException.class, () -> TypeOfDrive.getFromDescription(description));
    }

    @Test
    void shouldThrowExcpetionWithNullEnumDescription() {
        final String description = null;
        assertThrows(NullPointerException.class, () -> TypeOfDrive.getFromDescription(description));
    }

}