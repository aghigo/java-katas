package dev.andreghigo.katas.java.util.function;

import static org.junit.Assert.assertEquals;

import java.util.function.IntToDoubleFunction;

import org.junit.Test;

public class IntToDoubleFunctionTest {
	@Test
	public void applyAsDouble() {
		IntToDoubleFunction sumWithPI = i -> i + Math.PI;
		
		double result = sumWithPI.applyAsDouble(8);
		
		assertEquals(11.141592, result, 0.001);
	}
}
