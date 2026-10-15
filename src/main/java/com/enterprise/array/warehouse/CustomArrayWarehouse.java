package com.enterprise.array.warehouse;

import com.enterprise.array.entity.CustomArrayStatistics;

import java.util.HashMap;
import java.util.Map;

public class CustomArrayWarehouse {

    private static CustomArrayWarehouse instance;
    private final Map<Long, CustomArrayStatistics> map;

    private CustomArrayWarehouse() {
        this.map = new HashMap<>();
    }

    public static CustomArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new CustomArrayWarehouse();
        }
        return instance;
    }

    public CustomArrayStatistics put(long id, CustomArrayStatistics statistics) {
        return map.put(id, statistics);
    }

    public CustomArrayStatistics get(long id) {
        return map.get(id);
    }

    public CustomArrayStatistics remove(long id) {
        return map.remove(id);
    }

    public boolean containsKey(long id) {
        return map.containsKey(id);
    }

    public void clear() {
        map.clear();
    }
}