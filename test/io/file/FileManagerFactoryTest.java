package io.file;

import io.DataReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerFactoryTest {
    private FileManagerFactory fileManagerFactory;

    @BeforeEach
    void setUp() {
        this.fileManagerFactory = new FileManagerFactory(new DataReader());
    }

    @Test
    void shouldCreateCsvFileManager() {
        final String scannerSource = "CSV";
        setDataReaderScanner(scannerSource);
        assertTrue(fileManagerFactory.buildFileManager() instanceof CsvFileManager);
    }

    @Test
    void shouldCreateSerializableFileManager() {
        final String scannerSource = "SERIALIZABLE";
        setDataReaderScanner(scannerSource);
        assertTrue(fileManagerFactory.buildFileManager() instanceof SerializableFileManager);
    }

    @Test
    void shouldThrownExceptionWithWrongFileType() {
        final String scannerSource = "wrongFileType";
        setDataReaderScanner(scannerSource);
        assertThrows(NoSuchElementException.class, () -> fileManagerFactory.buildFileManager());
    }

    private void setDataReaderScanner(String scannerSource) {
        Scanner scanner = new Scanner(scannerSource);
        fileManagerFactory.getDataReader().setScanner(scanner);
    }


}