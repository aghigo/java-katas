package dev.andreghigo.katas.java.util.function;

import static org.junit.Assert.assertEquals;

import java.util.function.DoubleFunction;

import org.junit.Test;

public class DoubleFunctionTest {
	@Test
	public void applyAsDouble() {
		// The generic type is the return type
		DoubleFunction<String> convertDoubleToString = d -> Double.toString(d);
		
		// the method is apply, not applyAsDouble like in ToDoubleFunction
		String result = convertDoubleToString.apply(1D);
		
		assertEquals("1.0", result);
	}
}
