package dev.andreghigo.katas.java.util.function;

import static org.junit.Assert.assertEquals;

import java.util.function.DoubleToIntFunction;

import org.junit.Test;

public class DoubleToIntFunctionTest {
	@Test
	public void applyAsInt() {
		DoubleToIntFunction intPart = d -> (int) d;
		
		double value = 3.1415;
		
		int result = intPart.applyAsInt(value);
		
		assertEquals(3, result);
	}
}
