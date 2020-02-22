package io.enums;

import exceptions.NoSuchTypeException;
import io.file.FileType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintFilterTest {

    @Test
    void shouldReturnAvailablePrintFilter() {
        final String description = "AVAILABLE";
        assertEquals(PrintFilter.AVAILABLE, PrintFilter.getPrintFilter(description));
    }

    @Test
    void shouldReturnRentedPrintFilter() {
        final String description = "RENTED";
        assertEquals(PrintFilter.RENTED, PrintFilter.getPrintFilter(description));
    }

    @Test
    void shouldReturnAllPrintFilter() {
        final String description = "ALL";
        assertEquals(PrintFilter.ALL, PrintFilter.getPrintFilter(description));
    }

    @Test
    void shouldThrowExceptionWithWrongEnumDescription() {
        final String description = "wrongDescription";
        assertThrows(NoSuchTypeException.class, () -> PrintFilter.getPrintFilter(description));
    }

    @Test
    void shouldThrowExceptionWithEmptyEnumDescription() {
        final String description = "";
        assertThrows(NoSuchTypeException.class, () -> PrintFilter.getPrintFilter(description));
    }

    @Test
    void shouldThrowExcpetionWithNullEnumDescription() {
        final String description = null;
        assertThrows(NullPointerException.class, () -> PrintFilter.getPrintFilter(description));
    }

}