package model.comparator;

import model.CarRentalUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserLastNameComparatorTest {
    private  UserLastNameComparator userLastNameComparator;

    @BeforeEach
    void setUp() {
        userLastNameComparator = new UserLastNameComparator();
    }

    @Test
    void firstValueShouldBeBeforeSecondInSeries() {
        CarRentalUser carRentalUserFirst = new CarRentalUser();
        CarRentalUser carRentalUserSecond = new CarRentalUser();
        carRentalUserFirst.setLastName("Cotrez");
        carRentalUserSecond.setLastName("Smith");
        int result = userLastNameComparator.compare(carRentalUserFirst, carRentalUserSecond);
        assertTrue(result <= -1);
    }

    @Test
    void secondValueShouldBeforeFirstInSeries() {
        CarRentalUser carRentalUserFirst = new CarRentalUser();
        CarRentalUser carRentalUserSecond = new CarRentalUser();
        carRentalUserFirst.setLastName("Smith");
        carRentalUserSecond.setLastName("Cotrez");
        int result = userLastNameComparator.compare(carRentalUserFirst, carRentalUserSecond);
        assertTrue(result >= 1);
    }

    @Test
    void bothValuesShouldBeEqual() {
        CarRentalUser carRentalUserFirst = new CarRentalUser();
        CarRentalUser carRentalUserSecond = new CarRentalUser();
        carRentalUserFirst.setLastName("Smith");
        carRentalUserSecond.setLastName("Smith");
        int result = userLastNameComparator.compare(carRentalUserFirst, carRentalUserSecond);
        assertTrue(result == 0);
    }

}