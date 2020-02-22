package model.enums;

import exceptions.NoSuchTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransmissionTest {

    @Test
    void shouldReturnManualTransmission() {
        final String description = "MANUAL";
        assertEquals(Transmission.MANUAL, Transmission.getFromDescription(description));
    }

    @Test
    void shouldReturnAutomaticTransmission() {
        final String description = "AUTOMATIC";
        assertEquals(Transmission.AUTOMATIC, Transmission.getFromDescription(description));
    }

    @Test
    void shouldThrowExceptionWithWrongEnumDescription() {
        final String description = "wrongDescription";
        assertThrows(NoSuchTypeException.class, () -> Transmission.getFromDescription(description));
    }

    @Test
    void shouldThrowExceptionWithEmptyEnumDescription() {
        final String description = "";
        assertThrows(NoSuchTypeException.class, () -> Transmission.getFromDescription(description));
    }

    @Test
    void shouldThrowExcpetionWithNullEnumDescription() {
        final String description = null;
        assertThrows(NullPointerException.class, () -> Transmission.getFromDescription(description));
    }
}