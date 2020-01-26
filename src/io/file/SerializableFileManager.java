package io.file;

import exceptions.ExportDataException;
import exceptions.ImportDataException;
import model.CarRental;
import model.FileCarRental;

import java.io.*;

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

    public FileCarRental importData() {
        try(
                FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                ) {
            return (FileCarRental) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException ex) {
            throw new ImportDataException("Problem with import data from: " + FILE_NAME);
        }
    }
}
