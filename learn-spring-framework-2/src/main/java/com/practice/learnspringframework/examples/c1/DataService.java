package com.practice.learnspringframework.examples.c1;
import org.springframework.stereotype.Component;

@Component
public interface DataService {
	public int[] retrieveData();
}
