package dev.andreghigo.katas.java.util.function;

import static org.junit.Assert.assertEquals;

import java.util.function.IntToLongFunction;

import org.junit.Test;

public class IntToLongFunctionTest {
	@Test
	public void applyAsLong() {
		IntToLongFunction multiplyByTenMillion = i -> i * 10000000;
		
		int value = 3;
		
		long result = multiplyByTenMillion.applyAsLong(value);
		
		assertEquals(30000000L, result);
	}
}
