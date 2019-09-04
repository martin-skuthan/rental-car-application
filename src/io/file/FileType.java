package io.file;

import exceptions.NoSuchTypeException;

public enum FileType {
    CSV,
    SERIALIZABLE;

    public static FileType getFileTypeFromDescription(String description) {
        try {
            return FileType.valueOf(description.toUpperCase());
        }catch (IllegalArgumentException ex) {
            throw new NoSuchTypeException("There is no file type: " + description);
        }
    }
}
