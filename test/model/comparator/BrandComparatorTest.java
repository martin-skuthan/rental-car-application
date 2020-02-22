package model.comparator;

import model.PassengerCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandComparatorTest {
    private BrandComparator brandComparator;

    @BeforeEach
    void setUp() {
        brandComparator = new BrandComparator();
    }

    @Test
    void firstValueShouldBeBeforeSecondInSeries() {
        PassengerCar passengerCarFirst = new PassengerCar();
        PassengerCar passengerCarSecond = new PassengerCar();
        passengerCarFirst.setBrand("Audi");
        passengerCarSecond.setBrand("Opel");
        int result = brandComparator.compare(passengerCarFirst, passengerCarSecond);
        assertTrue(result <= -1);
    }

    @Test
    void secondValueShouldBeforeFirstInSeries() {
        PassengerCar passengerCarFirst = new PassengerCar();
        PassengerCar passengerCarSecond = new PassengerCar();
        passengerCarFirst.setBrand("Opel");
        passengerCarSecond.setBrand("Audi");
        int result = brandComparator.compare(passengerCarFirst, passengerCarSecond);
        assertTrue(result >= 1);
    }

    @Test
    void bothValuesShouldBeEqual() {
        PassengerCar passengerCarFirst = new PassengerCar();
        PassengerCar passengerCarSecond = new PassengerCar();
        passengerCarFirst.setBrand("Opel");
        passengerCarSecond.setBrand("Opel");
        int result = brandComparator.compare(passengerCarFirst, passengerCarSecond);
        assertTrue(result == 0);
    }
}