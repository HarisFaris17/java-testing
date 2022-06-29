package com.example.testing;

// import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
class TestingApplicationTests {

	Calculator calculator = new Calculator();

	@Test
	void addNumber() {
		int a=1;
		int b=2;
		int add = calculator.add(a, b);
		assertThat(add).isEqualTo(3);
	}

	class Calculator{
		public int add(final int a,final int b){
			return a+b;
		}
	}

}
