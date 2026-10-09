package com.enterprise.array.entity;

import java.util.Arrays;

public class CustomArray {

    private int[] array;

    public CustomArray() {
        this.array = new int[0];
    }

    public CustomArray(int[] array) {
        if (array != null) {
            this.array = array.clone();
        } else {
            this.array = new int[0];
        }
    }

    public int[] getArray() {
        return array.clone();
    }

    public void setArray(int[] array) {
        if (array != null) {
            this.array = array.clone();
        } else {
            this.array = new int[0];
        }
    }

    public int getLength() {
        int[] currentArray = this.array;
        return currentArray.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomArray that = (CustomArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}