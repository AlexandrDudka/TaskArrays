package com.enterprise.array.service.impl;

import com.enterprise.array.entity.CustomArray;
import com.enterprise.array.service.ArrayService;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayServiceImpl implements ArrayService {

    @Override
    public OptionalInt findMin(CustomArray customArray) {
        if (customArray == null) {
            return OptionalInt.empty();
        }

        int[] array = customArray.getArray();
        int length = array.length;
        if (length == 0) {
            return OptionalInt.empty();
        }

        int min = array[0];
        for (int i = 1; i < length; i++) {
            int current = array[i];
            if (current < min) {
                min = current;
            }
        }

        return OptionalInt.of(min);
    }

    @Override
    public OptionalInt findMax(CustomArray customArray) {
        if (customArray == null) {
            return OptionalInt.empty();
        }

        int[] array = customArray.getArray();
        int length = array.length;
        if (length == 0) {
            return OptionalInt.empty();
        }

        int max = array[0];
        for (int i = 1; i < length; i++) {
            int current = array[i];
            if (current > max) {
                max = current;
            }
        }

        return OptionalInt.of(max);
    }

    @Override
    public OptionalInt calculateSum(CustomArray customArray) {
        if (customArray == null) {
            return OptionalInt.empty();
        }

        int[] array = customArray.getArray();
        int length = array.length;
        if (length == 0) {
            return OptionalInt.empty();
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            int current = array[i];
            sum = sum + current;
        }

        return OptionalInt.of(sum);
    }

    @Override
    public OptionalDouble calculateAverage(CustomArray customArray) {
        if (customArray == null) {
            return OptionalDouble.empty();
        }

        int[] array = customArray.getArray();
        int length = array.length;
        if (length == 0) {
            return OptionalDouble.empty();
        }

        double sum = 0;
        for (int i = 0; i < length; i++) {
            int current = array[i];
            sum = sum + current;
        }

        double average = sum / length;
        return OptionalDouble.of(average);
    }

    @Override
    public int countPositive(CustomArray customArray) {
        if (customArray == null) {
            return 0;
        }

        int[] array = customArray.getArray();
        int length = array.length;
        int count = 0;

        for (int i = 0; i < length; i++) {
            int current = array[i];
            if (current > 0) {
                count = count + 1;
            }
        }

        return count;
    }

    @Override
    public int countNegative(CustomArray customArray) {
        if (customArray == null) {
            return 0;
        }

        int[] array = customArray.getArray();
        int length = array.length;
        int count = 0;

        for (int i = 0; i < length; i++) {
            int current = array[i];
            if (current < 0) {
                count = count + 1;
            }
        }

        return count;
    }

    @Override
    public void replaceNegativeWithZero(CustomArray customArray) {
        if (customArray == null) {
            return;
        }

        int[] array = customArray.getArray();
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int current = array[i];
            if (current < 0) {
                array[i] = 0;
            }
        }

        customArray.setArray(array);
    }

    @Override
    public void sortBubble(CustomArray customArray) {
        if (customArray == null) {
            return;
        }

        int[] array = customArray.getArray();
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                int first = array[j];
                int second = array[j + 1];
                if (first > second) {
                    array[j] = second;
                    array[j + 1] = first;
                }
            }
        }

        customArray.setArray(array);
    }

    @Override
    public void sortSelection(CustomArray customArray) {
        if (customArray == null) {
            return;
        }

        int[] array = customArray.getArray();
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                int current = array[j];
                int minVal = array[minIndex];
                if (current < minVal) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        customArray.setArray(array);
    }
}