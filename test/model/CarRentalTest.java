package model;

import exceptions.CarAlreadyExistsException;
import exceptions.UserAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CarRentalTest {
    private static final String REGISTRATION_NUMBER = "00000";
    private static final String PESEL = "00000000000";

    private CarRental fileCarRental;
    private Car car;
    private CarRentalUser user;

    @BeforeEach
    void setUp() {
        fileCarRental = new FileCarRental();
        car = new PassengerCar();
        user = new CarRentalUser();
    }

    @Test
    void shouldThrowExceptionWhenAddingCarWithNullRegistrationNumber() {
        final String exceptedExceptionMessage = "Registration number cannot be null";
        assertEquals(exceptedExceptionMessage, assertThrows(NullPointerException.class, () -> fileCarRental.addCar(car)).getMessage());
    }

    @Test
    void shouldThrowExceptionWhenAddingCarWhichAlreadyExistsInCarRental() {
        final String exceptedExceptionMessage = "Car with this registration number already exists";
        car.setRegistrationNumber(REGISTRATION_NUMBER);
        fileCarRental.addCar(car);
        assertEquals(exceptedExceptionMessage, assertThrows(CarAlreadyExistsException.class, () -> fileCarRental.addCar(car)).getMessage());
    }

    @Test
    void shouldAllowAddCarToCarRental() {
        car.setRegistrationNumber(REGISTRATION_NUMBER);
        Map<String, Car> cars = new HashMap<>();
        cars.put(car.getRegistrationNumber(), car);
        fileCarRental.addCar(car);
        assertEquals(cars, ((FileCarRental)fileCarRental).getCars());
    }

    @Test
    void shouldAllowRemoveCarFromCarRental() {
        car.setRegistrationNumber(REGISTRATION_NUMBER);
        fileCarRental.addCar(car);
        assertTrue(fileCarRental.removeCar(REGISTRATION_NUMBER));
    }

    @Test
    void shouldNotAllowRemoveCarFromCarRental() {
        assertFalse(fileCarRental.removeCar(REGISTRATION_NUMBER));
    }

    @Test
    void shouldThrowExceptionWhenAddingUserWithNullPesel() {
        final String exceptedExceptionMessage = "Pesel cannot be null";
        assertEquals(exceptedExceptionMessage, assertThrows(NullPointerException.class, () -> fileCarRental.addCarRentalUser(user)).getMessage());
    }

    @Test
    void shouldThrowExceptionWhenAddingUserWhichAlreadyExistsInCarRental() {
        final String exceptedExceptionMessage = "User with this pesel already exists";
        user.setPesel(PESEL);
        fileCarRental.addCarRentalUser(user);
        assertEquals(exceptedExceptionMessage, assertThrows(UserAlreadyExistsException.class, () -> fileCarRental.addCarRentalUser(user)).getMessage());
    }

    @Test
    void shouldAllowAddUserToCarRental() {
        user.setPesel(PESEL);
        Map<String, User> users = new HashMap<>();
        users.put(user.getPesel(), user);
        fileCarRental.addCarRentalUser(user);
        assertEquals(users, ((FileCarRental)fileCarRental).getCarRentalUsers());
    }

    @Test
    void shouldAllowRemoveUserFromCarRental() {
        user.setPesel(PESEL);
        fileCarRental.addCarRentalUser(user);
        assertTrue(fileCarRental.removeCarRentalUser(PESEL));
    }

    @Test
    void shouldNotAllowRemoveUserFromCarRental() {
        assertFalse(fileCarRental.removeCarRentalUser(PESEL));
    }
}