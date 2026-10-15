package com.enterprise.array.repository;

import com.enterprise.array.entity.CustomArray;
import com.enterprise.array.specification.CustomArraySpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomArrayRepository {

    private static CustomArrayRepository instance;
    private final List<CustomArray> items;

    private CustomArrayRepository() {
        this.items = new ArrayList<>();
    }

    public static CustomArrayRepository getInstance() {
        if (instance == null) {
            instance = new CustomArrayRepository();
        }
        return instance;
    }

    public boolean add(CustomArray customArray) {
        if (customArray != null && !items.contains(customArray)) {
            return items.add(customArray);
        }
        return false;
    }

    public boolean remove(CustomArray customArray) {
        if (customArray != null) {
            return items.remove(customArray);
        }
        return false;
    }

    public CustomArray get(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public List<CustomArray> query(CustomArraySpecification specification) {
        List<CustomArray> result = new ArrayList<>();
        if (specification == null) {
            return result;
        }

        for (CustomArray item : items) {
            boolean matches = specification.specify(item);
            if (matches) {
                result.add(item);
            }
        }
        return result;
    }

    public List<CustomArray> sort(Comparator<CustomArray> comparator) {
        List<CustomArray> sortedList = new ArrayList<>(items);
        if (comparator != null) {
            sortedList.sort(comparator);
        }
        return sortedList;
    }

    public int size() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }
}