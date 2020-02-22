package io;

import exceptions.NoSuchTypeException;
import model.CarRentalUser;
import model.LightCommercialCar;
import model.PassengerCar;
import model.User;
import model.enums.Transmission;
import model.enums.TypeOfDrive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DataReaderTest {
    private DataReader dataReader;

    @BeforeEach
    void setUp() {
        this.dataReader = new DataReader();
    }

    @Test
    void shouldReturnInt() {
        final String scannerSource = "5\n";
        final int resultInt = 5;
        setDataReaderScanner(scannerSource);
        assertEquals(resultInt, dataReader.getInt());
    }

    @Test
    void shouldThrowExceptionWhenTryingReadStringValueInsteadInt() {
        final String scannerSource = "someString";
        setDataReaderScanner(scannerSource);
        assertThrows(InputMismatchException.class, () -> dataReader.getInt());
    }

    @Test
    void shouldReturnString() {
        final String scannerSource = "someString";
        setDataReaderScanner(scannerSource);
        assertEquals(scannerSource, dataReader.getString());
    }

    @Test
    void shouldReturnTrue() {
        final String scannerSource = "true\n";
        setDataReaderScanner(scannerSource);
        assertTrue(dataReader.getBoolean());
    }

    @Test
    void shouldReturnFalse() {
        final String scannerSource = "false\n";
        setDataReaderScanner(scannerSource);
        assertFalse(dataReader.getBoolean());
    }

    @Test
    void shouldThrownExceptionWhenTryingReadNotBoolenValue() {
        final String scannerSource = "someString";
        setDataReaderScanner(scannerSource);
        assertThrows(InputMismatchException.class, () -> dataReader.getBoolean());
    }

    @Test
    void shouldCreateNewPassengerCar() {
        PassengerCar passengerCar = createPassengerCar();
        final String scannerSource = "RegistrationNumber\nBrand\nModel\n4\ntrue\nautomatic\n5\ndiesel\n3\n";
        setDataReaderScanner(scannerSource);
        assertEquals(passengerCar, dataReader.readAndCreatePassengerCar());
    }


    @Test
    void shouldThrownExceptionWhenProvidingWrongTransmissionOfPassengerCar() {
        PassengerCar passengerCar = createPassengerCar();
        final String scannerSource = "RegistrationNumber\nBrand\nModel\n4\ntrue\nwrongTransmission\n5\ndiesel\n3\n";
        setDataReaderScanner(scannerSource);
        assertThrows(NoSuchTypeException.class, () -> dataReader.readAndCreatePassengerCar());
    }

    @Test
    void shouldThrownExceptionWhenProvidingWrongTypeOfDriveOfPassengerCar() {
        PassengerCar passengerCar = createPassengerCar();
        final String scannerSource = "RegistrationNumber\nBrand\nModel\n4\ntrue\nautomatic\n5\nwrongTypeOfDrive\n3\n";
        setDataReaderScanner(scannerSource);
        assertThrows(NoSuchTypeException.class, () -> dataReader.readAndCreatePassengerCar());
    }

    @Test
    void shouldCreateNewLightCommercialCar() {
        LightCommercialCar lightCommercialCar = createLightCommercialCar();
        final String scannerSource = "RegistrationNumber\nBrand\nModel\n4\ntrue\nautomatic\n250\n20\n3\n2\n6\n";
        setDataReaderScanner(scannerSource);
        assertEquals(lightCommercialCar, dataReader.readAndCreateLightCommercialCar());
    }


    @Test
    void shouldThrownExceptionWhenProvidingWrongTransmissionOfLightCommercialCar() {
        LightCommercialCar lightCommercialCar = createLightCommercialCar();
        final String scannerSource = "RegistrationNumber\nBrand\nModel\n4\ntrue\nwrongTransmission\n250\n20\n3\n2\n6\n";
        setDataReaderScanner(scannerSource);
        assertThrows(NoSuchTypeException.class, () -> dataReader.readAndCreateLightCommercialCar());
    }

    @Test
    void shouldCreateNewCarRentalUser() {
        User user = new CarRentalUser("John", "Wick", "00000000000");
        final String scannerSource = "John\nWick\n00000000000";
        setDataReaderScanner(scannerSource);
        assertEquals(user, dataReader.readAndCreateCarRentalUser());
    }

    private void setDataReaderScanner(String scannerSource) {
        Scanner scanner = new Scanner(scannerSource);
        dataReader.setScanner(scanner);
    }

    private PassengerCar createPassengerCar() {
        String registrationNumber = "RegistrationNumber";
        String brand = "Brand";
        String model = "Model";
        int seats = 4;
        boolean airConditioning = true;
        Transmission transmission = Transmission.AUTOMATIC;
        User user = null;
        int numberOfDoors = 5;
        TypeOfDrive typeOfDrive = TypeOfDrive.DIESEL;
        int trunkCapacity = 3;

        return new PassengerCar(registrationNumber, brand, model, seats, airConditioning, transmission, user,
                                numberOfDoors, typeOfDrive, trunkCapacity);
    }

    private LightCommercialCar createLightCommercialCar() {
        String registrationNumber = "RegistrationNumber";
        String brand = "Brand";
        String model = "Model";
        int seats = 4;
        boolean airConditioning = true;
        Transmission transmission = Transmission.AUTOMATIC;
        User user = null;
        double payload = 250;
        double loadVolume = 20;
        double loadHeight = 3;
        double loadWidth = 2;
        double loadLegth = 6;

        return new LightCommercialCar(registrationNumber, brand, model, seats, airConditioning, transmission, user,
                payload, loadVolume, loadHeight, loadWidth, loadLegth);
    }
}