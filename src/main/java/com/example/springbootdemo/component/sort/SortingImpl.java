package com.example.springbootdemo.component.sort;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SortingImpl {

    private final SortAlgorithm sortAlgorithm;

    public SortingImpl(@Qualifier("merge")SortAlgorithm sortAlgorithm) {
        super();
        this.sortAlgorithm = sortAlgorithm;
    }

    public int[] sortArray(int[] numberArray){
        sortAlgorithm.sort(numberArray);
        System.out.println(sortAlgorithm);

        return numberArray;
    }
}
