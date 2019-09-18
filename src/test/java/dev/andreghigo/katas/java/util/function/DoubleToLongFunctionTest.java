package dev.andreghigo.katas.java.util.function;

import static org.junit.Assert.assertEquals;

import java.util.function.DoubleToLongFunction;

import org.junit.Test;

public class DoubleToLongFunctionTest {
	@Test
	public void applyAsLong() {
		DoubleToLongFunction multiplyBy1000IgnoringDecimalPart = d -> (long) d * 1000;
		
		double value = 1232323232323.034352324;
		
		long result = multiplyBy1000IgnoringDecimalPart.applyAsLong(value);
		
		assertEquals(1232323232323000L, result);
	}
}
