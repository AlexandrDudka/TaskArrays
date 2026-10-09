package com.enterprise.array.factory.impl;

import com.enterprise.array.entity.CustomArray;
import com.enterprise.array.factory.ArrayFactory;

public class ArrayFactoryImpl implements ArrayFactory {

    @Override
    public CustomArray createArray(int[] array) {
        return new CustomArray(array);
    }

    @Override
    public CustomArray createArray(int size) {
        int targetSize = size;
        if (size < 0) {
            targetSize = 0;
        }
        int[] emptyArray = new int[targetSize];
        return new CustomArray(emptyArray);
    }
}