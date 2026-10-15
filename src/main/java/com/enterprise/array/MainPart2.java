package com.enterprise.array;

import com.enterprise.array.comparator.CustomArrayComparator;
import com.enterprise.array.entity.CustomArray;
import com.enterprise.array.entity.CustomArrayStatistics;
import com.enterprise.array.observer.CustomArrayObserver;
import com.enterprise.array.observer.impl.CustomArrayObserverImpl;
import com.enterprise.array.repository.CustomArrayRepository;
import com.enterprise.array.specification.CustomArraySpecification;
import com.enterprise.array.specification.impl.NameSpecification;
import com.enterprise.array.specification.impl.SumGreaterThanSpecification;
import com.enterprise.array.warehouse.CustomArrayWarehouse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MainPart2 {

    private static final Logger LOGGER = LogManager.getLogger(MainPart2.class);

    public static void main(String[] args) {
        CustomArrayObserver observer = new CustomArrayObserverImpl();
        CustomArrayRepository repository = CustomArrayRepository.getInstance();
        CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();

        CustomArray array1 = new CustomArray(101L, "Array Alpha", new int[]{10, 20, 30});
        CustomArray array2 = new CustomArray(102L, "Array Beta", new int[]{5, -2, 10, 1});

        array1.attach(observer);
        array2.attach(observer);

        observer.changeElement(array1);
        observer.changeElement(array2);

        repository.add(array1);
        repository.add(array2);

        LOGGER.info("Warehouse initial state for 101: {}", warehouse.get(101L));
        LOGGER.info("Warehouse initial state for 102: {}", warehouse.get(102L));

        array1.setElement(0, 100);

        CustomArrayStatistics updatedStats = warehouse.get(101L);
        LOGGER.info("Warehouse updated state after mutation for 101: {}", updatedStats);

        CustomArraySpecification sumSpec = new SumGreaterThanSpecification(50);
        List<CustomArray> sumQueryResults = repository.query(sumSpec);
        LOGGER.info("Query sum > 50 count: {}", sumQueryResults.size());

        CustomArraySpecification nameSpec = new NameSpecification("Array Beta");
        List<CustomArray> nameQueryResults = repository.query(nameSpec);
        LOGGER.info("Query name 'Array Beta' found: {}", nameQueryResults.get(0));

        List<CustomArray> sortedByLength = repository.sort(CustomArrayComparator.BY_LENGTH);
        LOGGER.info("Sorted by length first item: {}", sortedByLength.get(0).getName());
    }
}