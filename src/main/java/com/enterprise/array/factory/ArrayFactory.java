package com.enterprise.array.factory;

import com.enterprise.array.entity.CustomArray;

public interface ArrayFactory {
    CustomArray createArray(int[] array);
    CustomArray createArray(int size);
}