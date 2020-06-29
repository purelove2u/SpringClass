package com.spring.factorial;

import org.springframework.stereotype.Component;

@Component("forc")
public class ForCalculator implements Calculator {
	@Override
	public long factorial(long num) {
		// for 문으로 구하는 factorial
		long result = 1;
		for(int i = 1; i <= num; i++) {
			result = result * i;
		}
		return result;
	}
}