package com.enterprise.array.specification.impl;

import com.enterprise.array.entity.CustomArray;
import com.enterprise.array.specification.CustomArraySpecification;

public class NameSpecification implements CustomArraySpecification {

    private final String targetName;

    public NameSpecification(String targetName) {
        this.targetName = targetName;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        if (customArray == null || targetName == null) {
            return false;
        }
        return targetName.equals(customArray.getName());
    }
}