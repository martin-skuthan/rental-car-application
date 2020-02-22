package io.file;

import exceptions.NoSuchTypeException;
import model.enums.CarRentalType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileTypeTest {

    @Test
    void shouldReturnCsvFileType() {
        final String description = "CSV";
        assertEquals(FileType.CSV, FileType.getFileTypeFromDescription(description));
    }

    @Test
    void shouldReturnSerializableFileType() {
        final String description = "SERIALIZABLE";
        assertEquals(FileType.SERIALIZABLE, FileType.getFileTypeFromDescription(description));
    }

    @Test
    void shouldThrowExceptionWithWrongEnumDescription() {
        final String description = "wrongDescription";
        assertThrows(NoSuchTypeException.class, () -> FileType.getFileTypeFromDescription(description));
    }

    @Test
    void shouldThrowExceptionWithEmptyEnumDescription() {
        final String description = "";
        assertThrows(NoSuchTypeException.class, () -> FileType.getFileTypeFromDescription(description));
    }

    @Test
    void shouldThrowExcpetionWithNullEnumDescription() {
        final String description = null;
        assertThrows(NullPointerException.class, () -> FileType.getFileTypeFromDescription(description));
    }

}