package com.enterprise.array.entity;

public class CustomArray {

    private int[] array;

    public CustomArray() {
        this.array = new int[0];
    }

    public CustomArray(int[] array){
        this.array = array;
    }

    public int[] getArray(){
        return array;
    }

    public void setArray(int[] array){
        this.array = array;
    }

    public int getLength(){
        int[] currentArray = this.array;
        int length = currentArray.length;
        return length;
    }
}
