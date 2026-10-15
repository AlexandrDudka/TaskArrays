package com.enterprise.array.entity;

public class CustomArrayStatistics {

    private final int sum;
    private final double average;
    private final int min;
    private final int max;

    public CustomArrayStatistics(int sum, double average, int min, int max) {
        this.sum = sum;
        this.average = average;
        this.min = min;
        this.max = max;
    }

    public int getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomArrayStatistics that = (CustomArrayStatistics) o;
        return sum == that.sum
                && Double.compare(that.average, average) == 0
                && min == that.min
                && max == that.max;
    }

    @Override
    public int hashCode() {
        int result = sum;
        long temp = Double.doubleToLongBits(average);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + min;
        result = 31 * result + max;
        return result;
    }

    @Override
    public String toString() {
        return "CustomArrayStatistics{"
                + "sum=" + sum
                + ", average=" + average
                + ", min=" + min
                + ", max=" + max
                + '}';
    }
}