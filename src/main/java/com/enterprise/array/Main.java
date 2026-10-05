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

import java.util.List;
import java.util.OptionalInt;

public class Main {

    public static void main(String[] args) {
        CustomFileReader reader = new CustomFileReader();
        ArrayDataValidator validator = new ArrayDataValidator();
        ArrayParser parser = new ArrayParser();
        ArrayFactory factory = new ArrayFactoryImpl();
        ArrayService service = new ArrayServiceImpl();

        String filePath = "data/input.txt";

        try {
            List lines = reader.readLines(filePath);
            for (Object line : lines) {
                if (validator.isValidLine((String) line)) {
                    int[] numbers = parser.parseLine((String) line);
                    CustomArray customArray = factory.createArray(numbers);

                    int sum = service.sum(customArray);
                    OptionalInt max = service.findMax(customArray);

                    System.out.println("Массив успешно создан из строки: " + line);
                    System.out.println("Сумма элементов: " + sum);
                    System.out.println("Максимальный элемент: " + max);
                    break;
                }
            }
        } catch (CustomArrayException e) {
            System.err.println("Ошибка при обработке файла: " + e.getMessage());
        }
    }
}
