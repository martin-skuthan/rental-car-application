package model;

import exceptions.NoSuchTypeException;
import io.DataReader;
import model.enums.CarRentalType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CarRentalFactoryTest {
    private CarRentalFactory carRentalFactory;

    @BeforeEach
    void setUp() {
        carRentalFactory = new CarRentalFactory(new DataReader());
    }

    @Test
    void shouldBuildFileCarRental() {
        final String scannerSource = "file";
        setDataReaderScanner(scannerSource);
        assertTrue(carRentalFactory.buildCarRental() instanceof FileCarRental);
    }

   @Test
   void shouldThrownExceptionWhenTryingReadWrongCarRentalType() {
        final String scannerSource = "wrongCarRentalType";
        setDataReaderScanner(scannerSource);
        assertThrows(NoSuchElementException.class, () -> carRentalFactory.buildCarRental());
   }

    private void setDataReaderScanner(String scannerSource) {
        Scanner scanner = new Scanner(scannerSource);
        carRentalFactory.getDataReader().setScanner(scanner);
    }

}