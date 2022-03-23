package com.example.springbootdemo.component.sort;

import org.springframework.stereotype.Component;

@Component
public interface SortAlgorithm {

    int[] sort(int[] array);

}
