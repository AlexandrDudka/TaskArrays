package com.enterprise.array.parser;

public class ArrayParser {

    private static final String DELIMITER_REGEX = "[,;\\s]+|(?<=\\d)\\s*-\\s*";

    public int[] parseLine(String line) {
        if (line == null) {
            return new int[0];
        }

        String trimmed = line.trim();
        if (trimmed.isEmpty()) {
            return new int[0];
        }

        String[] tokens = trimmed.split(DELIMITER_REGEX);
        int length = tokens.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            String token = tokens[i].trim();
            if (!token.isEmpty()) {
                int value = Integer.parseInt(token);
                result[i] = value;
            }
        }

        return result;
    }
}