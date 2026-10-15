package com.enterprise.array.observer.impl;

import com.enterprise.array.entity.CustomArray;
import com.enterprise.array.entity.CustomArrayStatistics;
import com.enterprise.array.observer.CustomArrayObserver;
import com.enterprise.array.service.ArrayService;
import com.enterprise.array.service.impl.ArrayServiceImpl;
import com.enterprise.array.warehouse.CustomArrayWarehouse;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayObserverImpl implements CustomArrayObserver {

    private final ArrayService service;

    public CustomArrayObserverImpl() {
        this.service = new ArrayServiceImpl();
    }

    @Override
    public void changeElement(CustomArray customArray) {
        if (customArray == null) {
            return;
        }

        long id = customArray.getId();

        OptionalInt sumOpt = service.calculateSum(customArray);
        OptionalDouble avgOpt = service.calculateAverage(customArray);
        OptionalInt minOpt = service.findMin(customArray);
        OptionalInt maxOpt = service.findMax(customArray);

        int sum = sumOpt.orElse(0);
        double avg = avgOpt.orElse(0.0);
        int min = minOpt.orElse(0);
        int max = maxOpt.orElse(0);

        CustomArrayStatistics statistics = new CustomArrayStatistics(sum, avg, min, max);
        CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
        warehouse.put(id, statistics);
    }
}