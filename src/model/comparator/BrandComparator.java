package model.comparator;

import model.Car;

import java.util.Comparator;

public class BrandComparator implements Comparator<Car>{
    @Override
    public int compare(Car c1, Car c2) {
        return c1.getBrand().compareToIgnoreCase(c2.getBrand());
    }
}
