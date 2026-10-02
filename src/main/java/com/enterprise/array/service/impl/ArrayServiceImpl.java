package com.enterprise.array.service.impl;

import com.enterprise.array.entity.CustomArray;
import com.enterprise.array.service.ArrayService;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayServiceImpl implements ArrayService {

    @Override
    public OptionalInt findMin(CustomArray customArray){
        if (customArray == null) {
            return OptionalInt.empty();
        }

        int[] array = customArray.getArray();

        if (array == null) {
            return OptionalInt.empty();
        }

        int length = array.length;
        if (length == 0){
            return OptionalInt.empty();
        }

        int min = array[0];
        for (int i = 1; i < length; i++) {
            int current = array[i];
            if (current < min){
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

        if (array == null) {
            return OptionalInt.empty();
        }

        int length = array.length;
        if (length == 0){
            return OptionalInt.empty();
        }

        int max = array[0];
        for (int i = 1; i < length; i++) {
            int current = array[i];
            if (current > max){
                max = current;
            }
        }

        return OptionalInt.of(max);
    }

    @Override
    public OptionalDouble calculateAverage(CustomArray customArray){

        if (customArray == null){
            return OptionalDouble.empty();
        }

        int[] array = customArray.getArray();

        if (array == null){
            return OptionalDouble.empty();
        }

        int length = array.length;
        if (length == 0){
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
}
