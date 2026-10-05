package com.enterprise.array.validator;

public class ArrayDataValidator {

    private static final String VALID_LINE_REGEX = "^(\\s*-?\\d+\\s*[,;\\-\\s]?\\s*)+$";

    public boolean isValidLine(String line) {
        if (line == null) {
            return false;
        }

        String trimmedLine = line.trim();
        boolean isEmpty = trimmedLine.isEmpty();
        if (isEmpty) {
            return false;
        }

        return trimmedLine.matches(VALID_LINE_REGEX);
    }
}
