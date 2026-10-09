package com.enterprise.array;

import com.enterprise.array.entity.CustomArray;
import com.enterprise.array.exception.CustomArrayException;
import com.enterprise.array.factory.ArrayFactory;
import com.enterprise.array.factory.impl.ArrayFactoryImpl;
import com.enterprise.array.parser.ArrayParser;
import com.enterprise.array.reader.CustomFileReader;
import com.enterprise.array.service.ArrayService;
import com.enterprise.array.service.impl.ArrayServiceImpl;
import com.enterprise.array.validator.ArrayDataValidator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.OptionalInt;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        CustomFileReader reader = new CustomFileReader();
        ArrayDataValidator validator = new ArrayDataValidator();
        ArrayParser parser = new ArrayParser();
        ArrayFactory factory = new ArrayFactoryImpl();
        ArrayService service = new ArrayServiceImpl();

        String filePath = "data/input.txt";

        try {
            List<String> lines = reader.readLines(filePath);
            for (String line : lines) {
                boolean valid = validator.isValidLine(line);
                if (valid) {
                    int[] numbers = parser.parseLine(line);
                    CustomArray customArray = factory.createArray(numbers);

                    OptionalInt sum = service.calculateSum(customArray);
                    OptionalInt max = service.findMax(customArray);

                    LOGGER.info("Array created successfully from line: {}", line);
                    LOGGER.info("Array sum: {}", sum);
                    LOGGER.info("Array max: {}", max);
                    break;
                } else {
                    LOGGER.warn("Invalid line skipped: {}", line);
                }
            }
        } catch (CustomArrayException e) {
            LOGGER.error("Error processing file: {}", filePath, e);
        }
    }
}