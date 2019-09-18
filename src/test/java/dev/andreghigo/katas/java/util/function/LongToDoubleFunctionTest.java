package dev.andreghigo.katas.java.util.function;

import static org.junit.Assert.assertEquals;

import java.util.function.LongToDoubleFunction;

import org.junit.Test;

public class LongToDoubleFunctionTest {
	@Test
	public void applyAsDouble() {
		LongToDoubleFunction divideByPI = l -> (double) l / Math.PI;
		
		long value = 123123122322L;
		
		double result = divideByPI.applyAsDouble(value);
		
		assertEquals(value / Math.PI, result, 0.0001);
	}
}
