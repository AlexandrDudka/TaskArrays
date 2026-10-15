package com.enterprise.array.specification.impl;

import com.enterprise.array.entity.CustomArray;
import com.enterprise.array.specification.CustomArraySpecification;

public class IdSpecification implements CustomArraySpecification {

    private final long targetId;

    public IdSpecification(long targetId) {
        this.targetId = targetId;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        if (customArray == null) {
            return false;
        }
        return customArray.getId() == targetId;
    }
}
