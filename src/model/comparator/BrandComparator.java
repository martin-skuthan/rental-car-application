package model.comparator;

import model.Car;

import java.util.Comparator;

public class BrandComparator implements Comparator<Car>{
    @Override
    public int compare(Car c1, Car c2) {
        if (c1 == null && c2 == null) {
            return 0;
        }

        if (c1 == null) {
            return 1;
        }

        if (c2 == null) {
            return -1;
        }

        return c1.getBrand().compareToIgnoreCase(c2.getBrand());
    }
}
