package com.enterprise.array.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import com.enterprise.array.exception.CustomArrayException;

public class CustomFileReader {

    public List readLines(String filePath) throws CustomArrayException {
        if (filePath == null) {
            throw new CustomArrayException("File path cannot be null");
        }

        Path path = Paths.get(filePath);
        boolean exists = Files.exists(path);
        if (!exists) {
            throw new CustomArrayException("File not found at path: " + filePath);
        }

        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new CustomArrayException("Error reading file: " + filePath, e);
        }
    }
}
