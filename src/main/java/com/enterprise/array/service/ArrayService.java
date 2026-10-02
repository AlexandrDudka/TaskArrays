package com.enterprise.array.service;

import com.enterprise.array.entity.CustomArray;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayService {

    OptionalInt findMin(CustomArray customArray);
    OptionalInt findMax(CustomArray customArray);

    OptionalDouble calculateAverage(CustomArray customArray);

}
