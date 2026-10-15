package com.enterprise.array.specification.impl;

import com.enterprise.array.entity.CustomArray;
import com.enterprise.array.entity.CustomArrayStatistics;
import com.enterprise.array.specification.CustomArraySpecification;
import com.enterprise.array.warehouse.CustomArrayWarehouse;

public class SumGreaterThanSpecification implements CustomArraySpecification {

    private final int thresholdSum;

    public SumGreaterThanSpecification(int thresholdSum) {
        this.thresholdSum = thresholdSum;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        if (customArray == null) {
            return false;
        }
        long id = customArray.getId();
        CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
        CustomArrayStatistics stats = warehouse.get(id);

        if (stats == null) {
            return false;
        }
        return stats.getSum() > thresholdSum;
    }
}