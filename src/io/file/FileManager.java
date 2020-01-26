package io.file;

import model.CarRental;
import model.FileCarRental;

public interface FileManager {
    void exportData(CarRental carRental);
    FileCarRental importData();
}
