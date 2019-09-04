package io.file;

import exceptions.ExportDataException;
import exceptions.ImportDataException;
import model.Car;
import model.CarRental;

import java.io.*;
import java.util.Collection;
import java.util.Map;

public class SerializableFileManager implements FileManager {
    private static final String FILE_NAME = "CarRental.obj";

    public void exportData(CarRental carRental) {
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                ) {
            objectOutputStream.writeObject(carRental);
        }catch (IOException ex) {
            throw new ExportDataException("Problem with export data to:" + FILE_NAME);
        }
    }

    public CarRental importData() {
        try(
                FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                ) {
            return (CarRental) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException ex) {
            throw new ImportDataException("Problem with import data from: " + FILE_NAME);
        }
    }
}
