package com.example.springbootdemo;

import com.example.springbootdemo.app.SpringBootDemoApplication;
import com.example.springbootdemo.component.sort.SortingImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {SpringBootDemoApplication.class})
@SpringBootTest
class SpringBootDemoApplicationTests {

	@Autowired
	SortingImpl sortingImpl;

	@Test
	void sort() {
		int [] numbers = new int[] {12,2,32,1,5,222,32};
		assertArrayEquals (new int[]{1,2,5,12,32,32,222}, sortingImpl.sortArray(numbers));
	}

}
