package io.file;

import model.CarRental;

public interface FileManager {
    void exportData(CarRental carRental);
    CarRental importData();
}
