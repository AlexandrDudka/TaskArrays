package com.enterprise.array.comparator;

import com.enterprise.array.entity.CustomArray;

import java.util.Comparator;

public enum CustomArrayComparator implements Comparator<CustomArray> {

    BY_ID {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    },

    BY_NAME {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            String name1 = o1.getName();
            String name2 = o2.getName();
            if (name1 == null) {
                return name2 == null ? 0 : -1;
            }
            if (name2 == null) {
                return 1;
            }
            return name1.compareTo(name2);
        }
    },

    BY_LENGTH {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            return Integer.compare(o1.getLength(), o2.getLength());
        }
    },

    BY_FIRST_ELEMENT {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            int[] arr1 = o1.getArray();
            int[] arr2 = o2.getArray();

            if (arr1.length == 0 && arr2.length == 0) {
                return 0;
            }
            if (arr1.length == 0) {
                return -1;
            }
            if (arr2.length == 0) {
                return 1;
            }
            return Integer.compare(arr1[0], arr2[0]);
        }
    }
}