package io.file;

import exceptions.NoSuchTypeException;
import io.DataReader;

public class FileManagerFactory {
    private DataReader dataReader;

    public FileManagerFactory(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    public FileManager buildFileManager() {
        FileType fileType = getFileType();
        switch (fileType) {
            case CSV:
                return new CsvFileManager();
            case SERIALIZABLE:
                return new SerializableFileManager();
            default:
                return null;
        }
    }

    private FileType getFileType() {
        boolean optionOk = false;
        FileType fileType = null;
        while (!optionOk) {
            try {
                System.out.println("Select file type: ");
                printOptions();
                fileType = FileType.getFileTypeFromDescription(dataReader.getString());
                optionOk = true;
            }catch (NoSuchTypeException ex) {
                ex.getMessage();
            }
        }

        return fileType;
    }

    private void printOptions() {
        for (FileType fileType : FileType.values()) {
            System.out.println(fileType);
        }
    }
}
