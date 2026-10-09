package com.enterprise.array.reader;

import com.enterprise.array.exception.CustomArrayException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CustomFileReader {

    public List<String> readLines(String filePath) throws CustomArrayException {
        if (filePath == null) {
            throw new CustomArrayException("File path cannot be null");
        }

        Path path = Paths.get(filePath);
        boolean exists = Files.exists(path);

        if (exists) {
            try {
                return Files.readAllLines(path);
            } catch (IOException e) {
                throw new CustomArrayException("Error reading file: " + filePath, e);
            }
        } else {
            throw new CustomArrayException("File not found at path: " + filePath);
        }
    }
}