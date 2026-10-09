package com.enterprise.array.service;

import com.enterprise.array.entity.CustomArray;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayService {

    OptionalInt findMin(CustomArray customArray);
    OptionalInt findMax(CustomArray customArray);
    OptionalInt calculateSum(CustomArray customArray);
    OptionalDouble calculateAverage(CustomArray customArray);

    int countPositive(CustomArray customArray);
    int countNegative(CustomArray customArray);

    void replaceNegativeWithZero(CustomArray customArray);

    void sortBubble(CustomArray customArray);
    void sortSelection(CustomArray customArray);
}