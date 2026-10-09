package com.enterprise.array.service.impl;

import com.enterprise.array.entity.CustomArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayServiceImplTest {

    private ArrayServiceImpl service;
    private static final int[] TEST_NUMBERS = {5, 2, -3, 8, 1};
    private static final int[] SORTED_NUMBERS = {-3, 1, 2, 5, 8};

    @BeforeEach
    void setUp() {
        service = new ArrayServiceImpl();
    }

    @Test
    void findMinShouldReturnMinimumValueWhenArrayIsNotEmpty() {
        // Given
        CustomArray customArray = new CustomArray(TEST_NUMBERS);

        // When
        OptionalInt result = service.findMin(customArray);

        // Then
        assertTrue(result.isPresent());
        assertEquals(-3, result.getAsInt());
    }

    @Test
    void findMaxShouldReturnMaximumValueWhenArrayIsNotEmpty() {
        // Given
        CustomArray customArray = new CustomArray(TEST_NUMBERS);

        // When
        OptionalInt result = service.findMax(customArray);

        // Then
        assertTrue(result.isPresent());
        assertEquals(8, result.getAsInt());
    }

    @Test
    void calculateSumShouldReturnCorrectSumWhenArrayIsNotEmpty() {
        // Given
        CustomArray customArray = new CustomArray(TEST_NUMBERS);

        // When
        OptionalInt result = service.calculateSum(customArray);

        // Then
        assertTrue(result.isPresent());
        assertEquals(13, result.getAsInt());
    }

    @Test
    void calculateAverageShouldReturnCorrectAverageWhenArrayIsNotEmpty() {
        // Given
        CustomArray customArray = new CustomArray(TEST_NUMBERS);

        // When
        OptionalDouble result = service.calculateAverage(customArray);

        // Then
        assertTrue(result.isPresent());
        assertEquals(2.6, result.getAsDouble(), 0.0001);
    }

    @Test
    void sortBubbleShouldSortArrayInAscendingOrder() {
        // Given
        CustomArray customArray = new CustomArray(TEST_NUMBERS);
        CustomArray expectedArray = new CustomArray(SORTED_NUMBERS);

        // When
        service.sortBubble(customArray);

        // Then
        assertEquals(expectedArray, customArray);
    }
}