package com.enterprise.array.entity;

import com.enterprise.array.observer.CustomArrayObservable;
import com.enterprise.array.observer.CustomArrayObserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomArray implements CustomArrayObservable {

    private final long id;
    private String name;
    private int[] array;
    private final List<CustomArrayObserver> observers;

    public CustomArray() {
        this(0L, "DefaultName", new int[0]);
    }

    public CustomArray(int[] array) {
        this(0L, "DefaultName", array);
    }

    public CustomArray(long id, String name, int[] array) {
        this.id = id;
        this.name = name;
        if (array != null) {
            this.array = array.clone();
        } else {
            this.array = new int[0];
        }
        this.observers = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        notifyObservers();
    }

    public void setElement(int index, int value) {
        if (index >= 0 && index < array.length) {
            array[index] = value;
            notifyObservers();
        }
    }

    public int getLength() {
        return array.length;
    }

    @Override
    public void attach(CustomArrayObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(CustomArrayObserver observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (CustomArrayObserver observer : observers) {
            observer.changeElement(this);
        }
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
        if (id != that.id) {
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        int nameHash = name != null ? name.hashCode() : 0;
        result = 31 * result + nameHash;
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return "CustomArray{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", array=" + Arrays.toString(array)
                + '}';
    }
}