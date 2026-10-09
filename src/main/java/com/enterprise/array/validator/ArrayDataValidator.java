package com.enterprise.array.validator;

public class ArrayDataValidator {

    private static final String VALID_LINE_REGEX = "^\\s*(-?\\d+\\s*([,;\\-\\s]+\\s*-?\\d+\\s*)*)?$";

    public boolean isValidLine(String line) {
        if (line != null) {
            String trimmedLine = line.trim();
            return trimmedLine.matches(VALID_LINE_REGEX);
        }
        return false;
    }
}